package com.ismaeldivita.chipnavigation.util;

import android.view.View;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a,\u0010\u000b\u001a\u00020\u0005*\u00020\u00032\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\rH\u0002¨\u0006\u000f"}, d2 = {"recordInitialPaddingForView", "Lcom/ismaeldivita/chipnavigation/util/InitialPadding;", "view", "Landroid/view/View;", "applyWindowInsets", "", "left", "", "top", "right", "bottom", "doOnApplyWindowInset", "f", "Lkotlin/Function3;", "Landroid/view/WindowInsets;", "chip-navigation-bar_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Insets.kt */
public final class InsetsKt {
    public static final void applyWindowInsets(View $this$applyWindowInsets, boolean left, boolean top, boolean right, boolean bottom) {
        Intrinsics.checkParameterIsNotNull($this$applyWindowInsets, "$this$applyWindowInsets");
        doOnApplyWindowInset($this$applyWindowInsets, new InsetsKt$applyWindowInsets$1(left, top, right, bottom));
    }

    private static final void doOnApplyWindowInset(View $this$doOnApplyWindowInset, Function3<? super View, ? super WindowInsets, ? super InitialPadding, Unit> f) {
        $this$doOnApplyWindowInset.setOnApplyWindowInsetsListener(new InsetsKt$doOnApplyWindowInset$1(f, recordInitialPaddingForView($this$doOnApplyWindowInset)));
        if ($this$doOnApplyWindowInset.isAttachedToWindow()) {
            $this$doOnApplyWindowInset.requestApplyInsets();
        } else {
            $this$doOnApplyWindowInset.addOnAttachStateChangeListener(new InsetsKt$doOnApplyWindowInset$2());
        }
    }

    private static final InitialPadding recordInitialPaddingForView(View view) {
        return new InitialPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
