package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020\rH\u0002J\u0006\u0010N\u001a\u00020KJ\b\u0010O\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020K2\b\b\u0002\u0010M\u001a\u00020\rJ\b\u0010P\u001a\u00020KH\u0002J\u0018\u0010Q\u001a\u00020K2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\nH\u0014J\u0018\u0010T\u001a\u00020K2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R$\u0010#\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010&@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u001e\u00108\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b9\u0010\u0012R$\u0010:\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001e\u0010A\u001a\u00020@2\u0006\u0010\u0019\u001a\u00020@@BX\u000e¢\u0006\b\n\u0000\"\u0004\bB\u0010CR$\u0010D\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001a\u0010G\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012¨\u0006V"}, d2 = {"Lcom/etebarian/meowbottomnavigation/MeowBottomNavigationCell;", "Landroid/widget/RelativeLayout;", "Lkotlinx/android/extensions/LayoutContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowDraw", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "value", "", "count", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "countBackgroundColor", "getCountBackgroundColor", "setCountBackgroundColor", "countTextColor", "getCountTextColor", "setCountTextColor", "Landroid/graphics/Typeface;", "countTypeface", "getCountTypeface", "()Landroid/graphics/Typeface;", "setCountTypeface", "(Landroid/graphics/Typeface;)V", "defaultIconColor", "getDefaultIconColor", "setDefaultIconColor", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "icon", "getIcon", "setIcon", "iconSize", "setIconSize", "isEnabledCell", "()Z", "setEnabledCell", "(Z)V", "isFromLeft", "setFromLeft", "", "progress", "setProgress", "(F)V", "rippleColor", "getRippleColor", "setRippleColor", "selectedIconColor", "getSelectedIconColor", "setSelectedIconColor", "animateProgress", "", "enableCell", "isAnimate", "disableCell", "draw", "initializeView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAttributeFromXml", "Companion", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigationCell.kt */
public final class MeowBottomNavigationCell extends RelativeLayout implements LayoutContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EMPTY_VALUE = "empty";
    private HashMap _$_findViewCache;
    private boolean allowDraw;
    private int circleColor;
    public View containerView;
    private String count = EMPTY_VALUE;
    private int countBackgroundColor;
    private int countTextColor;
    private Typeface countTypeface;
    private int defaultIconColor;
    private long duration;
    private int icon;
    private int iconSize;
    private boolean isEnabledCell;
    private boolean isFromLeft;
    /* access modifiers changed from: private */
    public float progress;
    private int rippleColor;
    private int selectedIconColor;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/etebarian/meowbottomnavigation/MeowBottomNavigationCell$Companion;", "", "()V", "EMPTY_VALUE", "", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: MeowBottomNavigationCell.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final int getDefaultIconColor() {
        return this.defaultIconColor;
    }

    public final void setDefaultIconColor(int i) {
        this.defaultIconColor = i;
    }

    public final int getSelectedIconColor() {
        return this.selectedIconColor;
    }

    public final void setSelectedIconColor(int i) {
        this.selectedIconColor = i;
    }

    public final int getCircleColor() {
        return this.circleColor;
    }

    public final void setCircleColor(int i) {
        this.circleColor = i;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final void setIcon(int value) {
        this.icon = value;
        if (this.allowDraw) {
            ((CellImageView) _$_findCachedViewById(R.id.iv)).setResource(value);
        }
    }

    public final String getCount() {
        return this.count;
    }

    public final void setCount(String value) {
        float scale;
        String str;
        this.count = value;
        if (this.allowDraw) {
            String str2 = this.count;
            if (str2 == null || !Intrinsics.areEqual((Object) str2, (Object) EMPTY_VALUE)) {
                String str3 = this.count;
                boolean z = false;
                if (str3 != null) {
                    if ((str3 != null ? str3.length() : 0) >= 3) {
                        String str4 = this.count;
                        if (str4 == null) {
                            str = null;
                        } else if (str4 != null) {
                            str = str4.substring(0, 1);
                            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        this.count = Intrinsics.stringPlus(str, "..");
                    }
                }
                TextView textView = (TextView) _$_findCachedViewById(R.id.tv_count);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tv_count");
                textView.setText(this.count);
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_count);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_count");
                textView2.setVisibility(0);
                String str5 = this.count;
                if (str5 != null) {
                    if (str5.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        scale = 0.5f;
                        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_count);
                        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_count");
                        textView3.setScaleX(scale);
                        TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_count);
                        Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_count");
                        textView4.setScaleY(scale);
                        return;
                    }
                }
                scale = 1.0f;
                TextView textView32 = (TextView) _$_findCachedViewById(R.id.tv_count);
                Intrinsics.checkExpressionValueIsNotNull(textView32, "tv_count");
                textView32.setScaleX(scale);
                TextView textView42 = (TextView) _$_findCachedViewById(R.id.tv_count);
                Intrinsics.checkExpressionValueIsNotNull(textView42, "tv_count");
                textView42.setScaleY(scale);
                return;
            }
            TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_count);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_count");
            textView5.setText("");
            TextView textView6 = (TextView) _$_findCachedViewById(R.id.tv_count);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_count");
            textView6.setVisibility(4);
        }
    }

    private final void setIconSize(int value) {
        this.iconSize = value;
        if (this.allowDraw) {
            ((CellImageView) _$_findCachedViewById(R.id.iv)).setSize(value);
            CellImageView cellImageView = (CellImageView) _$_findCachedViewById(R.id.iv);
            Intrinsics.checkExpressionValueIsNotNull(cellImageView, "iv");
            cellImageView.setPivotX(((float) this.iconSize) / 2.0f);
            CellImageView cellImageView2 = (CellImageView) _$_findCachedViewById(R.id.iv);
            Intrinsics.checkExpressionValueIsNotNull(cellImageView2, "iv");
            cellImageView2.setPivotY(((float) this.iconSize) / 2.0f);
        }
    }

    public final int getCountTextColor() {
        return this.countTextColor;
    }

    public final void setCountTextColor(int value) {
        this.countTextColor = value;
        if (this.allowDraw) {
            ((TextView) _$_findCachedViewById(R.id.tv_count)).setTextColor(this.countTextColor);
        }
    }

    public final int getCountBackgroundColor() {
        return this.countBackgroundColor;
    }

    public final void setCountBackgroundColor(int value) {
        this.countBackgroundColor = value;
        if (this.allowDraw) {
            GradientDrawable d = new GradientDrawable();
            d.setColor(this.countBackgroundColor);
            d.setShape(1);
            ViewCompat.setBackground((TextView) _$_findCachedViewById(R.id.tv_count), d);
        }
    }

    public final Typeface getCountTypeface() {
        return this.countTypeface;
    }

    public final void setCountTypeface(Typeface value) {
        this.countTypeface = value;
        if (this.allowDraw && this.countTypeface != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_count);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_count");
            textView.setTypeface(this.countTypeface);
        }
    }

    public final int getRippleColor() {
        return this.rippleColor;
    }

    public final void setRippleColor(int value) {
        this.rippleColor = value;
        boolean z = this.allowDraw;
    }

    public final boolean isFromLeft() {
        return this.isFromLeft;
    }

    public final void setFromLeft(boolean z) {
        this.isFromLeft = z;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    /* access modifiers changed from: private */
    public final void setProgress(float value) {
        float f;
        this.progress = value;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.fl);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "fl");
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        float dip = (1.0f - this.progress) * ((float) UtilsKt.dip(context, 18));
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        frameLayout.setY(dip + ((float) UtilsKt.dip(context2, 10)));
        ((CellImageView) _$_findCachedViewById(R.id.iv)).setColor(this.progress == 1.0f ? this.selectedIconColor : this.defaultIconColor);
        float scale = ((1.0f - this.progress) * -0.2f) + 1.0f;
        CellImageView cellImageView = (CellImageView) _$_findCachedViewById(R.id.iv);
        Intrinsics.checkExpressionValueIsNotNull(cellImageView, "iv");
        cellImageView.setScaleX(scale);
        CellImageView cellImageView2 = (CellImageView) _$_findCachedViewById(R.id.iv);
        Intrinsics.checkExpressionValueIsNotNull(cellImageView2, "iv");
        cellImageView2.setScaleY(scale);
        GradientDrawable d = new GradientDrawable();
        d.setColor(this.circleColor);
        d.setShape(1);
        ViewCompat.setBackground(_$_findCachedViewById(R.id.v_circle), d);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_circle);
        if (this.progress > 0.7f) {
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            f = UtilsKt.dipf(context3, this.progress * 4.0f);
        } else {
            f = 0.0f;
        }
        ViewCompat.setElevation(_$_findCachedViewById, f);
        Context context4 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context4, "context");
        int m = UtilsKt.dip(context4, 24);
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.v_circle);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "v_circle");
        float f2 = (1.0f - this.progress) * ((float) (this.isFromLeft ? -m : m));
        int measuredWidth = getMeasuredWidth();
        Context context5 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context5, "context");
        _$_findCachedViewById2.setX(f2 + (((float) (measuredWidth - UtilsKt.dip(context5, 48))) / 2.0f));
        View _$_findCachedViewById3 = _$_findCachedViewById(R.id.v_circle);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "v_circle");
        float measuredHeight = (1.0f - this.progress) * ((float) getMeasuredHeight());
        Context context6 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context6, "context");
        _$_findCachedViewById3.setY(measuredHeight + ((float) UtilsKt.dip(context6, 6)));
    }

    public final boolean isEnabledCell() {
        return this.isEnabledCell;
    }

    public final void setEnabledCell(boolean value) {
        this.isEnabledCell = value;
        GradientDrawable d = new GradientDrawable();
        d.setColor(this.circleColor);
        d.setShape(1);
        if (Build.VERSION.SDK_INT < 21 || this.isEnabledCell) {
            View $receiver$iv = (FrameLayout) _$_findCachedViewById(R.id.fl);
            if ($receiver$iv != null) {
                $receiver$iv.postDelayed(new MeowBottomNavigationCell$isEnabledCell$$inlined$runAfterDelay$1($receiver$iv), 200);
                return;
            }
            return;
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.fl);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "fl");
        frameLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.rippleColor), (Drawable) null, d));
    }

    public View getContainerView() {
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        return view;
    }

    public void setContainerView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.containerView = view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigationCell(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.iconSize = UtilsKt.dip(context2, 24);
        initializeView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigationCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.iconSize = UtilsKt.dip(context2, 24);
        setAttributeFromXml(context, attrs);
        initializeView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigationCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.iconSize = UtilsKt.dip(context2, 24);
        setAttributeFromXml(context, attrs);
        initializeView();
    }

    private final void setAttributeFromXml(Context context, AttributeSet attrs) {
    }

    private final void initializeView() {
        this.allowDraw = true;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.meow_navigation_cell, this);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…ow_navigation_cell, this)");
        setContainerView(inflate);
        draw();
    }

    private final void draw() {
        if (this.allowDraw) {
            setIcon(this.icon);
            setCount(this.count);
            setIconSize(this.iconSize);
            setCountTextColor(this.countTextColor);
            setCountBackgroundColor(this.countBackgroundColor);
            setCountTypeface(this.countTypeface);
            setRippleColor(this.rippleColor);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setProgress(this.progress);
    }

    public final void disableCell() {
        if (this.isEnabledCell) {
            animateProgress$default(this, false, false, 2, (Object) null);
        }
        setEnabledCell(false);
    }

    public static /* synthetic */ void enableCell$default(MeowBottomNavigationCell meowBottomNavigationCell, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        meowBottomNavigationCell.enableCell(z);
    }

    public final void enableCell(boolean isAnimate) {
        if (!this.isEnabledCell) {
            animateProgress(true, isAnimate);
        }
        setEnabledCell(true);
    }

    static /* synthetic */ void animateProgress$default(MeowBottomNavigationCell meowBottomNavigationCell, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        meowBottomNavigationCell.animateProgress(z, z2);
    }

    private final void animateProgress(boolean enableCell, boolean isAnimate) {
        long d = enableCell ? this.duration : 250;
        ValueAnimator $receiver = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        $receiver.setStartDelay(enableCell ? d / ((long) 4) : 0);
        $receiver.setDuration(isAnimate ? d : 1);
        $receiver.setInterpolator(new FastOutSlowInInterpolator());
        $receiver.addUpdateListener(new MeowBottomNavigationCell$animateProgress$$inlined$apply$lambda$1(this, enableCell, d, isAnimate));
        $receiver.start();
    }
}
