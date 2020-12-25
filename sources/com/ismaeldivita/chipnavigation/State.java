package com.ismaeldivita.chipnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 +2\u00020\u0001:\u0003*+,B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u000fH\u0016R<\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R<\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\u0019\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"¨\u0006-"}, d2 = {"Lcom/ismaeldivita/chipnavigation/State;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Parcelable;Landroid/os/Bundle;)V", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "value", "", "", "badges", "getBadges", "()Ljava/util/Map;", "setBadges", "(Ljava/util/Map;)V", "", "enabled", "getEnabled", "setEnabled", "expanded", "getExpanded", "()Z", "setExpanded", "(Z)V", "menuId", "getMenuId", "()I", "setMenuId", "(I)V", "selectedItem", "getSelectedItem", "setSelectedItem", "writeToParcel", "", "out", "flags", "BadgeState", "Companion", "EnabledState", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: State.kt */
public final class State extends View.BaseSavedState {
    private static final String BADGES = "badges";
    public static final Parcelable.ClassLoaderCreator<State> CREATOR = new State$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ENABLED = "enabled";
    private static final String EXPANDED = "expanded";
    private static final String MENU_ID = "menuId";
    private static final String SELECTED_ITEM = "selectedItem";
    private Bundle bundle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ismaeldivita/chipnavigation/State$BadgeState;", "Landroid/os/Parcelable;", "itemId", "", "count", "(II)V", "getCount", "()I", "getItemId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: State.kt */
    private static final class BadgeState implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        private final int count;
        private final int itemId;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
        public static class Creator implements Parcelable.Creator {
            public final Object createFromParcel(Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new BadgeState(parcel.readInt(), parcel.readInt());
            }

            public final Object[] newArray(int i) {
                return new BadgeState[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeInt(this.itemId);
            parcel.writeInt(this.count);
        }

        public BadgeState(int itemId2, int count2) {
            this.itemId = itemId2;
            this.count = count2;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getItemId() {
            return this.itemId;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ismaeldivita/chipnavigation/State$EnabledState;", "Landroid/os/Parcelable;", "itemId", "", "isEnabled", "", "(IZ)V", "()Z", "getItemId", "()I", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: State.kt */
    private static final class EnabledState implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        private final boolean isEnabled;
        private final int itemId;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
        public static class Creator implements Parcelable.Creator {
            public final Object createFromParcel(Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new EnabledState(parcel.readInt(), parcel.readInt() != 0);
            }

            public final Object[] newArray(int i) {
                return new EnabledState[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeInt(this.itemId);
            parcel.writeInt(this.isEnabled ? 1 : 0);
        }

        public EnabledState(int itemId2, boolean isEnabled2) {
            this.itemId = itemId2;
            this.isEnabled = isEnabled2;
        }

        public final int getItemId() {
            return this.itemId;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }
    }

    public final int getMenuId() {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            return bundle2.getInt(MENU_ID);
        }
        return -1;
    }

    public final void setMenuId(int value) {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putInt(MENU_ID, value);
        }
    }

    public final int getSelectedItem() {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            return bundle2.getInt(SELECTED_ITEM);
        }
        return -1;
    }

    public final void setSelectedItem(int value) {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putInt(SELECTED_ITEM, value);
        }
    }

    public final Map<Integer, Integer> getBadges() {
        ArrayList parcelableArrayList;
        Bundle bundle2 = this.bundle;
        if (bundle2 == null || (parcelableArrayList = bundle2.getParcelableArrayList(BADGES)) == null) {
            return MapsKt.emptyMap();
        }
        Iterable<BadgeState> $this$associate$iv = parcelableArrayList;
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16));
        for (BadgeState it : $this$associate$iv) {
            Pair pair = TuplesKt.to(Integer.valueOf(it.getItemId()), Integer.valueOf(it.getCount()));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    public final void setBadges(Map<Integer, Integer> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Map $this$mapTo$iv$iv = value;
        Collection destination$iv$iv = new ArrayList($this$mapTo$iv$iv.size());
        for (Map.Entry $dstr$item$count : $this$mapTo$iv$iv.entrySet()) {
            destination$iv$iv.add(new BadgeState(((Number) $dstr$item$count.getKey()).intValue(), ((Number) $dstr$item$count.getValue()).intValue()));
        }
        List badgeStates = (List) destination$iv$iv;
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putParcelableArrayList(BADGES, new ArrayList(badgeStates));
        }
    }

    public final Map<Integer, Boolean> getEnabled() {
        ArrayList parcelableArrayList;
        Bundle bundle2 = this.bundle;
        if (bundle2 == null || (parcelableArrayList = bundle2.getParcelableArrayList(ENABLED)) == null) {
            return MapsKt.emptyMap();
        }
        Iterable<EnabledState> $this$associate$iv = parcelableArrayList;
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16));
        for (EnabledState it : $this$associate$iv) {
            Pair pair = TuplesKt.to(Integer.valueOf(it.getItemId()), Boolean.valueOf(it.isEnabled()));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    public final void setEnabled(Map<Integer, Boolean> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Map $this$mapTo$iv$iv = value;
        Collection destination$iv$iv = new ArrayList($this$mapTo$iv$iv.size());
        for (Map.Entry $dstr$item$isEnabled : $this$mapTo$iv$iv.entrySet()) {
            destination$iv$iv.add(new EnabledState(((Number) $dstr$item$isEnabled.getKey()).intValue(), ((Boolean) $dstr$item$isEnabled.getValue()).booleanValue()));
        }
        List enabledState = (List) destination$iv$iv;
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putParcelableArrayList(ENABLED, new ArrayList(enabledState));
        }
    }

    public final boolean getExpanded() {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            return bundle2.getBoolean(EXPANDED);
        }
        return false;
    }

    public final void setExpanded(boolean value) {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putBoolean(EXPANDED, value);
        }
    }

    public State(Parcelable superState) {
        super(superState);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public State(Parcelable superState, Bundle bundle2) {
        super(superState);
        Intrinsics.checkParameterIsNotNull(bundle2, "bundle");
        this.bundle = bundle2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public State(Parcel source, ClassLoader loader) {
        super(source);
        Intrinsics.checkParameterIsNotNull(source, "source");
        this.bundle = source.readBundle(loader);
    }

    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkParameterIsNotNull(out, "out");
        super.writeToParcel(out, flags);
        out.writeBundle(this.bundle);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ismaeldivita/chipnavigation/State$Companion;", "", "()V", "BADGES", "", "CREATOR", "Landroid/os/Parcelable$ClassLoaderCreator;", "Lcom/ismaeldivita/chipnavigation/State;", "ENABLED", "EXPANDED", "MENU_ID", "SELECTED_ITEM", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: State.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
