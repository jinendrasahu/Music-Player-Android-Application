package com.ismaeldivita.chipnavigation.model;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.ismaeldivita.chipnavigation.R;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ismaeldivita/chipnavigation/model/MenuStyle;", "", "context", "Landroid/content/Context;", "attr", "Landroid/content/res/TypedArray;", "(Landroid/content/Context;Landroid/content/res/TypedArray;)V", "badgeColor", "", "getBadgeColor", "()I", "iconSize", "getIconSize", "radius", "", "getRadius", "()F", "textAppearance", "getTextAppearance", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "unselectedColor", "getUnselectedColor", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: MenuStyle.kt */
public final class MenuStyle {
    private final int badgeColor;
    private final int iconSize;
    private final float radius;
    private final Integer textAppearance;
    private final int unselectedColor;

    public MenuStyle(Context context, TypedArray attr) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        Integer valueOf = Integer.valueOf(attr.getResourceId(R.styleable.ChipNavigationBar_cnb_textAppearance, -1));
        this.textAppearance = !(valueOf.intValue() > 0) ? null : valueOf;
        this.radius = attr.getDimension(R.styleable.ChipNavigationBar_cnb_radius, FloatCompanionObject.INSTANCE.getMAX_VALUE());
        this.badgeColor = attr.getColor(R.styleable.ChipNavigationBar_cnb_badgeColor, ContextCompat.getColor(context, R.color.cnb_default_badge_color));
        this.unselectedColor = attr.getColor(R.styleable.ChipNavigationBar_cnb_unselectedColor, ContextCompat.getColor(context, R.color.cnb_default_unselected_color));
        this.iconSize = (int) attr.getDimension(R.styleable.ChipNavigationBar_cnb_iconSize, context.getResources().getDimension(R.dimen.cnb_icon_size));
    }

    public final int getBadgeColor() {
        return this.badgeColor;
    }

    public final int getUnselectedColor() {
        return this.unselectedColor;
    }

    public final Integer getTextAppearance() {
        return this.textAppearance;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getIconSize() {
        return this.iconSize;
    }
}
