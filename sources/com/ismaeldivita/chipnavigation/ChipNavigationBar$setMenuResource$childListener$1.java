package com.ismaeldivita.chipnavigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: ChipNavigationBar.kt */
final class ChipNavigationBar$setMenuResource$childListener$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ChipNavigationBar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipNavigationBar$setMenuResource$childListener$1(ChipNavigationBar chipNavigationBar) {
        super(1);
        this.this$0 = chipNavigationBar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ChipNavigationBar.setItemSelected$default(this.this$0, view.getId(), false, 2, (Object) null);
    }
}
