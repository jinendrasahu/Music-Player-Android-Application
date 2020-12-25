package com.ismaeldivita.chipnavigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: ChipNavigationBar.kt */
final class ChipNavigationBar$onSaveInstanceState$1$1 extends Lambda implements Function1<View, Pair<? extends Integer, ? extends Boolean>> {
    public static final ChipNavigationBar$onSaveInstanceState$1$1 INSTANCE = new ChipNavigationBar$onSaveInstanceState$1$1();

    ChipNavigationBar$onSaveInstanceState$1$1() {
        super(1);
    }

    public final Pair<Integer, Boolean> invoke(View it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return TuplesKt.to(Integer.valueOf(it.getId()), Boolean.valueOf(it.isEnabled()));
    }
}
