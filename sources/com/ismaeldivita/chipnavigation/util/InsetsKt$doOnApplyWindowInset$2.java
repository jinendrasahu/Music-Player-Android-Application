package com.ismaeldivita.chipnavigation.util;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/ismaeldivita/chipnavigation/util/InsetsKt$doOnApplyWindowInset$2", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: Insets.kt */
public final class InsetsKt$doOnApplyWindowInset$2 implements View.OnAttachStateChangeListener {
    InsetsKt$doOnApplyWindowInset$2() {
    }

    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        v.removeOnAttachStateChangeListener(this);
        v.requestApplyInsets();
    }

    public void onViewDetachedFromWindow(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
    }
}
