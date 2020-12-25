package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001?B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010*\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001eJ\"\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020\tJ\u0010\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020\tJ\u000e\u00101\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tJ\b\u00102\u001a\u00020\"H\u0002J\u000e\u00103\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\tJ\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0014J\u0018\u00107\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u00108\u001a\u00020\"2\u0006\u0010-\u001a\u00020\t2\u0006\u00109\u001a\u00020:J-\u0010;\u001a\u00020\"2%\u0010<\u001a!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001dj\u0002`#J-\u0010=\u001a\u00020\"2%\u0010<\u001a!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001dj\u0002`#J\u0018\u0010>\u001a\u00020\"2\u0006\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R-\u0010\u001c\u001a!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001dj\u0002`#X\u000e¢\u0006\u0002\n\u0000R-\u0010$\u001a!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001dj\u0002`#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u000fj\b\u0012\u0004\u0012\u00020\u001e`\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/etebarian/meowbottomnavigation/MeowBottomNavigation;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundBottomColor", "bezierView", "Lcom/etebarian/meowbottomnavigation/BezierView;", "cells", "Ljava/util/ArrayList;", "Lcom/etebarian/meowbottomnavigation/MeowBottomNavigationCell;", "Lkotlin/collections/ArrayList;", "countBackgroundColor", "countTextColor", "countTypeface", "Landroid/graphics/Typeface;", "defaultIconColor", "heightCell", "isAnimating", "", "ll_cells", "Landroid/widget/LinearLayout;", "mOnClickedListener", "Lkotlin/Function1;", "Lcom/etebarian/meowbottomnavigation/MeowBottomNavigation$Model;", "Lkotlin/ParameterName;", "name", "model", "", "Lcom/etebarian/meowbottomnavigation/IBottomNavigationListener;", "mOnShowListener", "models", "rippleColor", "selectedIconColor", "selectedId", "shadowColor", "add", "anim", "cell", "id", "enableAnimation", "getCellById", "getModelById", "getModelPosition", "initializeViews", "isShowing", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAttributeFromXml", "setCount", "count", "", "setOnClickMenuListener", "listener", "setOnShowListener", "show", "Model", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigation.kt */
public final class MeowBottomNavigation extends FrameLayout {
    private HashMap _$_findViewCache;
    private int backgroundBottomColor = Color.parseColor("#ffffff");
    /* access modifiers changed from: private */
    public BezierView bezierView;
    private ArrayList<MeowBottomNavigationCell> cells = new ArrayList<>();
    private int countBackgroundColor = Color.parseColor("#ff0000");
    private int countTextColor = Color.parseColor("#ffffff");
    private Typeface countTypeface;
    private int defaultIconColor = Color.parseColor("#757575");
    private int heightCell;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private LinearLayout ll_cells;
    /* access modifiers changed from: private */
    public Function1<? super Model, Unit> mOnClickedListener = MeowBottomNavigation$mOnClickedListener$1.INSTANCE;
    private Function1<? super Model, Unit> mOnShowListener = MeowBottomNavigation$mOnShowListener$1.INSTANCE;
    private ArrayList<Model> models = new ArrayList<>();
    private int rippleColor = Color.parseColor("#757575");
    private int selectedIconColor = Color.parseColor("#2196f3");
    private int selectedId = -1;
    private int shadowColor = -4539718;

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

