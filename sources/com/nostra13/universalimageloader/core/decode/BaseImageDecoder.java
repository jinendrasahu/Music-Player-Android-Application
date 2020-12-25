package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    public BaseImageDecoder(boolean loggingEnabled2) {
        this.loggingEnabled = loggingEnabled2;
    }

    public Bitmap decode(ImageDecodingInfo decodingInfo) throws IOException {
        InputStream imageStream = getImageStream(decodingInfo);
        if (imageStream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, decodingInfo.getImageKey());
            return null;
        }
        try {
            ImageFileInfo imageInfo = defineImageSizeAndRotation(imageStream, decodingInfo);
            try {
                InputStream imageStream2 = resetStream(imageStream, decodingInfo);
                Bitmap decodedBitmap = BitmapFactory.decodeStream(imageStream2, (Rect) null, prepareDecodingOptions(imageInfo.imageSize, decodingInfo));
                IoUtils.closeSilently(imageStream2);
                if (decodedBitmap != null) {
                    return considerExactScaleAndOrientatiton(decodedBitmap, decodingInfo, imageInfo.exif.rotation, imageInfo.exif.flipHorizontal);
                }
                L.e(ERROR_CANT_DECODE_IMAGE, decodingInfo.getImageKey());
                return decodedBitmap;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeSilently(imageStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeSilently(imageStream);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getImageStream(ImageDecodingInfo decodingInfo) throws IOException {
        return decodingInfo.getDownloader().getStream(decodingInfo.getImageUri(), decodingInfo.getExtraForDownloader());
    }

    /* access modifiers changed from: protected */
    public ImageFileInfo defineImageSizeAndRotation(InputStream imageStream, ImageDecodingInfo decodingInfo) throws IOException {
        ExifInfo exif;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(imageStream, (Rect) null, options);
        String imageUri = decodingInfo.getImageUri();
        if (!decodingInfo.shouldConsiderExifParams() || !canDefineExifParams(imageUri, options.outMimeType)) {
            exif = new ExifInfo();
        } else {
            exif = defineExifOrientation(imageUri);
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exif.rotation), exif);
    }

    private boolean canDefineExifParams(String imageUri, String mimeType) {
        return "image/jpeg".equalsIgnoreCase(mimeType) && ImageDownloader.Scheme.ofUri(imageUri) == ImageDownloader.Scheme.FILE;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r0 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r0 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r0 = 180;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.nostra13.universalimageloader.core.decode.BaseImageDecoder.ExifInfo defineExifOrientation(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            android.media.ExifInterface r3 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0028 }
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r4 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ IOException -> 0x0028 }
            java.lang.String r4 = r4.crop(r6)     // Catch:{ IOException -> 0x0028 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0028 }
            java.lang.String r4 = "Orientation"
            int r2 = r3.getAttributeInt(r4, r2)     // Catch:{ IOException -> 0x0028 }
            switch(r2) {
                case 1: goto L_0x0025;
                case 2: goto L_0x0024;
                case 3: goto L_0x0021;
                case 4: goto L_0x0020;
                case 5: goto L_0x001c;
                case 6: goto L_0x0019;
                case 7: goto L_0x0018;
                case 8: goto L_0x001d;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0027
        L_0x0018:
            r1 = 1
        L_0x0019:
            r0 = 90
            goto L_0x0027
        L_0x001c:
            r1 = 1
        L_0x001d:
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x0027
        L_0x0020:
            r1 = 1
        L_0x0021:
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x0027
        L_0x0024:
            r1 = 1
        L_0x0025:
            r0 = 0
        L_0x0027:
            goto L_0x0033
        L_0x0028:
            r3 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            r2[r4] = r6
            java.lang.String r4 = "Can't read EXIF tags from file [%s]"
            com.nostra13.universalimageloader.utils.L.w(r4, r2)
        L_0x0033:
            com.nostra13.universalimageloader.core.decode.BaseImageDecoder$ExifInfo r2 = new com.nostra13.universalimageloader.core.decode.BaseImageDecoder$ExifInfo
            r2.<init>(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.decode.BaseImageDecoder.defineExifOrientation(java.lang.String):com.nostra13.universalimageloader.core.decode.BaseImageDecoder$ExifInfo");
    }

    /* access modifiers changed from: protected */
    public BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo decodingInfo) {
        int scale;
        ImageScaleType scaleType = decodingInfo.getImageScaleType();
        if (scaleType == ImageScaleType.NONE) {
            scale = 1;
        } else if (scaleType == ImageScaleType.NONE_SAFE) {
            scale = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            scale = ImageSizeUtils.computeImageSampleSize(imageSize, decodingInfo.getTargetSize(), decodingInfo.getViewScaleType(), scaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (scale > 1 && this.loggingEnabled) {
            L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(scale), Integer.valueOf(scale), decodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = decodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = scale;
        return decodingOptions;
    }

    /* access modifiers changed from: protected */
    public InputStream resetStream(InputStream imageStream, ImageDecodingInfo decodingInfo) throws IOException {
        if (imageStream.markSupported()) {
            try {
                imageStream.reset();
                return imageStream;
            } catch (IOException e) {
            }
        }
        IoUtils.closeSilently(imageStream);
        return getImageStream(decodingInfo);
    }

    /* access modifiers changed from: protected */
    public Bitmap considerExactScaleAndOrientatiton(Bitmap subsampledBitmap, ImageDecodingInfo decodingInfo, int rotation, boolean flipHorizontal) {
        Matrix m = new Matrix();
        ImageScaleType scaleType = decodingInfo.getImageScaleType();
        if (scaleType == ImageScaleType.EXACTLY || scaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize srcSize = new ImageSize(subsampledBitmap.getWidth(), subsampledBitmap.getHeight(), rotation);
            float scale = ImageSizeUtils.computeImageScale(srcSize, decodingInfo.getTargetSize(), decodingInfo.getViewScaleType(), scaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(scale, 1.0f) != 0) {
                m.setScale(scale, scale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, srcSize, srcSize.scale(scale), Float.valueOf(scale), decodingInfo.getImageKey());
                }
            }
        }
        if (flipHorizontal) {
            m.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, decodingInfo.getImageKey());
            }
        }
        if (rotation != 0) {
            m.postRotate((float) rotation);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(rotation), decodingInfo.getImageKey());
            }
        }
        Bitmap finalBitmap = Bitmap.createBitmap(subsampledBitmap, 0, 0, subsampledBitmap.getWidth(), subsampledBitmap.getHeight(), m, true);
        if (finalBitmap != subsampledBitmap) {
            subsampledBitmap.recycle();
        }
        return finalBitmap;
    }

    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int rotation2, boolean flipHorizontal2) {
            this.rotation = rotation2;
            this.flipHorizontal = flipHorizontal2;
        }
    }

    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize2, ExifInfo exif2) {
            this.imageSize = imageSize2;
            this.exif = exif2;
        }
    }
}
