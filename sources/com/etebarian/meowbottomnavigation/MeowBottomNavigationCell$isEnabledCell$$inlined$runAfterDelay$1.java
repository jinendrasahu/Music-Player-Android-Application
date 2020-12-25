package com.etebarian.meowbottomnavigation;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "run", "com/etebarian/meowbottomnavigation/UtilsKt$runAfterDelay$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class MeowBottomNavigationCell$isEnabledCell$$inlined$runAfterDelay$1 implements Runnable {
    final /* synthetic */ View $this_runAfterDelay;

    public MeowBottomNavigationCell$isEnabledCell$$inlined$runAfterDelay$1(View view) {
        this.$this_runAfterDelay = view;
    }

    public final void run() {
        try {
            ((FrameLayout) ((FrameLayout) this.$this_runAfterDelay).findViewById(R.id.fl)).setBackgroundColor(0);
        } catch (Exception e) {
        }
    }
}
