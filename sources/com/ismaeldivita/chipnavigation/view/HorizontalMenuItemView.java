package com.ismaeldivita.chipnavigation.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.ismaeldivita.chipnavigation.R;
import com.ismaeldivita.chipnavigation.model.MenuItem;
import com.ismaeldivita.chipnavigation.model.MenuParser;
import com.ismaeldivita.chipnavigation.util.ImageViewKt;
import com.ismaeldivita.chipnavigation.util.TextViewKt;
import com.ismaeldivita.chipnavigation.util.ViewKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/ismaeldivita/chipnavigation/view/HorizontalMenuItemView;", "Lcom/ismaeldivita/chipnavigation/view/MenuItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "container", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContainer", "()Landroid/view/View;", "container$delegate", "Lkotlin/Lazy;", "icon", "Lcom/ismaeldivita/chipnavigation/view/BadgeImageView;", "getIcon", "()Lcom/ismaeldivita/chipnavigation/view/BadgeImageView;", "icon$delegate", "mask", "Landroid/graphics/drawable/Drawable;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "bind", "", "item", "Lcom/ismaeldivita/chipnavigation/model/MenuItem;", "dismissBadge", "setEnabled", "enabled", "", "setSelected", "selected", "showBadge", "count", "", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: HorizontalMenuItemView.kt */
public final class HorizontalMenuItemView extends MenuItemView {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private HashMap _$_findViewCache;
    private final Lazy container$delegate;
    private final Lazy icon$delegate;
    private Drawable mask;
    private final Lazy title$delegate;

    static {
        Class<HorizontalMenuItemView> cls = HorizontalMenuItemView.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "title", "getTitle()Landroid/widget/TextView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "icon", "getIcon()Lcom/ismaeldivita/chipnavigation/view/BadgeImageView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "container", "getContainer()Landroid/view/View;"))};
    }

    public HorizontalMenuItemView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    private final View getContainer() {
        Lazy lazy = this.container$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (View) lazy.getValue();
    }

    private final BadgeImageView getIcon() {
        Lazy lazy = this.icon$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (BadgeImageView) lazy.getValue();
    }

    private final TextView getTitle() {
        Lazy lazy = this.title$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (TextView) lazy.getValue();
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
    public HorizontalMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.title$delegate = LazyKt.lazy(new HorizontalMenuItemView$title$2(this));
        this.icon$delegate = LazyKt.lazy(new HorizontalMenuItemView$icon$2(this));
        this.container$delegate = LazyKt.lazy(new HorizontalMenuItemView$container$2(this));
        View.inflate(getContext(), R.layout.cnb_horizontal_menu_item, this);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HorizontalMenuItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public void bind(MenuItem item) {
        Intrinsics.checkParameterIsNotNull(item, MenuParser.XML_MENU_ITEM_TAG);
        setId(item.getId());
        setImportantForAccessibility(1);
        CharSequence contentDescription = item.getContentDescription();
        if (contentDescription == null) {
            contentDescription = item.getTitle();
        }
        setContentDescription(contentDescription);
        setEnabled(item.getEnabled());
        Integer textAppearance = item.getMenuStyle().getTextAppearance();
        if (textAppearance != null) {
            getTitle().setTextAppearance(textAppearance.intValue());
        }
        TextView title = getTitle();
        Intrinsics.checkExpressionValueIsNotNull(title, "title");
        title.setText(item.getTitle());
        getTitle().setTextColor(item.getTextColor());
        TextView title2 = getTitle();
        Intrinsics.checkExpressionValueIsNotNull(title2, "title");
        TextViewKt.setColorStateListAnimator(title2, item.getIconColor(), item.getMenuStyle().getUnselectedColor());
        BadgeImageView icon = getIcon();
        Intrinsics.checkExpressionValueIsNotNull(icon, "icon");
        icon.getLayoutParams().width = item.getMenuStyle().getIconSize();
        BadgeImageView icon2 = getIcon();
        Intrinsics.checkExpressionValueIsNotNull(icon2, "icon");
        icon2.getLayoutParams().height = item.getMenuStyle().getIconSize();
        getIcon().setImageResource(item.getIcon());
        getIcon().setBadgeColor(item.getMenuStyle().getBadgeColor());
        BadgeImageView icon3 = getIcon();
        Intrinsics.checkExpressionValueIsNotNull(icon3, "icon");
        ImageViewKt.setColorStateListAnimator(icon3, item.getIconColor(), item.getMenuStyle().getUnselectedColor(), item.getTintMode());
        GradientDrawable containerBackground = new GradientDrawable();
        GradientDrawable $this$apply = containerBackground;
        $this$apply.setCornerRadius(item.getMenuStyle().getRadius());
        $this$apply.setTint(item.getBackgroundColor());
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$apply2 = gradientDrawable;
        $this$apply2.setCornerRadius(item.getMenuStyle().getRadius());
        $this$apply2.setTint(ViewCompat.MEASURED_STATE_MASK);
        this.mask = gradientDrawable;
        View container = getContainer();
        Intrinsics.checkExpressionValueIsNotNull(container, "container");
        Drawable drawable = containerBackground;
        Drawable drawable2 = this.mask;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
        }
        ViewKt.setCustomRipple(container, drawable, drawable2);
    }

    public void showBadge(int count) {
        getIcon().showBadge(count);
    }

    public void dismissBadge() {
        getIcon().dismissBadge();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled && isSelected()) {
            setSelected(false);
        }
    }

    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            View container = getContainer();
            Intrinsics.checkExpressionValueIsNotNull(container, "container");
            container.setVisibility(8);
            Drawable drawable = this.mask;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mask");
            }
            drawable.jumpToCurrentState();
            View container2 = getContainer();
            Intrinsics.checkExpressionValueIsNotNull(container2, "container");
            container2.setVisibility(0);
            TextView title = getTitle();
            Intrinsics.checkExpressionValueIsNotNull(title, "title");
            title.setVisibility(0);
            return;
        }
        TextView title2 = getTitle();
        Intrinsics.checkExpressionValueIsNotNull(title2, "title");
        title2.setVisibility(8);
    }
}
