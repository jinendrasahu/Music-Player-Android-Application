package com.etebarian.meowbottomnavigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class UtilsKt$runAfterDelay$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ View $this_runAfterDelay;

    public UtilsKt$runAfterDelay$1(View view, Function1 function1) {
        this.$this_runAfterDelay = view;
        this.$f = function1;
    }

    public final void run() {
        try {
            this.$f.invoke(this.$this_runAfterDelay);
        } catch (Exception e) {
        }
    }
}
