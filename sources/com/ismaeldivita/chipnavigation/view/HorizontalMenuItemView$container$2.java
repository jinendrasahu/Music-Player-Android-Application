package com.ismaeldivita.chipnavigation.view;

import android.view.View;
import com.ismaeldivita.chipnavigation.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: HorizontalMenuItemView.kt */
final class HorizontalMenuItemView$container$2 extends Lambda implements Function0<View> {
    final /* synthetic */ HorizontalMenuItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HorizontalMenuItemView$container$2(HorizontalMenuItemView horizontalMenuItemView) {
        super(0);
        this.this$0 = horizontalMenuItemView;
    }

    public final View invoke() {
        return this.this$0.findViewById(R.id.cbn_item_internal_container);
    }
}
