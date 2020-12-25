package com.ismaeldivita.chipnavigation.util;

import android.view.View;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "insets", "onApplyWindowInsets"}, k = 3, mv = {1, 1, 15})
/* compiled from: Insets.kt */
final class InsetsKt$doOnApplyWindowInset$1 implements View.OnApplyWindowInsetsListener {
    final /* synthetic */ Function3 $f;
    final /* synthetic */ InitialPadding $initialPadding;

    InsetsKt$doOnApplyWindowInset$1(Function3 function3, InitialPadding initialPadding) {
        this.$f = function3;
        this.$initialPadding = initialPadding;
    }

    public final WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
        Function3 function3 = this.$f;
        Intrinsics.checkExpressionValueIsNotNull(v, "v");
        Intrinsics.checkExpressionValueIsNotNull(insets, "insets");
        function3.invoke(v, insets, this.$initialPadding);
        return insets;
    }
}
