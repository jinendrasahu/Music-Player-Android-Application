package com.ismaeldivita.chipnavigation.view;

import android.widget.TextView;
import com.ismaeldivita.chipnavigation.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: VerticalMenuItemView.kt */
final class VerticalMenuItemView$countLabel$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ VerticalMenuItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerticalMenuItemView$countLabel$2(VerticalMenuItemView verticalMenuItemView) {
        super(0);
        this.this$0 = verticalMenuItemView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.cbn_item_notification_count);
    }
}
