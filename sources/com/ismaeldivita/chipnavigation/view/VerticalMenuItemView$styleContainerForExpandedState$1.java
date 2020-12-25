package com.ismaeldivita.chipnavigation.view;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/ViewGroup$MarginLayoutParams;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: VerticalMenuItemView.kt */
final class VerticalMenuItemView$styleContainerForExpandedState$1 extends Lambda implements Function1<ViewGroup.MarginLayoutParams, Unit> {
    public static final VerticalMenuItemView$styleContainerForExpandedState$1 INSTANCE = new VerticalMenuItemView$styleContainerForExpandedState$1();

    VerticalMenuItemView$styleContainerForExpandedState$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ViewGroup.MarginLayoutParams) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ViewGroup.MarginLayoutParams $this$updateLayoutParams) {
        Intrinsics.checkParameterIsNotNull($this$updateLayoutParams, "$receiver");
        $this$updateLayoutParams.setMarginStart(0);
    }
}