package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
final class zzjv<T> implements zzkh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzlf.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjr zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjw zzo;
    private final zzjb zzp;
    private final zzkz<?, ?> zzq;
    private final zzhv<?> zzr;
    private final zzjk zzs;

    private zzjv(int[] iArr, Object[] objArr, int i, int i2, zzjr zzjr, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjw zzjw, zzjb zzjb, zzkz<?, ?> zzkz, zzhv<?> zzhv, zzjk zzjk) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjr instanceof zzig;
        this.zzj = z;
        this.zzh = zzhv != null && zzhv.zza(zzjr);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjw;
        this.zzp = zzjb;
        this.zzq = zzkz;
        this.zzr = zzhv;
        this.zzg = zzjr;
        this.zzs = zzjk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_auth.zzjv<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.firebase_auth.zzjp r34, com.google.android.gms.internal.firebase_auth.zzjw r35, com.google.android.gms.internal.firebase_auth.zzjb r36, com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r37, com.google.android.gms.internal.firebase_auth.zzhv<?> r38, com.google.android.gms.internal.firebase_auth.zzjk r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzkf
            if (r1 == 0) goto L_0x0426
            com.google.android.gms.internal.firebase_auth.zzkf r0 = (com.google.android.gms.internal.firebase_auth.zzkf) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.firebase_auth.zzig.zze.zzi
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = r4
            goto L_0x0015
        L_0x0014:
            r11 = r3
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0034
            r5 = r4
        L_0x0029:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0035
            r5 = r7
            goto L_0x0029
        L_0x0034:
            r7 = r4
        L_0x0035:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0054
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0041:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0051
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x0041
        L_0x0051:
            int r5 = r5 << r9
            r7 = r7 | r5
            goto L_0x0055
        L_0x0054:
            r10 = r5
        L_0x0055:
            if (r7 != 0) goto L_0x006c
            int[] r5 = zza
            r7 = r3
            r9 = r7
            r12 = r9
            r13 = r12
            r14 = r13
            r16 = r14
            r15 = r5
            r5 = r16
            goto L_0x019d
        L_0x006c:
            int r5 = r10 + 1
            char r7 = r1.charAt(r10)
            if (r7 < r6) goto L_0x008b
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0078:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0088
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x0078
        L_0x0088:
            int r5 = r5 << r9
            r5 = r5 | r7
            goto L_0x008d
        L_0x008b:
            r10 = r5
            r5 = r7
        L_0x008d:
            int r7 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r6) goto L_0x00ad
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x009a:
            int r12 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00aa
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r10
            r9 = r9 | r7
            int r10 = r10 + 13
            r7 = r12
            goto L_0x009a
        L_0x00aa:
            int r7 = r7 << r10
            r9 = r9 | r7
            goto L_0x00ae
        L_0x00ad:
            r12 = r7
        L_0x00ae:
            int r7 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r6) goto L_0x00cf
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bb:
            int r13 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00cb
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r12
            r10 = r10 | r7
            int r12 = r12 + 13
            r7 = r13
            goto L_0x00bb
        L_0x00cb:
            int r7 = r7 << r12
            r7 = r7 | r10
            r10 = r7
            goto L_0x00d0
        L_0x00cf:
            r13 = r7
        L_0x00d0:
            int r7 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r6) goto L_0x00f1
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00dd:
            int r14 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00ed
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r13
            r12 = r12 | r7
            int r13 = r13 + 13
            r7 = r14
            goto L_0x00dd
        L_0x00ed:
            int r7 = r7 << r13
            r7 = r7 | r12
            r12 = r7
            goto L_0x00f2
        L_0x00f1:
            r14 = r7
        L_0x00f2:
            int r7 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r6) goto L_0x0113
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x010f
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r14
            r13 = r13 | r7
            int r14 = r14 + 13
            r7 = r15
            goto L_0x00ff
        L_0x010f:
            int r7 = r7 << r14
            r7 = r7 | r13
            r13 = r7
            goto L_0x0114
        L_0x0113:
            r15 = r7
        L_0x0114:
            int r7 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r6) goto L_0x0137
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0121:
            int r16 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0132
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r15
            r14 = r14 | r7
            int r15 = r15 + 13
            r7 = r16
            goto L_0x0121
        L_0x0132:
            int r7 = r7 << r15
            r7 = r7 | r14
            r14 = r7
            r7 = r16
        L_0x0137:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x015b
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0144:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0156
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r7 = r7 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0144
        L_0x0156:
            int r15 = r15 << r16
            r7 = r7 | r15
            r15 = r17
        L_0x015b:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0187
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r32 = r16
            r16 = r15
            r15 = r32
        L_0x016e:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0181
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x016e
        L_0x0181:
            int r15 = r15 << r17
            r15 = r16 | r15
            r16 = r18
        L_0x0187:
            int r17 = r15 + r14
            int r7 = r17 + r7
            int[] r7 = new int[r7]
            int r17 = r5 << 1
            int r9 = r17 + r9
            r32 = r16
            r16 = r5
            r5 = r14
            r14 = r15
            r15 = r7
            r7 = r9
            r9 = r10
            r10 = r32
        L_0x019d:
            sun.misc.Unsafe r3 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.gms.internal.firebase_auth.zzjr r18 = r0.zzc()
            java.lang.Class r8 = r18.getClass()
            int r6 = r13 * 3
            int[] r6 = new int[r6]
            int r13 = r13 << r4
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r19 = r14 + r5
            r21 = r14
            r22 = r19
            r5 = 0
            r20 = 0
        L_0x01bd:
            if (r10 >= r2) goto L_0x0403
            int r23 = r10 + 1
            char r10 = r1.charAt(r10)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r10 < r4) goto L_0x01f1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r32 = r23
            r23 = r10
            r10 = r32
        L_0x01d4:
            int r26 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r4) goto L_0x01ea
            r4 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r23 = r23 | r4
            int r25 = r25 + 13
            r10 = r26
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01d4
        L_0x01ea:
            int r4 = r10 << r25
            r10 = r23 | r4
            r4 = r26
            goto L_0x01f3
        L_0x01f1:
            r4 = r23
        L_0x01f3:
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x0228
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r32 = r23
            r23 = r4
            r4 = r32
        L_0x020b:
            int r27 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x0221
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r23 = r23 | r2
            int r26 = r26 + 13
            r4 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x020b
        L_0x0221:
            int r2 = r4 << r26
            r4 = r23 | r2
            r2 = r27
            goto L_0x022a
        L_0x0228:
            r2 = r23
        L_0x022a:
            r23 = r14
            r14 = r4 & 255(0xff, float:3.57E-43)
            r26 = r12
            r12 = r4 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x023a
            int r12 = r5 + 1
            r15[r5] = r20
            r5 = r12
        L_0x023a:
            r12 = 51
            r29 = r5
            if (r14 < r12) goto L_0x02d5
            int r12 = r2 + 1
            char r2 = r1.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r5) goto L_0x0269
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
        L_0x024f:
            int r31 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0264
            r5 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r30
            r2 = r2 | r5
            int r30 = r30 + 13
            r12 = r31
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x024f
        L_0x0264:
            int r5 = r12 << r30
            r2 = r2 | r5
            r12 = r31
        L_0x0269:
            int r5 = r14 + -51
            r30 = r12
            r12 = 9
            if (r5 == r12) goto L_0x028d
            r12 = 17
            if (r5 != r12) goto L_0x0277
            goto L_0x028d
        L_0x0277:
            r12 = 12
            if (r5 != r12) goto L_0x028b
            if (r11 != 0) goto L_0x028b
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r12 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r12
            r12 = 1
            goto L_0x029a
        L_0x028b:
            r12 = 1
            goto L_0x029a
        L_0x028d:
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r24 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r24
        L_0x029a:
            int r2 = r2 << r12
            r5 = r17[r2]
            boolean r12 = r5 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x02a4
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x02ac
        L_0x02a4:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r2] = r5
        L_0x02ac:
            r12 = r6
            long r5 = r3.objectFieldOffset(r5)
            int r5 = (int) r5
            int r2 = r2 + 1
            r6 = r17[r2]
            r27 = r5
            boolean r5 = r6 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x02bf
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x02c7
        L_0x02bf:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r8, (java.lang.String) r6)
            r17[r2] = r6
        L_0x02c7:
            long r5 = r3.objectFieldOffset(r6)
            int r2 = (int) r5
            r6 = r2
            r5 = r27
            r28 = r30
            r2 = 0
            goto L_0x03c9
        L_0x02d5:
            r12 = r6
            int r5 = r7 + 1
            r6 = r17[r7]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r8, (java.lang.String) r6)
            r7 = 9
            if (r14 == r7) goto L_0x0349
            r7 = 17
            if (r14 != r7) goto L_0x02eb
            r24 = 1
            goto L_0x034b
        L_0x02eb:
            r7 = 27
            if (r14 == r7) goto L_0x033a
            r7 = 49
            if (r14 != r7) goto L_0x02f4
            goto L_0x033a
        L_0x02f4:
            r7 = 12
            if (r14 == r7) goto L_0x0329
            r7 = 30
            if (r14 == r7) goto L_0x0329
            r7 = 44
            if (r14 != r7) goto L_0x0301
            goto L_0x0329
        L_0x0301:
            r7 = 50
            if (r14 != r7) goto L_0x0357
            int r7 = r21 + 1
            r15[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r21] = r5
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0326
            int r21 = r21 + 1
            int r5 = r27 + 1
            r27 = r17[r27]
            r13[r21] = r27
            r27 = r5
            r21 = r7
            goto L_0x0359
        L_0x0326:
            r21 = r7
            goto L_0x0359
        L_0x0329:
            if (r11 != 0) goto L_0x0357
            int r7 = r20 / 3
            r24 = 1
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x0359
        L_0x033a:
            int r7 = r20 / 3
            r24 = 1
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x0359
        L_0x0349:
            r24 = 1
        L_0x034b:
            int r7 = r20 / 3
            int r7 = r7 << 1
            int r7 = r7 + 1
            java.lang.Class r27 = r6.getType()
            r13[r7] = r27
        L_0x0357:
            r27 = r5
        L_0x0359:
            long r5 = r3.objectFieldOffset(r6)
            int r5 = (int) r5
            r6 = r4 & 4096(0x1000, float:5.74E-42)
            r7 = 4096(0x1000, float:5.74E-42)
            if (r6 != r7) goto L_0x03b0
            r6 = 17
            if (r14 > r6) goto L_0x03b0
            int r6 = r2 + 1
            char r2 = r1.charAt(r2)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r7) goto L_0x038d
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x0377:
            int r28 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r7) goto L_0x0389
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r18
            r2 = r2 | r6
            int r18 = r18 + 13
            r6 = r28
            goto L_0x0377
        L_0x0389:
            int r6 = r6 << r18
            r2 = r2 | r6
            goto L_0x038f
        L_0x038d:
            r28 = r6
        L_0x038f:
            r6 = 1
            int r18 = r16 << 1
            int r24 = r2 / 32
            int r18 = r18 + r24
            r6 = r17[r18]
            boolean r7 = r6 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x03a0
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x03a8
        L_0x03a0:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r8, (java.lang.String) r6)
            r17[r18] = r6
        L_0x03a8:
            long r6 = r3.objectFieldOffset(r6)
            int r6 = (int) r6
            int r2 = r2 % 32
            goto L_0x03b6
        L_0x03b0:
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r2
            r2 = 0
        L_0x03b6:
            r7 = 18
            if (r14 < r7) goto L_0x03c7
            r7 = 49
            if (r14 > r7) goto L_0x03c7
            int r7 = r22 + 1
            r15[r22] = r5
            r22 = r7
            r7 = r27
            goto L_0x03c9
        L_0x03c7:
            r7 = r27
        L_0x03c9:
            int r18 = r20 + 1
            r12[r20] = r10
            int r10 = r18 + 1
            r20 = r1
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x03d8
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03d9
        L_0x03d8:
            r1 = 0
        L_0x03d9:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03e0
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03e1
        L_0x03e0:
            r4 = 0
        L_0x03e1:
            r1 = r1 | r4
            int r4 = r14 << 20
            r1 = r1 | r4
            r1 = r1 | r5
            r12[r18] = r1
            int r1 = r10 + 1
            int r2 = r2 << 20
            r2 = r2 | r6
            r12[r10] = r2
            r6 = r12
            r14 = r23
            r2 = r25
            r12 = r26
            r10 = r28
            r5 = r29
            r4 = 1
            r32 = r20
            r20 = r1
            r1 = r32
            goto L_0x01bd
        L_0x0403:
            r26 = r12
            r23 = r14
            r12 = r6
            com.google.android.gms.internal.firebase_auth.zzjv r1 = new com.google.android.gms.internal.firebase_auth.zzjv
            com.google.android.gms.internal.firebase_auth.zzjr r10 = r0.zzc()
            r0 = 0
            r5 = r1
            r7 = r13
            r8 = r9
            r9 = r26
            r12 = r0
            r13 = r15
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0426:
            com.google.android.gms.internal.firebase_auth.zzks r0 = (com.google.android.gms.internal.firebase_auth.zzks) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzig.zze.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjv.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzjp, com.google.android.gms.internal.firebase_auth.zzjw, com.google.android.gms.internal.firebase_auth.zzjb, com.google.android.gms.internal.firebase_auth.zzkz, com.google.android.gms.internal.firebase_auth.zzhv, com.google.android.gms.internal.firebase_auth.zzjk):com.google.android.gms.internal.firebase_auth.zzjv");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzd2 = zzd(i);
                long j = (long) (zzd2 & 1048575);
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzlf.zze(t, j)) != Double.doubleToLongBits(zzlf.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzlf.zzd(t, j)) != Float.floatToIntBits(zzlf.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzlf.zzc(t, j) != zzlf.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j));
                        break;
                    case 50:
                        z = zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zze2 = (long) (zze(i) & 1048575);
                        if (zzlf.zza((Object) t, zze2) != zzlf.zza((Object) t2, zze2) || !zzkj.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    public final int zza(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzd2 = zzd(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzd2);
            int i4 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzii.zza(Double.doubleToLongBits(zzlf.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzlf.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzii.zza(zzlf.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzlf.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zzlf.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zzlf.zzf(t, j);
                    if (zzf3 != null) {
                        i4 = zzf3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(Double.doubleToLongBits(zzb(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzc(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zzf(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzlf.zzf(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzq.zzb(t).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzr.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzkj.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzkj.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzkj.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzlf.zzf(t, zzd2);
            Object zzf3 = zzlf.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzlf.zza((Object) t, zzd2, zzii.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzlf.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzlf.zzf(t, j);
            Object zzf3 = zzlf.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzlf.zza((Object) t, j, zzii.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzlf.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    public final int zzd(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        int i4;
        T t2 = t;
        int i5 = 267386880;
        int i6 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.zzc.length) {
                int zzd2 = zzd(i7);
                int i9 = (zzd2 & i5) >>> 20;
                int i10 = this.zzc[i7];
                long j2 = (long) (zzd2 & 1048575);
                if (i9 < zzia.DOUBLE_LIST_PACKED.zza() || i9 > zzia.SINT64_LIST_PACKED.zza()) {
                    i4 = 0;
                } else {
                    i4 = this.zzc[i7 + 2] & 1048575;
                }
                switch (i9) {
                    case 0:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzd(i10, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zze(i10, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzf(i10, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzg(i10, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzi(i10, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            Object zzf2 = zzlf.zzf(t2, j2);
                            if (!(zzf2 instanceof zzgv)) {
                                i8 += zzhq.zzb(i10, (String) zzf2);
                                break;
                            } else {
                                i8 += zzhq.zzc(i10, (zzgv) zzf2);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzkj.zza(i10, zzlf.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzc(i10, (zzgv) zzlf.zzf(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzg(i10, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzk(i10, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzj(i10, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzh(i10, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzh(i10, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzf(i10, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzc(i10, (zzjr) zzlf.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case 18:
                        i8 += zzkj.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 19:
                        i8 += zzkj.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case 20:
                        i8 += zzkj.zza(i10, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 21:
                        i8 += zzkj.zzb(i10, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 22:
                        i8 += zzkj.zze(i10, zza((Object) t2, j2), false);
                        break;
                    case 23:
                        i8 += zzkj.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 24:
                        i8 += zzkj.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case 25:
                        i8 += zzkj.zzj(i10, zza((Object) t2, j2), false);
                        break;
                    case 26:
                        i8 += zzkj.zza(i10, zza((Object) t2, j2));
                        break;
                    case 27:
                        i8 += zzkj.zza(i10, zza((Object) t2, j2), zza(i7));
                        break;
                    case 28:
                        i8 += zzkj.zzb(i10, zza((Object) t2, j2));
                        break;
                    case 29:
                        i8 += zzkj.zzf(i10, zza((Object) t2, j2), false);
                        break;
                    case 30:
                        i8 += zzkj.zzd(i10, zza((Object) t2, j2), false);
                        break;
                    case 31:
                        i8 += zzkj.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case 32:
                        i8 += zzkj.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 33:
                        i8 += zzkj.zzg(i10, zza((Object) t2, j2), false);
                        break;
                    case 34:
                        i8 += zzkj.zzc(i10, zza((Object) t2, j2), false);
                        break;
                    case 35:
                        int zzi2 = zzkj.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzi2) + zzi2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzh2 = zzkj.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzh2) + zzh2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zza2 = zzkj.zza((List<Long>) (List) unsafe.getObject(t2, j2));
                        if (zza2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zza2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zza2) + zza2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzb2 = zzkj.zzb((List) unsafe.getObject(t2, j2));
                        if (zzb2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzb2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzb2) + zzb2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zze2 = zzkj.zze((List) unsafe.getObject(t2, j2));
                        if (zze2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zze2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zze2) + zze2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzi3 = zzkj.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi3);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzi3) + zzi3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzh3 = zzkj.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh3);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzh3) + zzh3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzj2 = zzkj.zzj((List) unsafe.getObject(t2, j2));
                        if (zzj2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzj2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzj2) + zzj2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzf3 = zzkj.zzf((List) unsafe.getObject(t2, j2));
                        if (zzf3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzf3);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzf3) + zzf3;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzd3 = zzkj.zzd((List) unsafe.getObject(t2, j2));
                        if (zzd3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzd3);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzd3) + zzd3;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzh4 = zzkj.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh4);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzh4) + zzh4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzi4 = zzkj.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi4);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzi4) + zzi4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzg2 = zzkj.zzg((List) unsafe.getObject(t2, j2));
                        if (zzg2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzg2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzg2) + zzg2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzc2 = zzkj.zzc((List) unsafe.getObject(t2, j2));
                        if (zzc2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzc2);
                            }
                            i8 += zzhq.zze(i10) + zzhq.zzg(zzc2) + zzc2;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i8 += zzkj.zzb(i10, (List<zzjr>) zza((Object) t2, j2), zza(i7));
                        break;
                    case 50:
                        i8 += this.zzs.zza(i10, zzlf.zzf(t2, j2), zzb(i7));
                        break;
                    case 51:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzd(i10, zze(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zze(i10, zze(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzf(i10, zzd(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzg(i10, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzi(i10, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzb(i10, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            Object zzf4 = zzlf.zzf(t2, j2);
                            if (!(zzf4 instanceof zzgv)) {
                                i8 += zzhq.zzb(i10, (String) zzf4);
                                break;
                            } else {
                                i8 += zzhq.zzc(i10, (zzgv) zzf4);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzkj.zza(i10, zzlf.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzc(i10, (zzgv) zzlf.zzf(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzg(i10, zzd(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzk(i10, zzd(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzj(i10, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzh(i10, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzh(i10, zzd(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzf(i10, zze(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzhq.zzc(i10, (zzjr) zzlf.zzf(t2, j2), zza(i7));
                            break;
                        }
                }
                i7 += 3;
                i5 = 267386880;
            }
            return i8 + zza(this.zzq, t2);
        }
        Unsafe unsafe2 = zzb;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < this.zzc.length) {
            int zzd4 = zzd(i12);
            int[] iArr = this.zzc;
            int i15 = iArr[i12];
            int i16 = (zzd4 & 267386880) >>> 20;
            if (i16 <= 17) {
                i2 = iArr[i12 + 2];
                int i17 = i2 & 1048575;
                i = 1 << (i2 >>> 20);
                if (i17 != i11) {
                    i14 = unsafe2.getInt(t2, (long) i17);
                } else {
                    i17 = i11;
                }
                i11 = i17;
            } else if (!this.zzk || i16 < zzia.DOUBLE_LIST_PACKED.zza() || i16 > zzia.SINT64_LIST_PACKED.zza()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzc[i12 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzd4 & 1048575);
            switch (i16) {
                case 0:
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i14 & i) == 0) {
                        break;
                    } else {
                        i13 += zzhq.zzb(i15, 0.0d);
                        break;
                    }
                case 1:
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        z = false;
                        i13 += zzhq.zzb(i15, 0.0f);
                        break;
                    }
                case 2:
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzhq.zzd(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 3:
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzhq.zze(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 4:
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzhq.zzf(i15, unsafe2.getInt(t2, j3));
                        z = false;
                        break;
                    }
                case 5:
                    i3 = 0;
                    if ((i14 & i) == 0) {
                        j = 0;
                        z = false;
                        break;
                    } else {
                        j = 0;
                        i13 += zzhq.zzg(i15, 0);
                        z = false;
                        break;
                    }
                case 6:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i3 = 0;
                        i13 += zzhq.zzi(i15, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzb(i15, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzgv)) {
                            i13 += zzhq.zzb(i15, (String) object);
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzhq.zzc(i15, (zzgv) object);
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzkj.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzc(i15, (zzgv) unsafe2.getObject(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzg(i15, unsafe2.getInt(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzk(i15, unsafe2.getInt(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzj(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzh(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzh(i15, unsafe2.getInt(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzf(i15, unsafe2.getLong(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzc(i15, (zzjr) unsafe2.getObject(t2, j3), zza(i12));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 18:
                    i13 += zzkj.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i13 += zzkj.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i13 += zzkj.zza(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i13 += zzkj.zzb(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i13 += zzkj.zze(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i13 += zzkj.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i13 += zzkj.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i13 += zzkj.zzj(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    i13 += zzkj.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3));
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    i13 += zzkj.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    i13 += zzkj.zzb(i15, (List) unsafe2.getObject(t2, j3));
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    i13 += zzkj.zzf(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i13 += zzkj.zzd(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i13 += zzkj.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i13 += zzkj.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i13 += zzkj.zzg(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i13 += zzkj.zzc(i15, (List) unsafe2.getObject(t2, j3), false);
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zzkj.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi5 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi5);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzi5) + zzi5;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zzkj.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh5 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh5);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzh5) + zzh5;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zzkj.zza((List<Long>) (List) unsafe2.getObject(t2, j3));
                    if (zza3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zza3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zza3) + zza3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zzkj.zzb((List) unsafe2.getObject(t2, j3));
                    if (zzb3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzb3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzb3) + zzb3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zzkj.zze((List) unsafe2.getObject(t2, j3));
                    if (zze3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zze3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zze3) + zze3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zzkj.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi6 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi6);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzi6) + zzi6;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zzkj.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh6 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh6);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzh6) + zzh6;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzj3 = zzkj.zzj((List) unsafe2.getObject(t2, j3));
                    if (zzj3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzj3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzj3) + zzj3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zzkj.zzf((List) unsafe2.getObject(t2, j3));
                    if (zzf5 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzf5);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzf5) + zzf5;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzd5 = zzkj.zzd((List) unsafe2.getObject(t2, j3));
                    if (zzd5 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzd5);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzd5) + zzd5;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zzkj.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh7 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh7);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzh7) + zzh7;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzi7 = zzkj.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi7 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi7);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzi7) + zzi7;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zzkj.zzg((List) unsafe2.getObject(t2, j3));
                    if (zzg3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzg3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzg3) + zzg3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc3 = zzkj.zzc((List) unsafe2.getObject(t2, j3));
                    if (zzc3 <= 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzc3);
                        }
                        i13 += zzhq.zze(i15) + zzhq.zzg(zzc3) + zzc3;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 49:
                    i13 += zzkj.zzb(i15, (List<zzjr>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    i13 += this.zzs.zza(i15, unsafe2.getObject(t2, j3), zzb(i12));
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzb(i15, 0.0d);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzb(i15, 0.0f);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzd(i15, zze(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zze(i15, zze(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzf(i15, zzd(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzg(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzi(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzb(i15, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzgv)) {
                            i13 += zzhq.zzb(i15, (String) object2);
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzhq.zzc(i15, (zzgv) object2);
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzkj.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzc(i15, (zzgv) unsafe2.getObject(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzg(i15, zzd(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzk(i15, zzd(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzj(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzh(i15, 0);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzh(i15, zzd(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzf(i15, zze(t2, j3));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i15, i12)) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhq.zzc(i15, (zzjr) unsafe2.getObject(t2, j3), zza(i12));
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                default:
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i12 += 3;
            i6 = i3;
            boolean z2 = z;
            long j4 = j;
        }
        int i18 = i6;
        int zza4 = i13 + zza(this.zzq, t2);
        if (!this.zzh) {
            return zza4;
        }
        zzhz<?> zza5 = this.zzr.zza((Object) t2);
        int i19 = i18;
        while (i18 < zza5.zza.zzc()) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i18);
            i19 += zzhz.zza((zzib<?>) (zzib) zzb4.getKey(), zzb4.getValue());
            i18++;
        }
        for (Map.Entry next : zza5.zza.zzd()) {
            i19 += zzhz.zza((zzib<?>) (zzib) next.getKey(), next.getValue());
        }
        return zza4 + i19;
    }

    private static <UT, UB> int zza(zzkz<UT, UB> zzkz, T t) {
        return zzkz.zzf(zzkz.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzlf.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f1  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzlw r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzig.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c3
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.firebase_auth.zzhv<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhz r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0036
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0038
        L_0x0036:
            r0 = r3
            r1 = r0
        L_0x0038:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003d:
            if (r7 < 0) goto L_0x05ab
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0049:
            if (r1 == 0) goto L_0x0067
            com.google.android.gms.internal.firebase_auth.zzhv<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0067
            com.google.android.gms.internal.firebase_auth.zzhv<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0049
        L_0x0065:
            r1 = r3
            goto L_0x0049
        L_0x0067:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0596;
                case 1: goto L_0x0584;
                case 2: goto L_0x0572;
                case 3: goto L_0x0560;
                case 4: goto L_0x054e;
                case 5: goto L_0x053c;
                case 6: goto L_0x052a;
                case 7: goto L_0x0517;
                case 8: goto L_0x0505;
                case 9: goto L_0x04ef;
                case 10: goto L_0x04db;
                case 11: goto L_0x04c8;
                case 12: goto L_0x04b5;
                case 13: goto L_0x04a2;
                case 14: goto L_0x048f;
                case 15: goto L_0x047c;
                case 16: goto L_0x0469;
                case 17: goto L_0x0453;
                case 18: goto L_0x043f;
                case 19: goto L_0x042b;
                case 20: goto L_0x0417;
                case 21: goto L_0x0403;
                case 22: goto L_0x03ef;
                case 23: goto L_0x03db;
                case 24: goto L_0x03c7;
                case 25: goto L_0x03b3;
                case 26: goto L_0x039f;
                case 27: goto L_0x0387;
                case 28: goto L_0x0373;
                case 29: goto L_0x035f;
                case 30: goto L_0x034b;
                case 31: goto L_0x0337;
                case 32: goto L_0x0323;
                case 33: goto L_0x030f;
                case 34: goto L_0x02fb;
                case 35: goto L_0x02e7;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02bf;
                case 38: goto L_0x02ab;
                case 39: goto L_0x0297;
                case 40: goto L_0x0283;
                case 41: goto L_0x026f;
                case 42: goto L_0x025b;
                case 43: goto L_0x0247;
                case 44: goto L_0x0233;
                case 45: goto L_0x021f;
                case 46: goto L_0x020b;
                case 47: goto L_0x01f7;
                case 48: goto L_0x01e3;
                case 49: goto L_0x01cb;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01ad;
                case 52: goto L_0x019b;
                case 53: goto L_0x0189;
                case 54: goto L_0x0177;
                case 55: goto L_0x0165;
                case 56: goto L_0x0153;
                case 57: goto L_0x0141;
                case 58: goto L_0x012f;
                case 59: goto L_0x011d;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00cf;
                case 64: goto L_0x00bd;
                case 65: goto L_0x00ab;
                case 66: goto L_0x0099;
                case 67: goto L_0x0087;
                case 68: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x05a7
        L_0x0071:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x0087:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0099:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x00ab:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x00bd:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00cf:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00e1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00f3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgv r8 = (com.google.android.gms.internal.firebase_auth.zzgv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgv) r8)
            goto L_0x05a7
        L_0x0107:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x011d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x05a7
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x0141:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0153:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0165:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0177:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0189:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x019b:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x01ad:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x05a7
        L_0x01bf:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzlw) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x05a7
        L_0x01cb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x01e3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x01f7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x020b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x021f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0233:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0247:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x025b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x026f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0283:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0297:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02ab:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02bf:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02fb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x030f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0323:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0337:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x034b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r9, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x05a7
        L_0x0387:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x039f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x05a7
        L_0x03b3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03c7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03db:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03ef:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0403:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0417:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x042b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r5)
            goto L_0x05a7
        L_0x043f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r5)
            goto L_0x05a7
        L_0x0453:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x0469:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x048f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x04a2:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04b5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04c8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04db:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgv r8 = (com.google.android.gms.internal.firebase_auth.zzgv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgv) r8)
            goto L_0x05a7
        L_0x04ef:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkh r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkh) r10)
            goto L_0x05a7
        L_0x0505:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x05a7
        L_0x0517:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x052a:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x053c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x054e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0560:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0572:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0584:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x0596:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x05a7:
            int r7 = r7 + -3
            goto L_0x003d
        L_0x05ab:
            if (r1 == 0) goto L_0x05c2
            com.google.android.gms.internal.firebase_auth.zzhv<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x05c0
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x05ab
        L_0x05c0:
            r1 = r3
            goto L_0x05ab
        L_0x05c2:
            return
        L_0x05c3:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0b7a
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x05e8
            com.google.android.gms.internal.firebase_auth.zzhv<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhz r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x05e8
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05ea
        L_0x05e8:
            r0 = r3
            r1 = r0
        L_0x05ea:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r1
            r1 = r5
        L_0x05ef:
            if (r1 >= r7) goto L_0x0b5d
            int r9 = r13.zzd((int) r1)
            int[] r10 = r13.zzc
            r10 = r10[r1]
        L_0x05fb:
            if (r8 == 0) goto L_0x0619
            com.google.android.gms.internal.firebase_auth.zzhv<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0619
            com.google.android.gms.internal.firebase_auth.zzhv<?> r11 = r13.zzr
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0617
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x05fb
        L_0x0617:
            r8 = r3
            goto L_0x05fb
        L_0x0619:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0b48;
                case 1: goto L_0x0b36;
                case 2: goto L_0x0b24;
                case 3: goto L_0x0b12;
                case 4: goto L_0x0b00;
                case 5: goto L_0x0aee;
                case 6: goto L_0x0adc;
                case 7: goto L_0x0ac9;
                case 8: goto L_0x0ab7;
                case 9: goto L_0x0aa1;
                case 10: goto L_0x0a8d;
                case 11: goto L_0x0a7a;
                case 12: goto L_0x0a67;
                case 13: goto L_0x0a54;
                case 14: goto L_0x0a41;
                case 15: goto L_0x0a2e;
                case 16: goto L_0x0a1b;
                case 17: goto L_0x0a05;
                case 18: goto L_0x09f1;
                case 19: goto L_0x09dd;
                case 20: goto L_0x09c9;
                case 21: goto L_0x09b5;
                case 22: goto L_0x09a1;
                case 23: goto L_0x098d;
                case 24: goto L_0x0979;
                case 25: goto L_0x0965;
                case 26: goto L_0x0951;
                case 27: goto L_0x0939;
                case 28: goto L_0x0925;
                case 29: goto L_0x0911;
                case 30: goto L_0x08fd;
                case 31: goto L_0x08e9;
                case 32: goto L_0x08d5;
                case 33: goto L_0x08c1;
                case 34: goto L_0x08ad;
                case 35: goto L_0x0899;
                case 36: goto L_0x0885;
                case 37: goto L_0x0871;
                case 38: goto L_0x085d;
                case 39: goto L_0x0849;
                case 40: goto L_0x0835;
                case 41: goto L_0x0821;
                case 42: goto L_0x080d;
                case 43: goto L_0x07f9;
                case 44: goto L_0x07e5;
                case 45: goto L_0x07d1;
                case 46: goto L_0x07bd;
                case 47: goto L_0x07a9;
                case 48: goto L_0x0795;
                case 49: goto L_0x077d;
                case 50: goto L_0x0771;
                case 51: goto L_0x075f;
                case 52: goto L_0x074d;
                case 53: goto L_0x073b;
                case 54: goto L_0x0729;
                case 55: goto L_0x0717;
                case 56: goto L_0x0705;
                case 57: goto L_0x06f3;
                case 58: goto L_0x06e1;
                case 59: goto L_0x06cf;
                case 60: goto L_0x06b9;
                case 61: goto L_0x06a5;
                case 62: goto L_0x0693;
                case 63: goto L_0x0681;
                case 64: goto L_0x066f;
                case 65: goto L_0x065d;
                case 66: goto L_0x064b;
                case 67: goto L_0x0639;
                case 68: goto L_0x0623;
                default: goto L_0x0621;
            }
        L_0x0621:
            goto L_0x0b59
        L_0x0623:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x0639:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b59
        L_0x064b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0b59
        L_0x065d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b59
        L_0x066f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0681:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0693:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b59
        L_0x06a5:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgv r9 = (com.google.android.gms.internal.firebase_auth.zzgv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgv) r9)
            goto L_0x0b59
        L_0x06b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x06cf:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x0b59
        L_0x06e1:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b59
        L_0x06f3:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0705:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0717:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0729:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b59
        L_0x073b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b59
        L_0x074d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b59
        L_0x075f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0b59
        L_0x0771:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzlw) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0b59
        L_0x077d:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x0795:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x07a9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x07bd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x07d1:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x07e5:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x07f9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x080d:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x0821:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x0835:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x0849:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x085d:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x0871:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r10, r9, r15, r4)
            goto L_0x0b59
        L_0x0885:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r4)
            goto L_0x0b59
        L_0x0899:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r4)
            goto L_0x0b59
        L_0x08ad:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x08c1:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x08d5:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x08e9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x08fd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x0911:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x0925:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r10, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x0b59
        L_0x0939:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x0951:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x0b59
        L_0x0965:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x0979:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x098d:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x09a1:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x09b5:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x09c9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r10, r9, r15, r5)
            goto L_0x0b59
        L_0x09dd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r5)
            goto L_0x0b59
        L_0x09f1:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15, (boolean) r5)
            goto L_0x0b59
        L_0x0a05:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x0a1b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0a2e:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0b59
        L_0x0a41:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0a54:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0a67:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0a7a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0a8d:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgv r9 = (com.google.android.gms.internal.firebase_auth.zzgv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgv) r9)
            goto L_0x0b59
        L_0x0aa1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkh r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r11)
            goto L_0x0b59
        L_0x0ab7:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            goto L_0x0b59
        L_0x0ac9:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b59
        L_0x0adc:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0aee:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0b00:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b59
        L_0x0b12:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0b24:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b59
        L_0x0b36:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b59
        L_0x0b48:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b59
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0b59:
            int r1 = r1 + 3
            goto L_0x05ef
        L_0x0b5d:
            if (r8 == 0) goto L_0x0b74
            com.google.android.gms.internal.firebase_auth.zzhv<?> r1 = r13.zzr
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b72
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0b5d
        L_0x0b72:
            r8 = r3
            goto L_0x0b5d
        L_0x0b74:
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            return
        L_0x0b7a:
            r13.zzb(r14, (com.google.android.gms.internal.firebase_auth.zzlw) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjv.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzlw):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.firebase_auth.zzlw r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0025
            com.google.android.gms.internal.firebase_auth.zzhv<?> r3 = r0.zzr
            com.google.android.gms.internal.firebase_auth.zzhz r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0025
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0027
        L_0x0025:
            r3 = 0
            r5 = 0
        L_0x0027:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0034:
            if (r5 >= r6) goto L_0x0560
            int r13 = r0.zzd((int) r5)
            int[] r14 = r0.zzc
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzj
            if (r9 != 0) goto L_0x006e
            r9 = 17
            if (r4 > r9) goto L_0x006e
            int r9 = r5 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r10) goto L_0x0064
            r14 = r11
            long r10 = (long) r8
            int r12 = r7.getInt(r1, r10)
            goto L_0x0066
        L_0x0064:
            r14 = r11
            r8 = r10
        L_0x0066:
            int r9 = r9 >>> 20
            r10 = 1
            int r9 = r10 << r9
            r10 = r8
            r11 = r14
            goto L_0x0071
        L_0x006e:
            r14 = r11
            r11 = r14
            r9 = 0
        L_0x0071:
            if (r11 == 0) goto L_0x0090
            com.google.android.gms.internal.firebase_auth.zzhv<?> r8 = r0.zzr
            int r8 = r8.zza((java.util.Map.Entry<?, ?>) r11)
            if (r8 > r15) goto L_0x0090
            com.google.android.gms.internal.firebase_auth.zzhv<?> r8 = r0.zzr
            r8.zza(r2, r11)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x008e
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r11 = r8
            goto L_0x0071
        L_0x008e:
            r11 = 0
            goto L_0x0071
        L_0x0090:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r8
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0550;
                case 1: goto L_0x0543;
                case 2: goto L_0x0537;
                case 3: goto L_0x052b;
                case 4: goto L_0x051f;
                case 5: goto L_0x0513;
                case 6: goto L_0x0507;
                case 7: goto L_0x04fa;
                case 8: goto L_0x04ee;
                case 9: goto L_0x04dd;
                case 10: goto L_0x04ce;
                case 11: goto L_0x04c1;
                case 12: goto L_0x04b4;
                case 13: goto L_0x04a7;
                case 14: goto L_0x049a;
                case 15: goto L_0x048d;
                case 16: goto L_0x0480;
                case 17: goto L_0x046e;
                case 18: goto L_0x045b;
                case 19: goto L_0x0448;
                case 20: goto L_0x0435;
                case 21: goto L_0x0422;
                case 22: goto L_0x040f;
                case 23: goto L_0x03fc;
                case 24: goto L_0x03e9;
                case 25: goto L_0x03d6;
                case 26: goto L_0x03c4;
                case 27: goto L_0x03ad;
                case 28: goto L_0x039b;
                case 29: goto L_0x0388;
                case 30: goto L_0x0375;
                case 31: goto L_0x0362;
                case 32: goto L_0x034f;
                case 33: goto L_0x033c;
                case 34: goto L_0x0329;
                case 35: goto L_0x0316;
                case 36: goto L_0x0303;
                case 37: goto L_0x02f0;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02ca;
                case 40: goto L_0x02b7;
                case 41: goto L_0x02a4;
                case 42: goto L_0x0291;
                case 43: goto L_0x027e;
                case 44: goto L_0x026b;
                case 45: goto L_0x0258;
                case 46: goto L_0x0245;
                case 47: goto L_0x0232;
                case 48: goto L_0x021f;
                case 49: goto L_0x0208;
                case 50: goto L_0x01fe;
                case 51: goto L_0x01eb;
                case 52: goto L_0x01d8;
                case 53: goto L_0x01c5;
                case 54: goto L_0x01b2;
                case 55: goto L_0x019f;
                case 56: goto L_0x018c;
                case 57: goto L_0x0179;
                case 58: goto L_0x0166;
                case 59: goto L_0x0153;
                case 60: goto L_0x013c;
                case 61: goto L_0x0127;
                case 62: goto L_0x0114;
                case 63: goto L_0x0101;
                case 64: goto L_0x00ee;
                case 65: goto L_0x00db;
                case 66: goto L_0x00c8;
                case 67: goto L_0x00b5;
                case 68: goto L_0x009d;
                default: goto L_0x009a;
            }
        L_0x009a:
            r4 = 0
            goto L_0x055c
        L_0x009d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x00b2
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzkh r9 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkh) r9)
            r4 = 0
            goto L_0x055c
        L_0x00b2:
            r4 = 0
            goto L_0x055c
        L_0x00b5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x00c5
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            r4 = 0
            goto L_0x055c
        L_0x00c5:
            r4 = 0
            goto L_0x055c
        L_0x00c8:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x00d8
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            r4 = 0
            goto L_0x055c
        L_0x00d8:
            r4 = 0
            goto L_0x055c
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x00eb
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            r4 = 0
            goto L_0x055c
        L_0x00eb:
            r4 = 0
            goto L_0x055c
        L_0x00ee:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x00fe
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            r4 = 0
            goto L_0x055c
        L_0x00fe:
            r4 = 0
            goto L_0x055c
        L_0x0101:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0111
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            r4 = 0
            goto L_0x055c
        L_0x0111:
            r4 = 0
            goto L_0x055c
        L_0x0114:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0124
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            r4 = 0
            goto L_0x055c
        L_0x0124:
            r4 = 0
            goto L_0x055c
        L_0x0127:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0139
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzgv r4 = (com.google.android.gms.internal.firebase_auth.zzgv) r4
            r2.zza((int) r15, (com.google.android.gms.internal.firebase_auth.zzgv) r4)
            r4 = 0
            goto L_0x055c
        L_0x0139:
            r4 = 0
            goto L_0x055c
        L_0x013c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0150
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzkh r9 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkh) r9)
            r4 = 0
            goto L_0x055c
        L_0x0150:
            r4 = 0
            goto L_0x055c
        L_0x0153:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0163
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzlw) r2)
            r4 = 0
            goto L_0x055c
        L_0x0163:
            r4 = 0
            goto L_0x055c
        L_0x0166:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0176
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            r4 = 0
            goto L_0x055c
        L_0x0176:
            r4 = 0
            goto L_0x055c
        L_0x0179:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x0189
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            r4 = 0
            goto L_0x055c
        L_0x0189:
            r4 = 0
            goto L_0x055c
        L_0x018c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x019c
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            r4 = 0
            goto L_0x055c
        L_0x019c:
            r4 = 0
            goto L_0x055c
        L_0x019f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x01af
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            r4 = 0
            goto L_0x055c
        L_0x01af:
            r4 = 0
            goto L_0x055c
        L_0x01b2:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x01c2
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            r4 = 0
            goto L_0x055c
        L_0x01c2:
            r4 = 0
            goto L_0x055c
        L_0x01c5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x01d5
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            r4 = 0
            goto L_0x055c
        L_0x01d5:
            r4 = 0
            goto L_0x055c
        L_0x01d8:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x01e8
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            r4 = 0
            goto L_0x055c
        L_0x01e8:
            r4 = 0
            goto L_0x055c
        L_0x01eb:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x01fb
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            r4 = 0
            goto L_0x055c
        L_0x01fb:
            r4 = 0
            goto L_0x055c
        L_0x01fe:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.firebase_auth.zzlw) r2, (int) r15, (java.lang.Object) r4, (int) r5)
            r4 = 0
            goto L_0x055c
        L_0x0208:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkh r13 = r0.zza((int) r5)
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (com.google.android.gms.internal.firebase_auth.zzkh) r13)
            r4 = 0
            goto L_0x055c
        L_0x021f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0232:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0245:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0258:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x026b:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x027e:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0291:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x02a4:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x02b7:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x02ca:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x02dd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x02f0:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0303:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (boolean) r13)
            r4 = 0
            goto L_0x055c
        L_0x0316:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (boolean) r13)
            r4 = 0
            goto L_0x055c
        L_0x0329:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zze(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x033c:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzj(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x034f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzg(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0362:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzl(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0375:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzm(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0388:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzi(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x039b:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r4, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2)
            r4 = 0
            goto L_0x055c
        L_0x03ad:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkh r13 = r0.zza((int) r5)
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (com.google.android.gms.internal.firebase_auth.zzkh) r13)
            r4 = 0
            goto L_0x055c
        L_0x03c4:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2)
            r4 = 0
            goto L_0x055c
        L_0x03d6:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzn(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x03e9:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzk(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x03fc:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzf(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x040f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzh(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0422:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzd(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0435:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzc(r4, r9, r2, r13)
            r4 = 0
            goto L_0x055c
        L_0x0448:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (boolean) r13)
            r4 = 0
            goto L_0x055c
        L_0x045b:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkj.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2, (boolean) r13)
            r4 = r13
            goto L_0x055c
        L_0x046e:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzkh r13 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r13)
            goto L_0x055c
        L_0x0480:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x055c
        L_0x048d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zzf(r15, r9)
            goto L_0x055c
        L_0x049a:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x055c
        L_0x04a7:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r9)
            goto L_0x055c
        L_0x04b4:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r9)
            goto L_0x055c
        L_0x04c1:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r9)
            goto L_0x055c
        L_0x04ce:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzgv r9 = (com.google.android.gms.internal.firebase_auth.zzgv) r9
            r2.zza((int) r15, (com.google.android.gms.internal.firebase_auth.zzgv) r9)
            goto L_0x055c
        L_0x04dd:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_auth.zzkh r13 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkh) r13)
            goto L_0x055c
        L_0x04ee:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            java.lang.Object r9 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzlw) r2)
            goto L_0x055c
        L_0x04fa:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            boolean r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r9)
            goto L_0x055c
        L_0x0507:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r9)
            goto L_0x055c
        L_0x0513:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x055c
        L_0x051f:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            int r9 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r9)
            goto L_0x055c
        L_0x052b:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x055c
        L_0x0537:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x055c
        L_0x0543:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            float r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r1, r13)
            r2.zza((int) r15, (float) r9)
            goto L_0x055c
        L_0x0550:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x055c
            double r13 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x055c:
            int r5 = r5 + 3
            goto L_0x0034
        L_0x0560:
            r14 = r11
        L_0x0561:
            if (r14 == 0) goto L_0x0578
            com.google.android.gms.internal.firebase_auth.zzhv<?> r4 = r0.zzr
            r4.zza(r2, r14)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0576
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r14 = r4
            goto L_0x0561
        L_0x0576:
            r14 = 0
            goto L_0x0561
        L_0x0578:
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.firebase_auth.zzlw) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjv.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzlw):void");
    }

    private final <K, V> void zza(zzlw zzlw, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlw.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkz<UT, UB> zzkz, T t, zzlw zzlw) throws IOException {
        zzkz.zza(zzkz.zzb(t), zzlw);
    }

    public final void zza(T t, zzke zzke, zzht zzht) throws IOException {
        int i;
        Object obj;
        zzhz<?> zzhz;
        T t2 = t;
        zzke zzke2 = zzke;
        zzht zzht2 = zzht;
        if (zzht2 != null) {
            zzkz<?, ?> zzkz = this.zzq;
            zzhv<?> zzhv = this.zzr;
            zzhz<?> zzhz2 = null;
            Object obj2 = null;
            while (true) {
                try {
                    int zza2 = zzke.zza();
                    if (zza2 < this.zze || zza2 > this.zzf) {
                        i = -1;
                    } else {
                        int i2 = 0;
                        int length = (this.zzc.length / 3) - 1;
                        while (true) {
                            if (i2 > length) {
                                i = -1;
                            } else {
                                int i3 = (length + i2) >>> 1;
                                i = i3 * 3;
                                int i4 = this.zzc[i];
                                if (zza2 != i4) {
                                    if (zza2 < i4) {
                                        length = i3 - 1;
                                    } else {
                                        i2 = i3 + 1;
                                    }
                                }
                            }
                        }
                    }
                    if (i >= 0) {
                        int zzd2 = zzd(i);
                        switch ((267386880 & zzd2) >>> 20) {
                            case 0:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzd());
                                zzb(t2, i);
                                break;
                            case 1:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zze());
                                zzb(t2, i);
                                break;
                            case 2:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzg());
                                zzb(t2, i);
                                break;
                            case 3:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzf());
                                zzb(t2, i);
                                break;
                            case 4:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzh());
                                zzb(t2, i);
                                break;
                            case 5:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzi());
                                zzb(t2, i);
                                break;
                            case 6:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzj());
                                zzb(t2, i);
                                break;
                            case 7:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzk());
                                zzb(t2, i);
                                break;
                            case 8:
                                zza((Object) t2, zzd2, zzke2);
                                zzb(t2, i);
                                break;
                            case 9:
                                if (!zza(t2, i)) {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zza(zza(i), zzht2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j, zzii.zza(zzlf.zzf(t2, j), zzke2.zza(zza(i), zzht2)));
                                    break;
                                }
                            case 10:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) zzke.zzn());
                                zzb(t2, i);
                                break;
                            case 11:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzo());
                                zzb(t2, i);
                                break;
                            case 12:
                                int zzp2 = zzke.zzp();
                                zzin zzc2 = zzc(i);
                                if (zzc2 != null) {
                                    if (!zzc2.zza(zzp2)) {
                                        obj2 = zzkj.zza(zza2, zzp2, obj2, zzkz);
                                        break;
                                    }
                                }
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzp2);
                                zzb(t2, i);
                                break;
                            case 13:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzq());
                                zzb(t2, i);
                                break;
                            case 14:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzr());
                                zzb(t2, i);
                                break;
                            case 15:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzs());
                                zzb(t2, i);
                                break;
                            case 16:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzt());
                                zzb(t2, i);
                                break;
                            case 17:
                                if (!zza(t2, i)) {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zzb(zza(i), zzht2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j2 = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j2, zzii.zza(zzlf.zzf(t2, j2), zzke2.zzb(zza(i), zzht2)));
                                    break;
                                }
                            case 18:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 19:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 20:
                                zzke2.zzd(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 21:
                                zzke2.zzc(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 22:
                                zzke2.zze(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 23:
                                zzke2.zzf(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 24:
                                zzke2.zzg(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 25:
                                zzke2.zzh(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 26:
                                if (!zzf(zzd2)) {
                                    zzke2.zzi(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    zzke2.zzj(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 27:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)), zza(i), zzht2);
                                break;
                            case 28:
                                zzke2.zzk(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 29:
                                zzke2.zzl(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 30:
                                List zza3 = this.zzp.zza(t2, (long) (zzd2 & 1048575));
                                zzke2.zzm(zza3);
                                obj2 = zzkj.zza(zza2, zza3, zzc(i), obj2, zzkz);
                                break;
                            case 31:
                                zzke2.zzn(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 32:
                                zzke2.zzo(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 33:
                                zzke2.zzp(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 34:
                                zzke2.zzq(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 35:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 36:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 37:
                                zzke2.zzd(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 38:
                                zzke2.zzc(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 39:
                                zzke2.zze(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 40:
                                zzke2.zzf(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 41:
                                zzke2.zzg(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 42:
                                zzke2.zzh(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 43:
                                zzke2.zzl(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 44:
                                List zza4 = this.zzp.zza(t2, (long) (zzd2 & 1048575));
                                zzke2.zzm(zza4);
                                obj2 = zzkj.zza(zza2, zza4, zzc(i), obj2, zzkz);
                                break;
                            case 45:
                                zzke2.zzn(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 46:
                                zzke2.zzo(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 47:
                                zzke2.zzp(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 48:
                                zzke2.zzq(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 49:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)), zza(i), zzht2);
                                break;
                            case 50:
                                Object zzb2 = zzb(i);
                                long zzd3 = (long) (zzd(i) & 1048575);
                                Object zzf2 = zzlf.zzf(t2, zzd3);
                                if (zzf2 == null) {
                                    zzf2 = this.zzs.zze(zzb2);
                                    zzlf.zza((Object) t2, zzd3, zzf2);
                                } else if (this.zzs.zzc(zzf2)) {
                                    Object zze2 = this.zzs.zze(zzb2);
                                    this.zzs.zza(zze2, zzf2);
                                    zzlf.zza((Object) t2, zzd3, zze2);
                                    zzf2 = zze2;
                                }
                                zzke2.zza(this.zzs.zza(zzf2), this.zzs.zzf(zzb2), zzht2);
                                break;
                            case 51:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Double.valueOf(zzke.zzd()));
                                zzb(t2, zza2, i);
                                break;
                            case 52:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Float.valueOf(zzke.zze()));
                                zzb(t2, zza2, i);
                                break;
                            case 53:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzg()));
                                zzb(t2, zza2, i);
                                break;
                            case 54:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzf()));
                                zzb(t2, zza2, i);
                                break;
                            case 55:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzh()));
                                zzb(t2, zza2, i);
                                break;
                            case 56:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzi()));
                                zzb(t2, zza2, i);
                                break;
                            case 57:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzj()));
                                zzb(t2, zza2, i);
                                break;
                            case 58:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Boolean.valueOf(zzke.zzk()));
                                zzb(t2, zza2, i);
                                break;
                            case 59:
                                zza((Object) t2, zzd2, zzke2);
                                zzb(t2, zza2, i);
                                break;
                            case 60:
                                if (zza(t2, zza2, i)) {
                                    long j3 = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j3, zzii.zza(zzlf.zzf(t2, j3), zzke2.zza(zza(i), zzht2)));
                                } else {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zza(zza(i), zzht2));
                                    zzb(t2, i);
                                }
                                zzb(t2, zza2, i);
                                break;
                            case 61:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) zzke.zzn());
                                zzb(t2, zza2, i);
                                break;
                            case 62:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzo()));
                                zzb(t2, zza2, i);
                                break;
                            case 63:
                                int zzp3 = zzke.zzp();
                                zzin zzc3 = zzc(i);
                                if (zzc3 != null) {
                                    if (!zzc3.zza(zzp3)) {
                                        obj2 = zzkj.zza(zza2, zzp3, obj2, zzkz);
                                        break;
                                    }
                                }
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzp3));
                                zzb(t2, zza2, i);
                                break;
                            case 64:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzq()));
                                zzb(t2, zza2, i);
                                break;
                            case 65:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzr()));
                                zzb(t2, zza2, i);
                                break;
                            case 66:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzs()));
                                zzb(t2, zza2, i);
                                break;
                            case 67:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzt()));
                                zzb(t2, zza2, i);
                                break;
                            case 68:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zzb(zza(i), zzht2));
                                zzb(t2, zza2, i);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = zzkz.zza();
                                }
                                if (zzkz.zza(obj2, zzke2)) {
                                    break;
                                } else {
                                    for (int i5 = this.zzm; i5 < this.zzn; i5++) {
                                        obj2 = zza((Object) t2, this.zzl[i5], obj2, zzkz);
                                    }
                                    if (obj2 != null) {
                                        zzkz.zzb((Object) t2, obj2);
                                        return;
                                    }
                                    return;
                                }
                        }
                    } else if (zza2 == Integer.MAX_VALUE) {
                        for (int i6 = this.zzm; i6 < this.zzn; i6++) {
                            obj2 = zza((Object) t2, this.zzl[i6], obj2, zzkz);
                        }
                        if (obj2 != null) {
                            zzkz.zzb((Object) t2, obj2);
                            return;
                        }
                        return;
                    } else {
                        if (!this.zzh) {
                            obj = null;
                        } else {
                            obj = zzhv.zza(zzht2, this.zzg, zza2);
                        }
                        if (obj != null) {
                            if (zzhz2 == null) {
                                zzhz = zzhv.zzb(t2);
                            } else {
                                zzhz = zzhz2;
                            }
                            obj2 = zzhv.zza(zzke, obj, zzht, zzhz, obj2, zzkz);
                            zzhz2 = zzhz;
                        } else {
                            zzkz.zza(zzke2);
                            if (obj2 == null) {
                                obj2 = zzkz.zzc(t2);
                            }
                            if (!zzkz.zza(obj2, zzke2)) {
                                for (int i7 = this.zzm; i7 < this.zzn; i7++) {
                                    obj2 = zza((Object) t2, this.zzl[i7], obj2, zzkz);
                                }
                                if (obj2 != null) {
                                    zzkz.zzb((Object) t2, obj2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (zziq e) {
                    zzkz.zza(zzke2);
                    if (obj2 == null) {
                        obj2 = zzkz.zzc(t2);
                    }
                    if (!zzkz.zza(obj2, zzke2)) {
                        for (int i8 = this.zzm; i8 < this.zzn; i8++) {
                            obj2 = zza((Object) t2, this.zzl[i8], obj2, zzkz);
                        }
                        if (obj2 != null) {
                            zzkz.zzb((Object) t2, obj2);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    for (int i9 = this.zzm; i9 < this.zzn; i9++) {
                        obj2 = zza((Object) t2, this.zzl[i9], obj2, zzkz);
                    }
                    if (obj2 != null) {
                        zzkz.zzb((Object) t2, obj2);
                    }
                    throw th2;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    private final zzkh zza(int i) {
        int i2 = (i / 3) << 1;
        zzkh zzkh = (zzkh) this.zzd[i2];
        if (zzkh != null) {
            return zzkh;
        }
        zzkh zza2 = zzkd.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzin zzc(int i) {
        return (zzin) this.zzd[((i / 3) << 1) + 1];
    }

    public final void zzb(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzlf.zzf(t, zzd2);
            if (zzf2 != null) {
                zzlf.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkz<UT, UB> zzkz) {
        zzin zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzlf.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzkz);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzin zzin, UB ub, zzkz<UT, UB> zzkz) {
        zzji<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzin.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkz.zza();
                }
                zzhd zzc2 = zzgv.zzc(zzjj.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzjj.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkz.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzc(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 == i3) {
                i2 = i3;
                i = i4;
            } else if (i9 != 1048575) {
                i = zzb.getInt(t2, (long) i9);
                i2 = i9;
            } else {
                i = i4;
                i2 = i9;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzlf.zzf(t2, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzlt.MESSAGE) {
                                    zzkh<?> zzkh = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkh == null) {
                                            zzkh = zzkd.zza().zza(next.getClass());
                                        }
                                        if (!zzkh.zzc(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzlf.zzf(t2, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzkh zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzc(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzkh zzkh) {
        return zzkh.zzc(zzlf.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzlw zzlw) throws IOException {
        if (obj instanceof String) {
            zzlw.zza(i, (String) obj);
        } else {
            zzlw.zza(i, (zzgv) obj);
        }
    }

    private final void zza(Object obj, int i, zzke zzke) throws IOException {
        if (zzf(i)) {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzm());
        } else if (this.zzi) {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzl());
        } else {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzlf.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzlf.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzlf.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzlf.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzlf.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzlf.zze(t, j2) != 0.0d;
                case 1:
                    return zzlf.zzd(t, j2) != 0.0f;
                case 2:
                    return zzlf.zzb(t, j2) != 0;
                case 3:
                    return zzlf.zzb(t, j2) != 0;
                case 4:
                    return zzlf.zza((Object) t, j2) != 0;
                case 5:
                    return zzlf.zzb(t, j2) != 0;
                case 6:
                    return zzlf.zza((Object) t, j2) != 0;
                case 7:
                    return zzlf.zzc(t, j2);
                case 8:
                    Object zzf2 = zzlf.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgv) {
                        return !zzgv.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzlf.zzf(t, j2) != null;
                case 10:
                    return !zzgv.zza.equals(zzlf.zzf(t, j2));
                case 11:
                    return zzlf.zza((Object) t, j2) != 0;
                case 12:
                    return zzlf.zza((Object) t, j2) != 0;
                case 13:
                    return zzlf.zza((Object) t, j2) != 0;
                case 14:
                    return zzlf.zzb(t, j2) != 0;
                case 15:
                    return zzlf.zza((Object) t, j2) != 0;
                case 16:
                    return zzlf.zzb(t, j2) != 0;
                case 17:
                    return zzlf.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzlf.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzlf.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzlf.zza((Object) t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzlf.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzlf.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }
}
