package com.etebarian.meowbottomnavigation;

import android.view.View;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/etebarian/meowbottomnavigation/MeowBottomNavigation$add$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigation.kt */
final class MeowBottomNavigation$add$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ MeowBottomNavigationCell $cell$inlined;
    final /* synthetic */ MeowBottomNavigation.Model $model$inlined;
    final /* synthetic */ MeowBottomNavigation this$0;

    MeowBottomNavigation$add$$inlined$apply$lambda$1(MeowBottomNavigation meowBottomNavigation, MeowBottomNavigation.Model model, MeowBottomNavigationCell meowBottomNavigationCell) {
        this.this$0 = meowBottomNavigation;
        this.$model$inlined = model;
        this.$cell$inlined = meowBottomNavigationCell;
    }

    public final void onClick(View it) {
        if (!this.$cell$inlined.isEnabledCell() && !this.this$0.isAnimating) {
            MeowBottomNavigation.show$default(this.this$0, this.$model$inlined.getId(), false, 2, (Object) null);
            this.this$0.mOnClickedListener.invoke(this.$model$inlined);
        }
    }
}
