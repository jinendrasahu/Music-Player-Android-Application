package com.ismaeldivita.chipnavigation.util;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"getValueFromAttr", "", "Landroid/content/Context;", "attr", "chip-navigation-bar_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Context.kt */
public final class ContextKt {
    public static final int getValueFromAttr(Context $this$getValueFromAttr, int attr) {
        Intrinsics.checkParameterIsNotNull($this$getValueFromAttr, "$this$getValueFromAttr");
        TypedValue typedValue = new TypedValue();
        $this$getValueFromAttr.getTheme().resolveAttribute(attr, typedValue, true);
        return typedValue.data;
    }
}
