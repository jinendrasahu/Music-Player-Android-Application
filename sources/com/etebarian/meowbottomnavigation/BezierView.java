package com.etebarian.meowbottomnavigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0018\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0002J\b\u00105\u001a\u000206H\u0002J\u0018\u00107\u001a\u0002062\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010<\u001a\u0002062\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010=\u001a\u000206H\u0002J\u0010\u0010>\u001a\u0002062\u0006\u00108\u001a\u000209H\u0014J\u0018\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0015R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX.¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001fX.¢\u0006\u0004\n\u0002\u0010!R$\u0010'\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001fX.¢\u0006\u0004\n\u0002\u0010!R$\u0010+\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\u000e\u0010.\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/etebarian/meowbottomnavigation/BezierView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "bezierInnerHeight", "", "bezierInnerWidth", "bezierOuterHeight", "bezierOuterWidth", "value", "bezierX", "getBezierX", "()F", "setBezierX", "(F)V", "color", "getColor", "()I", "setColor", "(I)V", "height", "innerArray", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "mainPaint", "Landroid/graphics/Paint;", "mainPath", "Landroid/graphics/Path;", "outerArray", "progress", "getProgress", "setProgress", "progressArray", "shadowColor", "getShadowColor", "setShadowColor", "shadowHeight", "shadowPaint", "shadowPath", "width", "calculate", "start", "end", "calculateInner", "", "drawInner", "canvas", "Landroid/graphics/Canvas;", "isShadow", "", "drawProgress", "initializeViews", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: BezierView.kt */
public final class BezierView extends View {
    private HashMap _$_findViewCache;
    private float bezierInnerHeight;
    private float bezierInnerWidth;
    private float bezierOuterHeight;
    private float bezierOuterWidth;
    private float bezierX;
    private int color;
    private float height;
    private PointF[] innerArray;
    private Paint mainPaint;
    private Path mainPath;
    private PointF[] outerArray;
    private float progress;
    private PointF[] progressArray;
    private int shadowColor;
    private final float shadowHeight;
    private Paint shadowPaint;
    private Path shadowPath;
    private float width;

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

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int value) {
        this.color = value;
        Paint paint = this.mainPaint;
        if (paint != null) {
            paint.setColor(this.color);
        }
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final void setShadowColor(int value) {
        this.shadowColor = value;
        Paint paint = this.shadowPaint;
        if (paint != null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            paint.setShadowLayer(UtilsKt.dipf(context, 4), 0.0f, 0.0f, this.shadowColor);
        }
    }

    public final float getBezierX() {
        return this.bezierX;
    }

    public final void setBezierX(float value) {
        if (value != this.bezierX) {
            this.bezierX = value;
            invalidate();
        }
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float value) {
        if (value != this.progress) {
            this.progress = value;
            PointF[] pointFArr = this.progressArray;
            if (pointFArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            int i = 2;
            float f = (float) 2;
            pointFArr[1].x = this.bezierX - (this.bezierInnerWidth / f);
            PointF[] pointFArr2 = this.progressArray;
            if (pointFArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            float f2 = (float) 4;
            pointFArr2[2].x = this.bezierX - (this.bezierInnerWidth / f2);
            PointF[] pointFArr3 = this.progressArray;
            if (pointFArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            pointFArr3[3].x = this.bezierX - (this.bezierInnerWidth / f2);
            PointF[] pointFArr4 = this.progressArray;
            if (pointFArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            pointFArr4[4].x = this.bezierX;
            PointF[] pointFArr5 = this.progressArray;
            if (pointFArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            pointFArr5[5].x = this.bezierX + (this.bezierInnerWidth / f2);
            PointF[] pointFArr6 = this.progressArray;
            if (pointFArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            pointFArr6[6].x = this.bezierX + (this.bezierInnerWidth / f2);
            PointF[] pointFArr7 = this.progressArray;
            if (pointFArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressArray");
            }
            pointFArr7[7].x = this.bezierX + (this.bezierInnerWidth / f);
            while (i <= 6) {
                int i2 = i;
                if (this.progress <= 1.0f) {
                    PointF[] pointFArr8 = this.progressArray;
                    if (pointFArr8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressArray");
                    }
                    PointF pointF = pointFArr8[i2];
                    PointF[] pointFArr9 = this.innerArray;
                    if (pointFArr9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("innerArray");
                    }
                    float f3 = pointFArr9[i2].y;
                    PointF[] pointFArr10 = this.outerArray;
                    if (pointFArr10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("outerArray");
                    }
                    pointF.y = calculate(f3, pointFArr10[i2].y);
                } else {
                    PointF[] pointFArr11 = this.progressArray;
                    if (pointFArr11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressArray");
                    }
                    PointF pointF2 = pointFArr11[i2];
                    PointF[] pointFArr12 = this.outerArray;
                    if (pointFArr12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("outerArray");
                    }
                    float f4 = pointFArr12[i2].y;
                    PointF[] pointFArr13 = this.innerArray;
                    if (pointFArr13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("innerArray");
                    }
                    pointF2.y = calculate(f4, pointFArr13[i2].y);
                }
                i = i2 + 1;
            }
            if (this.progress == 2.0f) {
                this.progress = 0.0f;
            }
            invalidate();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BezierView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.shadowHeight = UtilsKt.dipf(context2, 8);
        initializeViews();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.shadowHeight = UtilsKt.dipf(context2, 8);
        initializeViews();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.shadowHeight = UtilsKt.dipf(context2, 8);
        initializeViews();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BezierView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.shadowHeight = UtilsKt.dipf(context2, 8);
        initializeViews();
    }

    private final void initializeViews() {
        setWillNotDraw(false);
        this.mainPath = new Path();
        this.shadowPath = new Path();
        PointF[] pointFArr = new PointF[11];
        int length = pointFArr.length;
        for (int i$iv = 0; i$iv < length; i$iv++) {
            int i = i$iv;
            pointFArr[i$iv] = new PointF();
        }
        this.outerArray = pointFArr;
        PointF[] pointFArr2 = new PointF[11];
        int length2 = pointFArr2.length;
        for (int i$iv2 = 0; i$iv2 < length2; i$iv2++) {
            int i2 = i$iv2;
            pointFArr2[i$iv2] = new PointF();
        }
        this.innerArray = pointFArr2;
        PointF[] pointFArr3 = new PointF[11];
        int length3 = pointFArr3.length;
        for (int i$iv3 = 0; i$iv3 < length3; i$iv3++) {
            int i3 = i$iv3;
            pointFArr3[i$iv3] = new PointF();
        }
        this.progressArray = pointFArr3;
        this.mainPaint = new Paint(1);
        Paint $receiver = this.mainPaint;
        if ($receiver != null) {
            $receiver.setStrokeWidth(0.0f);
            $receiver.setAntiAlias(true);
            $receiver.setStyle(Paint.Style.FILL);
            $receiver.setColor(this.color);
        }
        this.shadowPaint = new Paint(1);
        Paint $receiver2 = this.shadowPaint;
        if ($receiver2 != null) {
            $receiver2.setAntiAlias(true);
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            $receiver2.setShadowLayer(UtilsKt.dipf(context, 4), 0.0f, 0.0f, this.shadowColor);
        }
        setColor(this.color);
        setShadowColor(this.shadowColor);
        setLayerType(1, this.shadowPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = (float) View.MeasureSpec.getSize(widthMeasureSpec);
        this.height = (float) View.MeasureSpec.getSize(heightMeasureSpec);
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.bezierOuterWidth = UtilsKt.dipf(context, 72);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.bezierOuterHeight = UtilsKt.dipf(context2, 12);
        Context context3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        this.bezierInnerWidth = UtilsKt.dipf(context3, 108);
        Context context4 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context4, "context");
        this.bezierInnerHeight = UtilsKt.dipf(context4, 16);
        float extra = this.shadowHeight;
        PointF[] pointFArr = this.outerArray;
        if (pointFArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr[0] = new PointF(0.0f, this.bezierOuterHeight + extra);
        PointF[] pointFArr2 = this.outerArray;
        if (pointFArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        float f = (float) 2;
        pointFArr2[1] = new PointF(this.bezierX - (this.bezierOuterWidth / f), this.bezierOuterHeight + extra);
        PointF[] pointFArr3 = this.outerArray;
        if (pointFArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        float f2 = (float) 4;
        pointFArr3[2] = new PointF(this.bezierX - (this.bezierOuterWidth / f2), this.bezierOuterHeight + extra);
        PointF[] pointFArr4 = this.outerArray;
        if (pointFArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr4[3] = new PointF(this.bezierX - (this.bezierOuterWidth / f2), extra);
        PointF[] pointFArr5 = this.outerArray;
        if (pointFArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr5[4] = new PointF(this.bezierX, extra);
        PointF[] pointFArr6 = this.outerArray;
        if (pointFArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr6[5] = new PointF(this.bezierX + (this.bezierOuterWidth / f2), extra);
        PointF[] pointFArr7 = this.outerArray;
        if (pointFArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr7[6] = new PointF(this.bezierX + (this.bezierOuterWidth / f2), this.bezierOuterHeight + extra);
        PointF[] pointFArr8 = this.outerArray;
        if (pointFArr8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr8[7] = new PointF(this.bezierX + (this.bezierOuterWidth / f), this.bezierOuterHeight + extra);
        PointF[] pointFArr9 = this.outerArray;
        if (pointFArr9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr9[8] = new PointF(this.width, this.bezierOuterHeight + extra);
        PointF[] pointFArr10 = this.outerArray;
        if (pointFArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr10[9] = new PointF(this.width, this.height);
        PointF[] pointFArr11 = this.outerArray;
        if (pointFArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerArray");
        }
        pointFArr11[10] = new PointF(0.0f, this.height);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        Path path = this.mainPath;
        if (path == null) {
            Intrinsics.throwNpe();
        }
        path.reset();
        Path path2 = this.shadowPath;
        if (path2 == null) {
            Intrinsics.throwNpe();
        }
        path2.reset();
        if (this.progress == 0.0f) {
            drawInner(canvas, true);
            drawInner(canvas, false);
            return;
        }
        drawProgress(canvas, true);
        drawProgress(canvas, false);
    }

    private final void drawInner(Canvas canvas, boolean isShadow) {
        Paint paint = isShadow ? this.shadowPaint : this.mainPaint;
        Path path = isShadow ? this.shadowPath : this.mainPath;
        calculateInner();
        if (path == null) {
            Intrinsics.throwNpe();
        }
        PointF[] pointFArr = this.innerArray;
        if (pointFArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f = pointFArr[0].x;
        PointF[] pointFArr2 = this.innerArray;
        if (pointFArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.lineTo(f, pointFArr2[0].y);
        PointF[] pointFArr3 = this.innerArray;
        if (pointFArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f2 = pointFArr3[1].x;
        PointF[] pointFArr4 = this.innerArray;
        if (pointFArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.lineTo(f2, pointFArr4[1].y);
        PointF[] pointFArr5 = this.innerArray;
        if (pointFArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f3 = pointFArr5[2].x;
        PointF[] pointFArr6 = this.innerArray;
        if (pointFArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f4 = pointFArr6[2].y;
        PointF[] pointFArr7 = this.innerArray;
        if (pointFArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f5 = pointFArr7[3].x;
        PointF[] pointFArr8 = this.innerArray;
        if (pointFArr8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f6 = pointFArr8[3].y;
        PointF[] pointFArr9 = this.innerArray;
        if (pointFArr9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f7 = pointFArr9[4].x;
        PointF[] pointFArr10 = this.innerArray;
        if (pointFArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.cubicTo(f3, f4, f5, f6, f7, pointFArr10[4].y);
        PointF[] pointFArr11 = this.innerArray;
        if (pointFArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f8 = pointFArr11[5].x;
        PointF[] pointFArr12 = this.innerArray;
        if (pointFArr12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f9 = pointFArr12[5].y;
        PointF[] pointFArr13 = this.innerArray;
        if (pointFArr13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f10 = pointFArr13[6].x;
        PointF[] pointFArr14 = this.innerArray;
        if (pointFArr14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f11 = pointFArr14[6].y;
        PointF[] pointFArr15 = this.innerArray;
        if (pointFArr15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f12 = pointFArr15[7].x;
        PointF[] pointFArr16 = this.innerArray;
        if (pointFArr16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.cubicTo(f8, f9, f10, f11, f12, pointFArr16[7].y);
        PointF[] pointFArr17 = this.innerArray;
        if (pointFArr17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f13 = pointFArr17[8].x;
        PointF[] pointFArr18 = this.innerArray;
        if (pointFArr18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.lineTo(f13, pointFArr18[8].y);
        PointF[] pointFArr19 = this.innerArray;
        if (pointFArr19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f14 = pointFArr19[9].x;
        PointF[] pointFArr20 = this.innerArray;
        if (pointFArr20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.lineTo(f14, pointFArr20[9].y);
        PointF[] pointFArr21 = this.innerArray;
        if (pointFArr21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f15 = pointFArr21[10].x;
        PointF[] pointFArr22 = this.innerArray;
        if (pointFArr22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        path.lineTo(f15, pointFArr22[10].y);
        PointF[] pointFArr23 = this.innerArray;
        if (pointFArr23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        this.progressArray = (PointF[]) pointFArr23.clone();
        if (paint == null) {
            Intrinsics.throwNpe();
        }
        canvas.drawPath(path, paint);
    }

    private final void calculateInner() {
        float extra = this.shadowHeight;
        PointF[] pointFArr = this.innerArray;
        if (pointFArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr[0] = new PointF(0.0f, this.bezierInnerHeight + extra);
        PointF[] pointFArr2 = this.innerArray;
        if (pointFArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f = (float) 2;
        pointFArr2[1] = new PointF(this.bezierX - (this.bezierInnerWidth / f), this.bezierInnerHeight + extra);
        PointF[] pointFArr3 = this.innerArray;
        if (pointFArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        float f2 = (float) 4;
        pointFArr3[2] = new PointF(this.bezierX - (this.bezierInnerWidth / f2), this.bezierInnerHeight + extra);
        PointF[] pointFArr4 = this.innerArray;
        if (pointFArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr4[3] = new PointF(this.bezierX - (this.bezierInnerWidth / f2), this.height - extra);
        PointF[] pointFArr5 = this.innerArray;
        if (pointFArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr5[4] = new PointF(this.bezierX, this.height - extra);
        PointF[] pointFArr6 = this.innerArray;
        if (pointFArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr6[5] = new PointF(this.bezierX + (this.bezierInnerWidth / f2), this.height - extra);
        PointF[] pointFArr7 = this.innerArray;
        if (pointFArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr7[6] = new PointF(this.bezierX + (this.bezierInnerWidth / f2), this.bezierInnerHeight + extra);
        PointF[] pointFArr8 = this.innerArray;
        if (pointFArr8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr8[7] = new PointF(this.bezierX + (this.bezierInnerWidth / f), this.bezierInnerHeight + extra);
        PointF[] pointFArr9 = this.innerArray;
        if (pointFArr9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr9[8] = new PointF(this.width, this.bezierInnerHeight + extra);
        PointF[] pointFArr10 = this.innerArray;
        if (pointFArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr10[9] = new PointF(this.width, this.height);
        PointF[] pointFArr11 = this.innerArray;
        if (pointFArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerArray");
        }
        pointFArr11[10] = new PointF(0.0f, this.height);
    }

    private final void drawProgress(Canvas canvas, boolean isShadow) {
        Paint paint = isShadow ? this.shadowPaint : this.mainPaint;
        Path path = isShadow ? this.shadowPath : this.mainPath;
        if (path == null) {
            Intrinsics.throwNpe();
        }
        PointF[] pointFArr = this.progressArray;
        if (pointFArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f = pointFArr[0].x;
        PointF[] pointFArr2 = this.progressArray;
        if (pointFArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.lineTo(f, pointFArr2[0].y);
        PointF[] pointFArr3 = this.progressArray;
        if (pointFArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f2 = pointFArr3[1].x;
        PointF[] pointFArr4 = this.progressArray;
        if (pointFArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.lineTo(f2, pointFArr4[1].y);
        PointF[] pointFArr5 = this.progressArray;
        if (pointFArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f3 = pointFArr5[2].x;
        PointF[] pointFArr6 = this.progressArray;
        if (pointFArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f4 = pointFArr6[2].y;
        PointF[] pointFArr7 = this.progressArray;
        if (pointFArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f5 = pointFArr7[3].x;
        PointF[] pointFArr8 = this.progressArray;
        if (pointFArr8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f6 = pointFArr8[3].y;
        PointF[] pointFArr9 = this.progressArray;
        if (pointFArr9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f7 = pointFArr9[4].x;
        PointF[] pointFArr10 = this.progressArray;
        if (pointFArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.cubicTo(f3, f4, f5, f6, f7, pointFArr10[4].y);
        PointF[] pointFArr11 = this.progressArray;
        if (pointFArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f8 = pointFArr11[5].x;
        PointF[] pointFArr12 = this.progressArray;
        if (pointFArr12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f9 = pointFArr12[5].y;
        PointF[] pointFArr13 = this.progressArray;
        if (pointFArr13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f10 = pointFArr13[6].x;
        PointF[] pointFArr14 = this.progressArray;
        if (pointFArr14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f11 = pointFArr14[6].y;
        PointF[] pointFArr15 = this.progressArray;
        if (pointFArr15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f12 = pointFArr15[7].x;
        PointF[] pointFArr16 = this.progressArray;
        if (pointFArr16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.cubicTo(f8, f9, f10, f11, f12, pointFArr16[7].y);
        PointF[] pointFArr17 = this.progressArray;
        if (pointFArr17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f13 = pointFArr17[8].x;
        PointF[] pointFArr18 = this.progressArray;
        if (pointFArr18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.lineTo(f13, pointFArr18[8].y);
        PointF[] pointFArr19 = this.progressArray;
        if (pointFArr19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f14 = pointFArr19[9].x;
        PointF[] pointFArr20 = this.progressArray;
        if (pointFArr20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.lineTo(f14, pointFArr20[9].y);
        PointF[] pointFArr21 = this.progressArray;
        if (pointFArr21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        float f15 = pointFArr21[10].x;
        PointF[] pointFArr22 = this.progressArray;
        if (pointFArr22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressArray");
        }
        path.lineTo(f15, pointFArr22[10].y);
        if (paint == null) {
            Intrinsics.throwNpe();
        }
        canvas.drawPath(path, paint);
    }

    private final float calculate(float start, float end) {
        float p = this.progress;
        if (p > 1.0f) {
            p = this.progress - 1.0f;
        }
        if (p >= 0.9f && p <= 1.0f) {
            calculateInner();
        }
        return ((end - start) * p) + start;
    }
}