    public static final /* synthetic */ BezierView access$getBezierView$p(MeowBottomNavigation $this) {
        BezierView bezierView2 = $this.bezierView;
        if (bezierView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bezierView");
        }
        return bezierView2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigation(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.heightCell = UtilsKt.dip(context2, 72);
        initializeViews();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.heightCell = UtilsKt.dip(context2, 72);
        setAttributeFromXml(context, attrs);
        initializeViews();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeowBottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.heightCell = UtilsKt.dip(context2, 72);
        setAttributeFromXml(context, attrs);
        initializeViews();
    }

    private final void setAttributeFromXml(Context context, AttributeSet attrs) {
        boolean z = false;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MeowBottomNavigation, 0, 0);
        if (a != null) {
            TypedArray $receiver = a;
            try {
                this.defaultIconColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_defaultIconColor, this.defaultIconColor);
                this.selectedIconColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_selectedIconColor, this.selectedIconColor);
                this.backgroundBottomColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_backgroundBottomColor, this.backgroundBottomColor);
                this.countTextColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_countTextColor, this.countTextColor);
                this.countBackgroundColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_countBackgroundColor, this.countBackgroundColor);
                String typeface = $receiver.getString(R.styleable.MeowBottomNavigation_mbn_countTypeface);
                this.rippleColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_rippleColor, this.rippleColor);
                this.shadowColor = $receiver.getColor(R.styleable.MeowBottomNavigation_mbn_shadowColor, this.shadowColor);
                if (typeface != null) {
                    if (typeface.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        this.countTypeface = Typeface.createFromAsset(context.getAssets(), typeface);
                    }
                }
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

    private final void initializeViews() {
        this.ll_cells = new LinearLayout(getContext());
        LinearLayout $receiver = this.ll_cells;
        if ($receiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ll_cells");
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, this.heightCell);
        params.gravity = 80;
        $receiver.setLayoutParams(params);
        $receiver.setOrientation(0);
        $receiver.setClipChildren(false);
        $receiver.setClipToPadding(false);
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.bezierView = new BezierView(context);
        BezierView $receiver2 = this.bezierView;
        if ($receiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bezierView");
        }
        $receiver2.setLayoutParams(new FrameLayout.LayoutParams(-1, this.heightCell));
        $receiver2.setColor(this.backgroundBottomColor);
        $receiver2.setShadowColor(this.shadowColor);
        BezierView bezierView2 = this.bezierView;
        if (bezierView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bezierView");
        }
        addView(bezierView2);
        LinearLayout linearLayout = this.ll_cells;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ll_cells");
        }
        addView(linearLayout);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.selectedId == -1) {
            BezierView bezierView2 = this.bezierView;
            if (bezierView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bezierView");
            }
            if (Build.VERSION.SDK_INT < 17 || getLayoutDirection() != 1) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                f = -UtilsKt.dipf(context, 72);
            } else {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                f = ((float) getMeasuredWidth()) + UtilsKt.dipf(context2, 72);
            }
            bezierView2.setBezierX(f);
        }
        int i = this.selectedId;
        if (i != -1) {
            show(i, false);
        }
    }

    public final void add(Model model) {
        Intrinsics.checkParameterIsNotNull(model, "model");
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        MeowBottomNavigationCell cell = new MeowBottomNavigationCell(context);
        MeowBottomNavigationCell $receiver = cell;
        $receiver.setLayoutParams(new LinearLayout.LayoutParams(0, this.heightCell, 1.0f));
        $receiver.setIcon(model.getIcon());
        $receiver.setCount(model.getCount());
        $receiver.setCircleColor(this.backgroundBottomColor);
        $receiver.setCountTextColor(this.countTextColor);
        $receiver.setCountBackgroundColor(this.countBackgroundColor);
        $receiver.setCountTypeface(this.countTypeface);
        $receiver.setRippleColor(this.rippleColor);
        $receiver.setDefaultIconColor(this.defaultIconColor);
        $receiver.setSelectedIconColor(this.selectedIconColor);
        $receiver.setOnClickListener(new MeowBottomNavigation$add$$inlined$apply$lambda$1(this, model, cell));
        $receiver.disableCell();
        LinearLayout linearLayout = this.ll_cells;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ll_cells");
        }
        linearLayout.addView($receiver);
        this.cells.add(cell);
        this.models.add(model);
    }

    public static /* synthetic */ void show$default(MeowBottomNavigation meowBottomNavigation, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        meowBottomNavigation.show(i, z);
    }

    public final void show(int id, boolean enableAnimation) {
        int size = this.models.size();
        for (int i = 0; i < size; i++) {
            Model model = this.models.get(i);
            Intrinsics.checkExpressionValueIsNotNull(model, "models[i]");
            Model model2 = model;
            MeowBottomNavigationCell meowBottomNavigationCell = this.cells.get(i);
            Intrinsics.checkExpressionValueIsNotNull(meowBottomNavigationCell, "cells[i]");
            MeowBottomNavigationCell cell = meowBottomNavigationCell;
            if (model2.getId() == id) {
                anim(cell, id, enableAnimation);
                MeowBottomNavigationCell.enableCell$default(cell, false, 1, (Object) null);
                this.mOnShowListener.invoke(model2);
            } else {
                cell.disableCell();
            }
        }
        this.selectedId = id;
    }

    static /* synthetic */ void anim$default(MeowBottomNavigation meowBottomNavigation, MeowBottomNavigationCell meowBottomNavigationCell, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        meowBottomNavigation.anim(meowBottomNavigationCell, i, z);
    }

    private final void anim(MeowBottomNavigationCell cell, int id, boolean enableAnimation) {
        boolean z = true;
        this.isAnimating = true;
        int pos = getModelPosition(id);
        int nowPos = getModelPosition(this.selectedId);
        long d = (((long) Math.abs(pos - (nowPos < 0 ? 0 : nowPos))) * 100) + 150;
        long animDuration = enableAnimation ? d : 1;
        FastOutSlowInInterpolator animInterpolator = new FastOutSlowInInterpolator();
        ValueAnimator $receiver = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        $receiver.setDuration(animDuration);
        $receiver.setInterpolator(animInterpolator);
        BezierView bezierView2 = this.bezierView;
        if (bezierView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bezierView");
        }
        ValueAnimator $receiver2 = $receiver;
        long animDuration2 = animDuration;
        long d2 = d;
        $receiver2.addUpdateListener(new MeowBottomNavigation$anim$$inlined$apply$lambda$1(bezierView2.getBezierX(), this, animDuration, animInterpolator, cell));
        $receiver2.start();
        if (Math.abs(pos - nowPos) > 1) {
            ValueAnimator $receiver3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            long animDuration3 = animDuration2;
            $receiver3.setDuration(animDuration3);
            $receiver3.setInterpolator(animInterpolator);
            $receiver3.addUpdateListener(new MeowBottomNavigation$anim$$inlined$apply$lambda$2(this, animDuration3, animInterpolator));
            $receiver3.start();
        }
        if (pos <= nowPos) {
            z = false;
        }
        cell.setFromLeft(z);
        Iterable<MeowBottomNavigationCell> $receiver$iv = this.cells;
        for (MeowBottomNavigationCell it : $receiver$iv) {
            it.setDuration(d2);
            $receiver$iv = $receiver$iv;
            MeowBottomNavigationCell meowBottomNavigationCell = cell;
        }
    }

    public final boolean isShowing(int id) {
        return this.selectedId == id;
    }

    public final Model getModelById(int id) {
        for (Model it : this.models) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }

    public final MeowBottomNavigationCell getCellById(int id) {
        return this.cells.get(getModelPosition(id));
    }

    public final int getModelPosition(int id) {
        int size = this.models.size();
        for (int i = 0; i < size; i++) {
            Model item = this.models.get(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "models[i]");
            if (item.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public final void setCount(int id, String count) {
        Intrinsics.checkParameterIsNotNull(count, "count");
        Model model = getModelById(id);
        if (model != null) {
            int pos = getModelPosition(id);
            model.setCount(count);
            this.cells.get(pos).setCount(count);
        }
    }

    public final void setOnShowListener(Function1<? super Model, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mOnShowListener = listener;
    }

    public final void setOnClickMenuListener(Function1<? super Model, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mOnClickedListener = listener;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/etebarian/meowbottomnavigation/MeowBottomNavigation$Model;", "", "id", "", "icon", "(II)V", "count", "", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getId", "setId", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: MeowBottomNavigation.kt */
    public static final class Model {
        private String count = MeowBottomNavigationCell.EMPTY_VALUE;
        private int icon;
        private int id;

        public Model(int id2, int icon2) {
            this.id = id2;
            this.icon = icon2;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final int getId() {
            return this.id;
        }

        public final void setIcon(int i) {
            this.icon = i;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getCount() {
            return this.count;
        }

        public final void setCount(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.count = str;
        }
    }
}
