package com.ismaeldivita.chipnavigation;

import com.ismaeldivita.chipnavigation.view.MenuItemView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "kotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1"}, k = 3, mv = {1, 1, 15})
/* compiled from: _Sequences.kt */
public final class ChipNavigationBar$getItemById$$inlined$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final ChipNavigationBar$getItemById$$inlined$filterIsInstance$1 INSTANCE = new ChipNavigationBar$getItemById$$inlined$filterIsInstance$1();

    public ChipNavigationBar$getItemById$$inlined$filterIsInstance$1() {
        super(1);
    }

    public final boolean invoke(Object it) {
        return it instanceof MenuItemView;
    }
}
