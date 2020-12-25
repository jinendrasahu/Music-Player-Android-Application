package com.ismaeldivita.chipnavigation.util;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"com/ismaeldivita/chipnavigation/util/ViewGroupKt$getChildren$1", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "iterator", "", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ViewGroup.kt */
public final class ViewGroupKt$getChildren$1 implements Sequence<View> {
    final /* synthetic */ ViewGroup $this_getChildren;

    ViewGroupKt$getChildren$1(ViewGroup $receiver) {
        this.$this_getChildren = $receiver;
    }

    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_getChildren);
    }
}
