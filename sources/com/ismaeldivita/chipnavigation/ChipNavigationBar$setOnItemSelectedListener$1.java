package com.ismaeldivita.chipnavigation;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/ismaeldivita/chipnavigation/ChipNavigationBar$setOnItemSelectedListener$1", "Lcom/ismaeldivita/chipnavigation/ChipNavigationBar$OnItemSelectedListener;", "onItemSelected", "", "id", "", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ChipNavigationBar.kt */
public final class ChipNavigationBar$setOnItemSelectedListener$1 implements ChipNavigationBar.OnItemSelectedListener {
    final /* synthetic */ Function1 $block;

    ChipNavigationBar$setOnItemSelectedListener$1(Function1 $captured_local_variable$0) {
        this.$block = $captured_local_variable$0;
    }

    public void onItemSelected(int id) {
        this.$block.invoke(Integer.valueOf(id));
    }
}
