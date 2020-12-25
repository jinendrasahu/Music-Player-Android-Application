package com.ismaeldivita.chipnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ismaeldivita.chipnavigation.model.Menu;
import com.ismaeldivita.chipnavigation.model.MenuItem;
import com.ismaeldivita.chipnavigation.model.MenuParser;
import com.ismaeldivita.chipnavigation.model.MenuStyle;
import com.ismaeldivita.chipnavigation.util.InsetsKt;
import com.ismaeldivita.chipnavigation.util.ViewGroupKt;
import com.ismaeldivita.chipnavigation.view.HorizontalMenuItemView;
import com.ismaeldivita.chipnavigation.view.MenuItemView;
import com.ismaeldivita.chipnavigation.view.VerticalMenuItemView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u000256B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\tH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010 \u001a\u00020\tJ\b\u0010!\u001a\u00020\u001cH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\n\u0010%\u001a\u0004\u0018\u00010$H\u0014J\u0016\u0010&\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000bJ\u0018\u0010(\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010)\u001a\u00020\u000bJ \u0010(\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0013J\u0010\u0010-\u001a\u00020\u00152\b\b\u0001\u0010\u000e\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\tJ\u001a\u00100\u001a\u00020\u00152\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001502J\u000e\u00100\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rJ\u000e\u00103\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\tJ\u0018\u00103\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\b\b\u0001\u00104\u001a\u00020\tR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ismaeldivita/chipnavigation/ChipNavigationBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "badgesState", "", "", "isExpanded", "", "listener", "Lcom/ismaeldivita/chipnavigation/ChipNavigationBar$OnItemSelectedListener;", "menuRes", "menuStyle", "Lcom/ismaeldivita/chipnavigation/model/MenuStyle;", "minimumExpandedWidth", "orientationMode", "Lcom/ismaeldivita/chipnavigation/ChipNavigationBar$MenuOrientation;", "collapse", "", "createMenuItem", "Lcom/ismaeldivita/chipnavigation/view/MenuItemView;", "dismissBadge", "id", "expand", "getHorizontalFlow", "Landroidx/constraintlayout/helper/widget/Flow;", "getItemById", "getSelectedItem", "Landroid/view/View;", "getSelectedItemId", "getVerticalFlow", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setItemEnabled", "isEnabled", "setItemSelected", "isSelected", "dispatchAction", "setMenuOrientation", "menuOrientation", "setMenuResource", "setMinimumExpandedWidth", "minExpandedWidth", "setOnItemSelectedListener", "block", "Lkotlin/Function1;", "showBadge", "count", "MenuOrientation", "OnItemSelectedListener", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ChipNavigationBar.kt */
public final class ChipNavigationBar extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private final Map<Integer, Integer> badgesState;
    private boolean isExpanded;
    private OnItemSelectedListener listener;
    private int menuRes;
    private final MenuStyle menuStyle;
    private int minimumExpandedWidth;
    private MenuOrientation orientationMode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ismaeldivita/chipnavigation/ChipNavigationBar$MenuOrientation;", "", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ChipNavigationBar.kt */
    public enum MenuOrientation {
        HORIZONTAL,
        VERTICAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ismaeldivita/chipnavigation/ChipNavigationBar$OnItemSelectedListener;", "", "onItemSelected", "", "id", "", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ChipNavigationBar.kt */
    public interface OnItemSelectedListener {
        void onItemSelected(int i);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[MenuOrientation.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[MenuOrientation.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[MenuOrientation.values().length];

        static {
            $EnumSwitchMapping$0[MenuOrientation.HORIZONTAL.ordinal()] = 1;
            $EnumSwitchMapping$0[MenuOrientation.VERTICAL.ordinal()] = 2;
            $EnumSwitchMapping$1[MenuOrientation.VERTICAL.ordinal()] = 1;
            $EnumSwitchMapping$1[MenuOrientation.HORIZONTAL.ordinal()] = 2;
            $EnumSwitchMapping$2[MenuOrientation.HORIZONTAL.ordinal()] = 1;
            $EnumSwitchMapping$2[MenuOrientation.VERTICAL.ordinal()] = 2;
        }
    }

    public ChipNavigationBar(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        MenuOrientation orientation;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.menuRes = -1;
        this.badgesState = new LinkedHashMap();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChipNavigationBar);
        int menuResource = a.getResourceId(R.styleable.ChipNavigationBar_cnb_menuResource, -1);
        float minExpanded = a.getDimension(R.styleable.ChipNavigationBar_cnb_minExpandedWidth, 0.0f);
        boolean leftInset = a.getBoolean(R.styleable.ChipNavigationBar_cnb_addLeftInset, false);
        boolean topInset = a.getBoolean(R.styleable.ChipNavigationBar_cnb_addTopInset, false);
        boolean rightInset = a.getBoolean(R.styleable.ChipNavigationBar_cnb_addRightInset, false);
        boolean bottomInset = a.getBoolean(R.styleable.ChipNavigationBar_cnb_addBottomInset, false);
        int i = a.getInt(R.styleable.ChipNavigationBar_cnb_orientationMode, 0);
        if (i == 0) {
            orientation = MenuOrientation.HORIZONTAL;
        } else if (i != 1) {
            orientation = MenuOrientation.HORIZONTAL;
        } else {
            orientation = MenuOrientation.VERTICAL;
        }
        Intrinsics.checkExpressionValueIsNotNull(a, "a");
        this.menuStyle = new MenuStyle(context, a);
        a.recycle();
        setMenuOrientation(orientation);
        if (menuResource >= 0) {
            setMenuResource(menuResource);
        }
        setMinimumExpandedWidth((int) minExpanded);
        InsetsKt.applyWindowInsets(this, leftInset, topInset, rightInset, bottomInset);
        collapse();
        setClickable(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChipNavigationBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setMenuResource(int menuRes2) {
        Flow p1;
        this.menuRes = menuRes2;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        Menu menu = new MenuParser(context).parse(menuRes2, this.menuStyle);
        Function1 childListener = new ChipNavigationBar$setMenuResource$childListener$1(this);
        removeAllViews();
        for (MenuItem it : menu.getItems()) {
            MenuItemView p12 = createMenuItem();
            MenuItemView $this$apply = p12;
            $this$apply.bind(it);
            $this$apply.setOnClickListener(new ChipNavigationBar$sam$i$android_view_View_OnClickListener$0(childListener));
            addView(p12);
        }
        MenuOrientation menuOrientation = this.orientationMode;
        if (menuOrientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationMode");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[menuOrientation.ordinal()];
        if (i == 1) {
            p1 = getHorizontalFlow();
        } else if (i == 2) {
            p1 = getVerticalFlow();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Flow $this$apply2 = p1;
        Iterable<MenuItem> $this$map$iv = menu.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (MenuItem it2 : $this$map$iv) {
            destination$iv$iv.add(Integer.valueOf(it2.getId()));
        }
        $this$apply2.setReferencedIds(CollectionsKt.toIntArray((Collection) ((List) destination$iv$iv)));
        addView(p1);
    }

    public final void setMenuOrientation(MenuOrientation menuOrientation) {
        Intrinsics.checkParameterIsNotNull(menuOrientation, "menuOrientation");
        this.orientationMode = menuOrientation;
    }

    public final void setItemEnabled(int id, boolean isEnabled) {
        MenuItemView itemById = getItemById(id);
        if (itemById != null) {
            itemById.setEnabled(isEnabled);
        }
    }

    public static /* synthetic */ void setItemSelected$default(ChipNavigationBar chipNavigationBar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        chipNavigationBar.setItemSelected(i, z);
    }

    public final void setItemSelected(int id, boolean isSelected) {
        setItemSelected(id, isSelected, true);
    }

    public final void setMinimumExpandedWidth(int minExpandedWidth) {
        this.minimumExpandedWidth = minExpandedWidth;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener listener2) {
        Intrinsics.checkParameterIsNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener2;
    }

    public final void setOnItemSelectedListener(Function1<? super Integer, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        setOnItemSelectedListener((OnItemSelectedListener) new ChipNavigationBar$setOnItemSelectedListener$1(block));
    }

    public final void showBadge(int id) {
        this.badgesState.put(Integer.valueOf(id), 0);
        MenuItemView itemById = getItemById(id);
        if (itemById != null) {
            MenuItemView.showBadge$default(itemById, 0, 1, (Object) null);
        }
    }

    public final void showBadge(int id, int count) {
        this.badgesState.put(Integer.valueOf(id), Integer.valueOf(count));
        MenuItemView itemById = getItemById(id);
        if (itemById != null) {
            itemById.showBadge(count);
        }
    }

    public final void dismissBadge(int id) {
        this.badgesState.remove(Integer.valueOf(id));
        MenuItemView itemById = getItemById(id);
        if (itemById != null) {
            itemById.dismissBadge();
        }
    }

    public final void collapse() {
        this.isExpanded = false;
        MenuOrientation menuOrientation = this.orientationMode;
        if (menuOrientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationMode");
        }
        if (menuOrientation == MenuOrientation.VERTICAL) {
            int childCount = getChildCount();
            for (int i$iv = 0; i$iv < childCount; i$iv++) {
                View it = getChildAt(i$iv);
                Intrinsics.checkExpressionValueIsNotNull(it, "getChildAt(i)");
                it.setMinimumWidth(0);
                VerticalMenuItemView verticalMenuItemView = (VerticalMenuItemView) (!(it instanceof VerticalMenuItemView) ? null : it);
                if (verticalMenuItemView != null) {
                    verticalMenuItemView.collapse();
                }
            }
        }
    }

    public final void expand() {
        this.isExpanded = true;
        MenuOrientation menuOrientation = this.orientationMode;
        if (menuOrientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationMode");
        }
        if (menuOrientation == MenuOrientation.VERTICAL) {
            int childCount = getChildCount();
            for (int i$iv = 0; i$iv < childCount; i$iv++) {
                View it = getChildAt(i$iv);
                Intrinsics.checkExpressionValueIsNotNull(it, "getChildAt(i)");
                it.setMinimumWidth(this.minimumExpandedWidth);
                VerticalMenuItemView verticalMenuItemView = (VerticalMenuItemView) (!(it instanceof VerticalMenuItemView) ? null : it);
                if (verticalMenuItemView != null) {
                    verticalMenuItemView.expand();
                }
            }
        }
    }

    public final boolean isExpanded() {
        MenuOrientation menuOrientation = this.orientationMode;
        if (menuOrientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationMode");
        }
        int i = WhenMappings.$EnumSwitchMapping$1[menuOrientation.ordinal()];
        if (i == 1) {
            return this.isExpanded;
        }
        if (i == 2) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getSelectedItemId() {
        View selectedItem = getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId();
        }
        return -1;
    }

    private final void setItemSelected(int id, boolean isSelected, boolean dispatchAction) {
        MenuItemView it;
        OnItemSelectedListener onItemSelectedListener;
        View selectedItem = getSelectedItem();
        if (isSelected && (selectedItem == null || selectedItem.getId() != id)) {
            if (selectedItem != null) {
                selectedItem.setSelected(false);
            }
            MenuItemView it2 = getItemById(id);
            if (it2 != null) {
                TransitionManager.beginDelayedTransition(this);
                it2.setSelected(true);
                if (dispatchAction && (onItemSelectedListener = this.listener) != null) {
                    onItemSelectedListener.onItemSelected(id);
                }
            }
        } else if (!isSelected && (it = getItemById(id)) != null) {
            TransitionManager.beginDelayedTransition(this);
            it.setSelected(false);
        }
    }

    private final View getSelectedItem() {
        View it;
        Iterator<View> it2 = ViewGroupKt.getChildren(this).iterator();
        while (true) {
            if (!it2.hasNext()) {
                it = null;
                break;
            }
            it = it2.next();
            if (it.isSelected()) {
                break;
            }
        }
        return it;
    }

    private final MenuItemView getItemById(int id) {
        View view;
        boolean z;
        Sequence $this$filterIsInstance$iv = SequencesKt.filter(ViewGroupKt.getChildren(this), ChipNavigationBar$getItemById$$inlined$filterIsInstance$1.INSTANCE);
        if ($this$filterIsInstance$iv != null) {
            Iterator<View> it = $this$filterIsInstance$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                view = it.next();
                if (((MenuItemView) view).getId() == id) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return (MenuItemView) view;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    private final MenuItemView createMenuItem() {
        MenuOrientation menuOrientation = this.orientationMode;
        if (menuOrientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationMode");
        }
        int i = WhenMappings.$EnumSwitchMapping$2[menuOrientation.ordinal()];
        if (i == 1) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            return new HorizontalMenuItemView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        } else if (i == 2) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            return new VerticalMenuItemView(context2, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final Flow getHorizontalFlow() {
        Flow flow = new Flow(getContext());
        Flow $this$apply = flow;
        $this$apply.setOrientation(0);
        $this$apply.setHorizontalStyle(0);
        $this$apply.setHorizontalAlign(0);
        $this$apply.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return flow;
    }

    private final Flow getVerticalFlow() {
        Flow flow = new Flow(getContext());
        Flow $this$apply = flow;
        $this$apply.setOrientation(1);
        $this$apply.setHorizontalAlign(0);
        $this$apply.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return flow;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        State state = new State(super.onSaveInstanceState(), new Bundle());
        State $this$apply = state;
        $this$apply.setMenuId(this.menuRes);
        $this$apply.setSelectedItem(getSelectedItemId());
        $this$apply.setBadges(this.badgesState);
        $this$apply.setExpanded(this.isExpanded);
        $this$apply.setEnabled(MapsKt.toMap(SequencesKt.map(ViewGroupKt.getChildren(this), ChipNavigationBar$onSaveInstanceState$1$1.INSTANCE)));
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        MenuItemView itemById;
        if (state instanceof State) {
            super.onRestoreInstanceState(((State) state).getSuperState());
            if (((State) state).getMenuId() != -1) {
                setMenuResource(((State) state).getMenuId());
            }
            if (((State) state).getSelectedItem() != -1) {
                setItemSelected(((State) state).getSelectedItem(), true, false);
            }
            if (((State) state).getExpanded()) {
                expand();
            } else {
                collapse();
            }
            for (Map.Entry $dstr$itemId$count : ((State) state).getBadges().entrySet()) {
                int itemId = ((Number) $dstr$itemId$count.getKey()).intValue();
                int count = ((Number) $dstr$itemId$count.getValue()).intValue();
                if (count > 0) {
                    showBadge(itemId, count);
                } else {
                    showBadge(itemId);
                }
            }
            for (Map.Entry $dstr$itemId$isEnabled : ((State) state).getEnabled().entrySet()) {
                int itemId2 = ((Number) $dstr$itemId$isEnabled.getKey()).intValue();
                boolean isEnabled = ((Boolean) $dstr$itemId$isEnabled.getValue()).booleanValue();
                if (!isEnabled && (itemById = getItemById(itemId2)) != null) {
                    itemById.setEnabled(isEnabled);
                }
            }
            return;
        }
        super.onRestoreInstanceState(state);
    }
}
