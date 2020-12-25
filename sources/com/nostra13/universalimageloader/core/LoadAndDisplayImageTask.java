package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

final class LoadAndDisplayImageTask implements Runnable, IoUtils.CopyListener {
    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    /* access modifiers changed from: private */
    public final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    final String uri;

    public LoadAndDisplayImageTask(ImageLoaderEngine engine2, ImageLoadingInfo imageLoadingInfo2, Handler handler2) {
        this.engine = engine2;
        this.imageLoadingInfo = imageLoadingInfo2;
        this.handler = handler2;
        this.configuration = engine2.configuration;
        this.downloader = this.configuration.downloader;
        this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
        this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
        this.decoder = this.configuration.decoder;
        this.uri = imageLoadingInfo2.uri;
        this.memoryCacheKey = imageLoadingInfo2.memoryCacheKey;
        this.imageAware = imageLoadingInfo2.imageAware;
        this.targetSize = imageLoadingInfo2.targetSize;
        this.options = imageLoadingInfo2.options;
        this.listener = imageLoadingInfo2.listener;
        this.progressListener = imageLoadingInfo2.progressListener;
        this.syncLoading = this.options.isSyncLoading();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6 A[Catch:{ TaskCancelledException -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            boolean r0 = r7.waitIfPaused()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r7.delayIfNeed()
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            com.nostra13.universalimageloader.core.ImageLoadingInfo r0 = r7.imageLoadingInfo
            java.util.concurrent.locks.ReentrantLock r0 = r0.loadFromUriLock
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.memoryCacheKey
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "Start display image task [%s]"
            com.nostra13.universalimageloader.utils.L.d(r3, r2)
            boolean r2 = r0.isLocked()
            if (r2 == 0) goto L_0x0030
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.memoryCacheKey
            r2[r4] = r3
            java.lang.String r3 = "Image already is loading. Waiting... [%s]"
            com.nostra13.universalimageloader.utils.L.d(r3, r2)
        L_0x0030:
            r0.lock()
            r2 = 0
            r7.checkTaskNotActual()     // Catch:{ TaskCancelledException -> 0x0104, all -> 0x0102 }
            com.nostra13.universalimageloader.core.ImageLoaderConfiguration r3 = r7.configuration     // Catch:{ TaskCancelledException -> 0x0104, all -> 0x0102 }
            com.nostra13.universalimageloader.cache.memory.MemoryCache r3 = r3.memoryCache     // Catch:{ TaskCancelledException -> 0x0104, all -> 0x0102 }
            java.lang.String r5 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0104, all -> 0x0102 }
            android.graphics.Bitmap r2 = r3.get(r5)     // Catch:{ TaskCancelledException -> 0x0104, all -> 0x0102 }
            if (r2 == 0) goto L_0x005a
            boolean r3 = r2.isRecycled()     // Catch:{ TaskCancelledException -> 0x0100 }
            if (r3 == 0) goto L_0x004a
            goto L_0x005a
        L_0x004a:
            com.nostra13.universalimageloader.core.assist.LoadedFrom r3 = com.nostra13.universalimageloader.core.assist.LoadedFrom.MEMORY_CACHE     // Catch:{ TaskCancelledException -> 0x0100 }
            r7.loadedFrom = r3     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r3 = "...Get cached bitmap from memory after waiting. [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r6 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.d(r3, r5)     // Catch:{ TaskCancelledException -> 0x0100 }
            goto L_0x00b4
        L_0x005a:
            android.graphics.Bitmap r3 = r7.tryLoadBitmap()     // Catch:{ TaskCancelledException -> 0x0100 }
            r2 = r3
            if (r2 != 0) goto L_0x0065
            r0.unlock()
            return
        L_0x0065:
            r7.checkTaskNotActual()     // Catch:{ TaskCancelledException -> 0x0100 }
            r7.checkTaskInterrupted()     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.options     // Catch:{ TaskCancelledException -> 0x0100 }
            boolean r3 = r3.shouldPreProcess()     // Catch:{ TaskCancelledException -> 0x0100 }
            if (r3 == 0) goto L_0x0096
            java.lang.String r3 = "PreProcess image before caching in memory [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r6 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.d(r3, r5)     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.options     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.process.BitmapProcessor r3 = r3.getPreProcessor()     // Catch:{ TaskCancelledException -> 0x0100 }
            android.graphics.Bitmap r3 = r3.process(r2)     // Catch:{ TaskCancelledException -> 0x0100 }
            r2 = r3
            if (r2 != 0) goto L_0x0096
            java.lang.String r3 = "Pre-processor returned null [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r6 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.e(r3, r5)     // Catch:{ TaskCancelledException -> 0x0100 }
        L_0x0096:
            if (r2 == 0) goto L_0x00b4
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.options     // Catch:{ TaskCancelledException -> 0x0100 }
            boolean r3 = r3.isCacheInMemory()     // Catch:{ TaskCancelledException -> 0x0100 }
            if (r3 == 0) goto L_0x00b4
            java.lang.String r3 = "Cache image in memory [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r6 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.d(r3, r5)     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.ImageLoaderConfiguration r3 = r7.configuration     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.cache.memory.MemoryCache r3 = r3.memoryCache     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r5 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r3.put(r5, r2)     // Catch:{ TaskCancelledException -> 0x0100 }
        L_0x00b4:
            if (r2 == 0) goto L_0x00e1
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.options     // Catch:{ TaskCancelledException -> 0x0100 }
            boolean r3 = r3.shouldPostProcess()     // Catch:{ TaskCancelledException -> 0x0100 }
            if (r3 == 0) goto L_0x00e1
            java.lang.String r3 = "PostProcess image before displaying [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r6 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.d(r3, r5)     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.options     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.core.process.BitmapProcessor r3 = r3.getPostProcessor()     // Catch:{ TaskCancelledException -> 0x0100 }
            android.graphics.Bitmap r3 = r3.process(r2)     // Catch:{ TaskCancelledException -> 0x0100 }
            r2 = r3
            if (r2 != 0) goto L_0x00e1
            java.lang.String r3 = "Post-processor returned null [%s]"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x0100 }
            java.lang.String r5 = r7.memoryCacheKey     // Catch:{ TaskCancelledException -> 0x0100 }
            r1[r4] = r5     // Catch:{ TaskCancelledException -> 0x0100 }
            com.nostra13.universalimageloader.utils.L.e(r3, r1)     // Catch:{ TaskCancelledException -> 0x0100 }
        L_0x00e1:
            r7.checkTaskNotActual()     // Catch:{ TaskCancelledException -> 0x0100 }
            r7.checkTaskInterrupted()     // Catch:{ TaskCancelledException -> 0x0100 }
            r0.unlock()
            com.nostra13.universalimageloader.core.DisplayBitmapTask r1 = new com.nostra13.universalimageloader.core.DisplayBitmapTask
            com.nostra13.universalimageloader.core.ImageLoadingInfo r3 = r7.imageLoadingInfo
            com.nostra13.universalimageloader.core.ImageLoaderEngine r4 = r7.engine
            com.nostra13.universalimageloader.core.assist.LoadedFrom r5 = r7.loadedFrom
            r1.<init>(r2, r3, r4, r5)
            boolean r3 = r7.syncLoading
            android.os.Handler r4 = r7.handler
            com.nostra13.universalimageloader.core.ImageLoaderEngine r5 = r7.engine
            runTask(r1, r3, r4, r5)
            return
        L_0x0100:
            r1 = move-exception
            goto L_0x0105
        L_0x0102:
            r1 = move-exception
            goto L_0x010d
        L_0x0104:
            r1 = move-exception
        L_0x0105:
            r7.fireCancelEvent()     // Catch:{ all -> 0x010c }
            r0.unlock()
            return
        L_0x010c:
            r1 = move-exception
        L_0x010d:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                    try {
                        this.engine.getPauseLock().wait();
                        L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                    } catch (InterruptedException e) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            Thread.sleep((long) this.options.getDelayBeforeLoading());
            return isTaskNotActual();
        } catch (InterruptedException e) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private Bitmap tryLoadBitmap() throws TaskCancelledException {
        File imageFile;
        Bitmap bitmap = null;
        try {
            File imageFile2 = this.configuration.diskCache.get(this.uri);
            if (imageFile2 != null && imageFile2.exists() && imageFile2.length() > 0) {
                L.d(LOG_LOAD_IMAGE_FROM_DISK_CACHE, this.memoryCacheKey);
                this.loadedFrom = LoadedFrom.DISC_CACHE;
                checkTaskNotActual();
                bitmap = decodeImage(ImageDownloader.Scheme.FILE.wrap(imageFile2.getAbsolutePath()));
            }
            if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                L.d(LOG_LOAD_IMAGE_FROM_NETWORK, this.memoryCacheKey);
                this.loadedFrom = LoadedFrom.NETWORK;
                String imageUriForDecoding = this.uri;
                if (this.options.isCacheOnDisk() && tryCacheImageOnDisk() && (imageFile = this.configuration.diskCache.get(this.uri)) != null) {
                    imageUriForDecoding = ImageDownloader.Scheme.FILE.wrap(imageFile.getAbsolutePath());
                }
                checkTaskNotActual();
                bitmap = decodeImage(imageUriForDecoding);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    fireFailEvent(FailReason.FailType.DECODING_ERROR, (Throwable) null);
                }
            }
        } catch (IllegalStateException e) {
            fireFailEvent(FailReason.FailType.NETWORK_DENIED, (Throwable) null);
        } catch (TaskCancelledException e2) {
            throw e2;
        } catch (IOException e3) {
            L.e(e3);
            fireFailEvent(FailReason.FailType.IO_ERROR, e3);
        } catch (OutOfMemoryError e4) {
            L.e(e4);
            fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, e4);
        } catch (Throwable e5) {
            L.e(e5);
            fireFailEvent(FailReason.FailType.UNKNOWN, e5);
        }
        return bitmap;
    }

    private Bitmap decodeImage(String imageUri) throws IOException {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, imageUri, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options));
    }

    private boolean tryCacheImageOnDisk() throws TaskCancelledException {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean loaded = downloadImage();
            if (!loaded) {
                return loaded;
            }
            try {
                int width = this.configuration.maxImageWidthForDiskCache;
                int height = this.configuration.maxImageHeightForDiskCache;
                if (width <= 0 && height <= 0) {
                    return loaded;
                }
                L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                resizeAndSaveImage(width, height);
                return loaded;
            } catch (IOException e) {
                e = e;
                L.e(e);
                return false;
            }
        } catch (IOException e2) {
            e = e2;
            L.e(e);
            return false;
        }
    }

    private boolean downloadImage() throws IOException {
        InputStream is = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        if (is == null) {
            L.e(ERROR_NO_IMAGE_STREAM, this.memoryCacheKey);
            return false;
        }
        try {
            return this.configuration.diskCache.save(this.uri, is, this);
        } finally {
            IoUtils.closeSilently(is);
        }
    }

    private boolean resizeAndSaveImage(int maxWidth, int maxHeight) throws IOException {
        File targetFile = this.configuration.diskCache.get(this.uri);
        if (targetFile == null || !targetFile.exists()) {
            return false;
        }
        Bitmap bmp = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(targetFile.getAbsolutePath()), this.uri, new ImageSize(maxWidth, maxHeight), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build()));
        if (!(bmp == null || this.configuration.processorForDiskCache == null)) {
            L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
            bmp = this.configuration.processorForDiskCache.process(bmp);
            if (bmp == null) {
                L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (bmp == null) {
            return false;
        }
        boolean saved = this.configuration.diskCache.save(this.uri, bmp);
        bmp.recycle();
        return saved;
    }

    public boolean onBytesCopied(int current, int total) {
        return this.syncLoading || fireProgressEvent(current, total);
    }

    private boolean fireProgressEvent(final int current, final int total) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener == null) {
            return true;
        }
        runTask(new Runnable() {
            public void run() {
                LoadAndDisplayImageTask.this.progressListener.onProgressUpdate(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), current, total);
            }
        }, false, this.handler, this.engine);
        return true;
    }

    private void fireFailEvent(final FailReason.FailType failType, final Throwable failCause) {
        if (!this.syncLoading && !isTaskInterrupted() && !isTaskNotActual()) {
            runTask(new Runnable() {
                public void run() {
                    if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                        LoadAndDisplayImageTask.this.imageAware.setImageDrawable(LoadAndDisplayImageTask.this.options.getImageOnFail(LoadAndDisplayImageTask.this.configuration.resources));
                    }
                    LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new FailReason(failType, failCause));
                }
            }, false, this.handler, this.engine);
        }
    }

    private void fireCancelEvent() {
        if (!this.syncLoading && !isTaskInterrupted()) {
            runTask(new Runnable() {
                public void run() {
                    LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView());
                }
            }, false, this.handler, this.engine);
        }
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        if (this.engine.isSlowNetwork()) {
            return this.slowNetworkDownloader;
        }
        return this.downloader;
    }

    private void checkTaskNotActual() throws TaskCancelledException {
        checkViewCollected();
        checkViewReused();
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private void checkViewCollected() throws TaskCancelledException {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
        return true;
    }

    private void checkViewReused() throws TaskCancelledException {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isViewReused() {
        if (!(!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)))) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
        return true;
    }

    private void checkTaskInterrupted() throws TaskCancelledException {
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isTaskInterrupted() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
        return true;
    }

    /* access modifiers changed from: package-private */
    public String getLoadingUri() {
        return this.uri;
    }

    static void runTask(Runnable r, boolean sync, Handler handler2, ImageLoaderEngine engine2) {
        if (sync) {
            r.run();
        } else if (handler2 == null) {
            engine2.fireCallback(r);
        } else {
            handler2.post(r);
        }
    }

    class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }
}
