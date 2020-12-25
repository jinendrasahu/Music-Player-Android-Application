package com.ismaeldivita.chipnavigation.util;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007*\u00020\u0002H\u0000\u001a\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u00020\u0002H\u0002\u001a/\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00052\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\rH\u0000¨\u0006\u000e"}, d2 = {"forEachChild", "", "Landroid/view/ViewGroup;", "block", "Lkotlin/Function1;", "Landroid/view/View;", "getChildren", "Lkotlin/sequences/Sequence;", "iterator", "", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "chip-navigation-bar_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: ViewGroup.kt */
public final class ViewGroupKt {
    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParams(View $this$updateLayoutParams, Function1<? super T, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$updateLayoutParams, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ViewGroup.LayoutParams lp = $this$updateLayoutParams.getLayoutParams();
        if (lp != null) {
            block.invoke(lp);
            $this$updateLayoutParams.setLayoutParams(lp);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public static final void forEachChild(ViewGroup $this$forEachChild, Function1<? super View, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$forEachChild, "$this$forEachChild");
        Intrinsics.checkParameterIsNotNull(block, "block");
        int childCount = $this$forEachChild.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = $this$forEachChild.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
            block.invoke(childAt);
        }
    }

    public static final Sequence<View> getChildren(ViewGroup $this$getChildren) {
        Intrinsics.checkParameterIsNotNull($this$getChildren, "$this$getChildren");
        return new ViewGroupKt$getChildren$1($this$getChildren);
    }

    /* access modifiers changed from: private */
    public static final Iterator<View> iterator(ViewGroup $this$iterator) {
        Intrinsics.checkParameterIsNotNull($this$iterator, "$this$iterator");
        return new ViewGroupKt$iterator$1($this$iterator);
    }
}
