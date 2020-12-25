package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\u0018\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0014J\u0018\u0010/\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R$\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R$\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b¨\u00060"}, d2 = {"Lcom/etebarian/meowbottomnavigation/CellImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBackgroundAlpha", "", "allowDraw", "changeSize", "value", "color", "getColor", "()I", "setColor", "(I)V", "colorAnimator", "Landroid/animation/ValueAnimator;", "fitImage", "isBitmap", "()Z", "setBitmap", "(Z)V", "resource", "getResource", "setResource", "size", "getSize", "setSize", "useColor", "getUseColor", "setUseColor", "changeColorByAnim", "", "newColor", "d", "", "draw", "initializeView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAttributeFromXml", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CellImageView.kt */
public final class CellImageView extends AppCompatImageView {
    private HashMap _$_findViewCache;
    private boolean actionBackgroundAlpha;
    private boolean allowDraw;
    private boolean changeSize;
    private int color;
    private ValueAnimator colorAnimator;
    private boolean fitImage;
    private boolean isBitmap;
    private int resource;
    private int size;
    private boolean useColor = true;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final boolean isBitmap() {
        return this.isBitmap;
    }

    public final void setBitmap(boolean value) {
        this.isBitmap = value;
        draw();
    }

    public final boolean getUseColor() {
        return this.useColor;
    }

    public final void setUseColor(boolean value) {
        this.useColor = value;
        draw();
    }

    public final int getResource() {
        return this.resource;
    }

    public final void setResource(int value) {
        this.resource = value;
        draw();
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int value) {
        this.color = value;
        draw();
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int value) {
        this.size = value;
        requestLayout();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellImageView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.size = UtilsKt.dip(context2, 24);
        this.changeSize = true;
        initializeView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.size = UtilsKt.dip(context2, 24);
        this.changeSize = true;
        setAttributeFromXml(context, attrs);
        initializeView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.size = UtilsKt.dip(context2, 24);
        this.changeSize = true;
        setAttributeFromXml(context, attrs);
        initializeView();
    }

    private final void setAttributeFromXml(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CellImageView, 0, 0);
        if (a != null) {
            TypedArray $receiver = a;
            try {
                setBitmap($receiver.getBoolean(R.styleable.CellImageView_meow_imageview_isBitmap, this.isBitmap));
                setUseColor($receiver.getBoolean(R.styleable.CellImageView_meow_imageview_useColor, this.useColor));
                setResource($receiver.getResourceId(R.styleable.CellImageView_meow_imageview_resource, this.resource));
                setColor($receiver.getColor(R.styleable.CellImageView_meow_imageview_color, this.color));
                setSize($receiver.getDimensionPixelSize(R.styleable.CellImageView_meow_imageview_size, this.size));
                this.actionBackgroundAlpha = $receiver.getBoolean(R.styleable.CellImageView_meow_imageview_actionBackgroundAlpha, this.actionBackgroundAlpha);
                this.changeSize = $receiver.getBoolean(R.styleable.CellImageView_meow_imageview_changeSize, this.changeSize);
                this.fitImage = $receiver.getBoolean(R.styleable.CellImageView_meow_imageview_fitImage, this.fitImage);
            } catch (Throwable th) {
                if (a != null) {
                    a.recycle();
                }
                throw th;
            }
        }
        if (a != null) {
            a.recycle();
        }
    }

    private final void initializeView() {
        this.allowDraw = true;
        draw();
    }

    private final void draw() {
        Drawable drawable;
        if (!this.allowDraw || this.resource == 0) {
            return;
        }
        if (this.isBitmap) {
            try {
                if (this.color == 0) {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    drawable = UtilsKt.getDrawableCompat(context, this.resource);
                } else {
                    drawable = DrawableHelper.INSTANCE.changeColorDrawableRes(getContext(), this.resource, this.color);
                }
                setImageDrawable(drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!this.useColor || this.color != 0) {
            try {
                setImageDrawable(DrawableHelper.INSTANCE.changeColorDrawableVector(getContext(), this.resource, this.useColor ? this.color : -2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void changeColorByAnim$default(CellImageView cellImageView, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 250;
        }
        cellImageView.changeColorByAnim(i, j);
    }

    public final void changeColorByAnim(int newColor, long d) {
        if (this.color == 0) {
            setColor(newColor);
            return;
        }
        int lastColor = this.color;
        ValueAnimator valueAnimator = this.colorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.colorAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator valueAnimator2 = this.colorAnimator;
        if (valueAnimator2 != null) {
            ValueAnimator $receiver = valueAnimator2;
            $receiver.setDuration(d);
            $receiver.setInterpolator(new FastOutSlowInInterpolator());
            $receiver.addUpdateListener(new CellImageView$changeColorByAnim$$inlined$apply$lambda$1(this, d, newColor, lastColor));
            $receiver.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.fitImage) {
            Drawable d = getDrawable();
            if (d != null) {
                int width = View.MeasureSpec.getSize(widthMeasureSpec);
                setMeasuredDimension(width, (int) Math.ceil((double) ((((float) width) * ((float) d.getIntrinsicHeight())) / ((float) d.getIntrinsicWidth()))));
                return;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else if (this.isBitmap || !this.changeSize) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            int newSize = View.MeasureSpec.makeMeasureSpec(this.size, BasicMeasure.EXACTLY);
            super.onMeasure(newSize, newSize);
        }
    }
}
