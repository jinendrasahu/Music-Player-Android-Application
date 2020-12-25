package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.LongCompanionObject;

public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected DiskLruCache cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File cacheDir, FileNameGenerator fileNameGenerator2, long cacheMaxSize) throws IOException {
        this(cacheDir, (File) null, fileNameGenerator2, cacheMaxSize, 0);
    }

    public LruDiskCache(File cacheDir, File reserveCacheDir2, FileNameGenerator fileNameGenerator2, long cacheMaxSize, int cacheMaxFileCount) throws IOException {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (cacheDir == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (cacheMaxSize < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        } else if (cacheMaxFileCount < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        } else if (fileNameGenerator2 != null) {
            cacheMaxSize = cacheMaxSize == 0 ? LongCompanionObject.MAX_VALUE : cacheMaxSize;
            cacheMaxFileCount = cacheMaxFileCount == 0 ? Integer.MAX_VALUE : cacheMaxFileCount;
            this.reserveCacheDir = reserveCacheDir2;
            this.fileNameGenerator = fileNameGenerator2;
            initCache(cacheDir, reserveCacheDir2, cacheMaxSize, cacheMaxFileCount);
        } else {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
    }

    private void initCache(File cacheDir, File reserveCacheDir2, long cacheMaxSize, int cacheMaxFileCount) throws IOException {
        try {
            this.cache = DiskLruCache.open(cacheDir, 1, 1, cacheMaxSize, cacheMaxFileCount);
        } catch (IOException e) {
            L.e(e);
            if (reserveCacheDir2 != null) {
                initCache(reserveCacheDir2, (File) null, cacheMaxSize, cacheMaxFileCount);
            }
            if (this.cache == null) {
                throw e;
            }
        }
    }

    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public File get(String imageUri) {
        DiskLruCache.Snapshot snapshot = null;
        File file = null;
        try {
            DiskLruCache.Snapshot snapshot2 = this.cache.get(getKey(imageUri));
            if (snapshot2 != null) {
                file = snapshot2.getFile(0);
            }
            if (snapshot2 != null) {
                snapshot2.close();
            }
            return file;
        } catch (IOException e) {
            L.e(e);
            if (snapshot != null) {
                snapshot.close();
            }
            return null;
        } catch (Throwable th) {
            if (snapshot != null) {
                snapshot.close();
            }
            throw th;
        }
    }

    public boolean save(String imageUri, InputStream imageStream, IoUtils.CopyListener listener) throws IOException {
        DiskLruCache.Editor editor = this.cache.edit(getKey(imageUri));
        if (editor == null) {
            return false;
        }
        OutputStream os = new BufferedOutputStream(editor.newOutputStream(0), this.bufferSize);
        boolean copied = false;
        try {
            copied = IoUtils.copyStream(imageStream, os, listener, this.bufferSize);
            if (!copied) {
                editor.abort();
            }
            return copied;
        } finally {
            IoUtils.closeSilently(os);
            if (copied) {
                editor.commit();
            } else {
                editor.abort();
            }
        }
    }

    public boolean save(String imageUri, Bitmap bitmap) throws IOException {
        DiskLruCache.Editor editor = this.cache.edit(getKey(imageUri));
        if (editor == null) {
            return false;
        }
        OutputStream os = new BufferedOutputStream(editor.newOutputStream(0), this.bufferSize);
        try {
            boolean savedSuccessfully = bitmap.compress(this.compressFormat, this.compressQuality, os);
            if (savedSuccessfully) {
                editor.commit();
            } else {
                editor.abort();
            }
            return savedSuccessfully;
        } finally {
            IoUtils.closeSilently(os);
        }
    }

    public boolean remove(String imageUri) {
        try {
            return this.cache.remove(getKey(imageUri));
        } catch (IOException e) {
            L.e(e);
            return false;
        }
    }

    public void close() {
        try {
            this.cache.close();
        } catch (IOException e) {
            L.e(e);
        }
        this.cache = null;
    }

    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e) {
            L.e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
        } catch (IOException e2) {
            L.e(e2);
        }
    }

    private String getKey(String imageUri) {
        return this.fileNameGenerator.generate(imageUri);
    }

    public void setBufferSize(int bufferSize2) {
        this.bufferSize = bufferSize2;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat2) {
        this.compressFormat = compressFormat2;
    }

    public void setCompressQuality(int compressQuality2) {
        this.compressQuality = compressQuality2;
    }
}
