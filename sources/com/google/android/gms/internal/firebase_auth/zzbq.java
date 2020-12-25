package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
final class zzbq extends zzbj<Map.Entry<K, V>> {
    private final /* synthetic */ zzbr zza;

    zzbq(zzbr zzbr) {
        this.zza = zzbr;
    }

    public final int size() {
        return this.zza.zzd;
    }

    public final /* synthetic */ Object get(int i) {
        zzav.zza(i, this.zza.zzd);
        Object[] zzb = this.zza.zzb;
        int i2 = i * 2;
        zzbr zzbr = this.zza;
        Object obj = zzb[i2];
        Object[] zzb2 = zzbr.zzb;
        zzbr zzbr2 = this.zza;
        return new AbstractMap.SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
