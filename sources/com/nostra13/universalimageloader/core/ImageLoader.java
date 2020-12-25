package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

public class ImageLoader {
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = ImageLoader.class.getSimpleName();
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private ImageLoadingListener defaultListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    protected ImageLoader() {
    }

    public synchronized void init(ImageLoaderConfiguration configuration2) {
        if (configuration2 == null) {
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        } else if (this.configuration == null) {
            L.d(LOG_INIT_CONFIG, new Object[0]);
            this.engine = new ImageLoaderEngine(configuration2);
            this.configuration = configuration2;
        } else {
            L.w(WARNING_RE_INIT_CONFIG, new Object[0]);
        }
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void displayImage(String uri, ImageAware imageAware) {
        displayImage(uri, imageAware, (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, ImageLoadingListener listener) {
        displayImage(uri, imageAware, (DisplayImageOptions) null, listener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options) {
        displayImage(uri, imageAware, options, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options, ImageLoadingListener listener) {
        displayImage(uri, imageAware, options, listener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options, ImageLoadingListener listener, ImageLoadingProgressListener progressListener) {
        displayImage(uri, imageAware, options, (ImageSize) null, listener, progressListener);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options, ImageSize targetSize, ImageLoadingListener listener, ImageLoadingProgressListener progressListener) {
        ImageLoadingListener listener2;
        DisplayImageOptions options2;
        ImageSize targetSize2;
        String str = uri;
        ImageAware imageAware2 = imageAware;
        checkConfiguration();
        if (imageAware2 != null) {
            if (listener == null) {
                listener2 = this.defaultListener;
            } else {
                listener2 = listener;
            }
            if (options == null) {
                options2 = this.configuration.defaultDisplayImageOptions;
            } else {
                options2 = options;
            }
            if (TextUtils.isEmpty(uri)) {
                this.engine.cancelDisplayTaskFor(imageAware2);
                listener2.onLoadingStarted(str, imageAware.getWrappedView());
                if (options2.shouldShowImageForEmptyUri()) {
                    imageAware2.setImageDrawable(options2.getImageForEmptyUri(this.configuration.resources));
                } else {
                    imageAware2.setImageDrawable((Drawable) null);
                }
                listener2.onLoadingComplete(str, imageAware.getWrappedView(), (Bitmap) null);
                return;
            }
            if (targetSize == null) {
                targetSize2 = ImageSizeUtils.defineTargetSizeForView(imageAware2, this.configuration.getMaxImageSize());
            } else {
                targetSize2 = targetSize;
            }
            String memoryCacheKey = MemoryCacheUtils.generateKey(str, targetSize2);
            this.engine.prepareDisplayTaskFor(imageAware2, memoryCacheKey);
            listener2.onLoadingStarted(str, imageAware.getWrappedView());
            Bitmap bmp = this.configuration.memoryCache.get(memoryCacheKey);
            if (bmp == null || bmp.isRecycled()) {
                String memoryCacheKey2 = memoryCacheKey;
                Bitmap bitmap = bmp;
                if (options2.shouldShowImageOnLoading()) {
                    imageAware2.setImageDrawable(options2.getImageOnLoading(this.configuration.resources));
                } else if (options2.isResetViewBeforeLoading()) {
                    imageAware2.setImageDrawable((Drawable) null);
                }
                LoadAndDisplayImageTask displayTask = new LoadAndDisplayImageTask(this.engine, new ImageLoadingInfo(uri, imageAware, targetSize2, memoryCacheKey2, options2, listener2, progressListener, this.engine.getLockForUri(str)), defineHandler(options2));
                if (options2.isSyncLoading()) {
                    displayTask.run();
                } else {
                    this.engine.submit(displayTask);
                }
            } else {
                L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, memoryCacheKey);
                if (options2.shouldPostProcess()) {
                    String str2 = memoryCacheKey;
                    ProcessAndDisplayImageTask displayTask2 = new ProcessAndDisplayImageTask(this.engine, bmp, new ImageLoadingInfo(uri, imageAware, targetSize2, memoryCacheKey, options2, listener2, progressListener, this.engine.getLockForUri(str)), defineHandler(options2));
                    if (options2.isSyncLoading()) {
                        displayTask2.run();
                    } else {
                        this.engine.submit(displayTask2);
                    }
                } else {
                    Bitmap bmp2 = bmp;
                    options2.getDisplayer().display(bmp2, imageAware2, LoadedFrom.MEMORY_CACHE);
                    listener2.onLoadingComplete(str, imageAware.getWrappedView(), bmp2);
                }
            }
        } else {
            throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
        }
    }

    public void displayImage(String uri, ImageView imageView) {
        displayImage(uri, (ImageAware) new ImageViewAware(imageView), (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageView imageView, ImageSize targetImageSize) {
        displayImage(uri, new ImageViewAware(imageView), (DisplayImageOptions) null, targetImageSize, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options) {
        displayImage(uri, (ImageAware) new ImageViewAware(imageView), options, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageView imageView, ImageLoadingListener listener) {
        displayImage(uri, (ImageAware) new ImageViewAware(imageView), (DisplayImageOptions) null, listener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener listener) {
        displayImage(uri, imageView, options, listener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener listener, ImageLoadingProgressListener progressListener) {
        displayImage(uri, (ImageAware) new ImageViewAware(imageView), options, listener, progressListener);
    }

    public void loadImage(String uri, ImageLoadingListener listener) {
        loadImage(uri, (ImageSize) null, (DisplayImageOptions) null, listener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String uri, ImageSize targetImageSize, ImageLoadingListener listener) {
        loadImage(uri, targetImageSize, (DisplayImageOptions) null, listener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String uri, DisplayImageOptions options, ImageLoadingListener listener) {
        loadImage(uri, (ImageSize) null, options, listener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String uri, ImageSize targetImageSize, DisplayImageOptions options, ImageLoadingListener listener) {
        loadImage(uri, targetImageSize, options, listener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String uri, ImageSize targetImageSize, DisplayImageOptions options, ImageLoadingListener listener, ImageLoadingProgressListener progressListener) {
        checkConfiguration();
        if (targetImageSize == null) {
            targetImageSize = this.configuration.getMaxImageSize();
        }
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        displayImage(uri, (ImageAware) new NonViewAware(uri, targetImageSize, ViewScaleType.CROP), options, listener, progressListener);
    }

    public Bitmap loadImageSync(String uri) {
        return loadImageSync(uri, (ImageSize) null, (DisplayImageOptions) null);
    }

    public Bitmap loadImageSync(String uri, DisplayImageOptions options) {
        return loadImageSync(uri, (ImageSize) null, options);
    }

    public Bitmap loadImageSync(String uri, ImageSize targetImageSize) {
        return loadImageSync(uri, targetImageSize, (DisplayImageOptions) null);
    }

    public Bitmap loadImageSync(String uri, ImageSize targetImageSize, DisplayImageOptions options) {
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        DisplayImageOptions options2 = new DisplayImageOptions.Builder().cloneFrom(options).syncLoading(true).build();
        SyncImageLoadingListener listener = new SyncImageLoadingListener();
        loadImage(uri, targetImageSize, options2, listener);
        return listener.getLoadedBitmap();
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public void setDefaultLoadingListener(ImageLoadingListener listener) {
        this.defaultListener = listener == null ? new SimpleImageLoadingListener() : listener;
    }

    public MemoryCache getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    @Deprecated
    public DiskCache getDiscCache() {
        return getDiskCache();
    }

    public DiskCache getDiskCache() {
        checkConfiguration();
        return this.configuration.diskCache;
    }

    @Deprecated
    public void clearDiscCache() {
        clearDiskCache();
    }

    public void clearDiskCache() {
        checkConfiguration();
        this.configuration.diskCache.clear();
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        return this.engine.getLoadingUriForView(imageAware);
    }

    public String getLoadingUriForView(ImageView imageView) {
        return this.engine.getLoadingUriForView(new ImageViewAware(imageView));
    }

    public void cancelDisplayTask(ImageAware imageAware) {
        this.engine.cancelDisplayTaskFor(imageAware);
    }

    public void cancelDisplayTask(ImageView imageView) {
        this.engine.cancelDisplayTaskFor(new ImageViewAware(imageView));
    }

    public void denyNetworkDownloads(boolean denyNetworkDownloads) {
        this.engine.denyNetworkDownloads(denyNetworkDownloads);
    }

    public void handleSlowNetwork(boolean handleSlowNetwork) {
        this.engine.handleSlowNetwork(handleSlowNetwork);
    }

    public void pause() {
        this.engine.pause();
    }

    public void resume() {
        this.engine.resume();
    }

    public void stop() {
        this.engine.stop();
    }

    public void destroy() {
        if (this.configuration != null) {
            L.d(LOG_DESTROY, new Object[0]);
        }
        stop();
        this.configuration.diskCache.close();
        this.engine = null;
        this.configuration = null;
    }

    private static Handler defineHandler(DisplayImageOptions options) {
        Handler handler = options.getHandler();
        if (options.isSyncLoading()) {
            return null;
        }
        if (handler == null && Looper.myLooper() == Looper.getMainLooper()) {
            return new Handler();
        }
        return handler;
    }

    private static class SyncImageLoadingListener extends SimpleImageLoadingListener {
        private Bitmap loadedImage;

        private SyncImageLoadingListener() {
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage2) {
            this.loadedImage = loadedImage2;
        }

        public Bitmap getLoadedBitmap() {
            return this.loadedImage;
        }
    }
}
