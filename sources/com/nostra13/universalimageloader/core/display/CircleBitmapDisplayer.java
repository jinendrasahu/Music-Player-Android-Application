package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class CircleBitmapDisplayer implements BitmapDisplayer {
    protected final Integer strokeColor;
    protected final float strokeWidth;

    public CircleBitmapDisplayer() {
        this((Integer) null);
    }

    public CircleBitmapDisplayer(Integer strokeColor2) {
        this(strokeColor2, 0.0f);
    }

    public CircleBitmapDisplayer(Integer strokeColor2, float strokeWidth2) {
        this.strokeColor = strokeColor2;
        this.strokeWidth = strokeWidth2;
    }

    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new CircleDrawable(bitmap, this.strokeColor, this.strokeWidth));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public static class CircleDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final Paint paint;
        protected float radius;
        protected final Paint strokePaint;
        protected float strokeRadius;
        protected final float strokeWidth;

        public CircleDrawable(Bitmap bitmap, Integer strokeColor, float strokeWidth2) {
            this.radius = (float) (Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2);
            this.bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapRect = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
            if (strokeColor == null) {
                this.strokePaint = null;
            } else {
                this.strokePaint = new Paint();
                this.strokePaint.setStyle(Paint.Style.STROKE);
                this.strokePaint.setColor(strokeColor.intValue());
                this.strokePaint.setStrokeWidth(strokeWidth2);
                this.strokePaint.setAntiAlias(true);
            }
            this.strokeWidth = strokeWidth2;
            this.strokeRadius = this.radius - (strokeWidth2 / 2.0f);
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            this.mRect.set(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height());
            this.radius = (float) (Math.min(bounds.width(), bounds.height()) / 2);
            this.strokeRadius = this.radius - (this.strokeWidth / 2.0f);
            Matrix shaderMatrix = new Matrix();
            shaderMatrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(shaderMatrix);
        }

        public void draw(Canvas canvas) {
            float f = this.radius;
            canvas.drawCircle(f, f, f, this.paint);
            Paint paint2 = this.strokePaint;
            if (paint2 != null) {
                float f2 = this.radius;
                canvas.drawCircle(f2, f2, this.strokeRadius, paint2);
            }
        }

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int alpha) {
            this.paint.setAlpha(alpha);
        }

        public void setColorFilter(ColorFilter cf) {
            this.paint.setColorFilter(cf);
        }
    }
}
