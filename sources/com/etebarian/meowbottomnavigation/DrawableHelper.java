package com.etebarian.meowbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/etebarian/meowbottomnavigation/DrawableHelper;", "", "()V", "changeColorDrawableRes", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/content/Context;", "resDrawable", "", "color", "changeColorDrawableVector", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class DrawableHelper {
    public static final DrawableHelper INSTANCE = new DrawableHelper();

    private DrawableHelper() {
    }

    public final Drawable changeColorDrawableVector(Context c, int resDrawable, int color) {
        VectorDrawableCompat create;
        if (c == null || (create = VectorDrawableCompat.create(c.getResources(), resDrawable, (Resources.Theme) null)) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(create, "VectorDrawableCompat.cre…ble, null) ?: return null");
        VectorDrawableCompat d = create;
        d.mutate();
        if (color != -2) {
            d.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        return d;
    }

    public final Drawable changeColorDrawableRes(Context c, int resDrawable, int color) {
        Drawable drawable;
        if (c == null || (drawable = ContextCompat.getDrawable(c, resDrawable)) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(drawable, "ContextCompat.getDrawabl…sDrawable) ?: return null");
        Drawable d = drawable;
        d.mutate();
        if (color != -2) {
            d.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        return d;
    }
}
