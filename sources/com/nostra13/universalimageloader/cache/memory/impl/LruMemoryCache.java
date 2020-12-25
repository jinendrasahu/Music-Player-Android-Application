package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int maxSize2) {
        if (maxSize2 > 0) {
            this.maxSize = maxSize2;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final Bitmap get(String key) {
        Bitmap bitmap;
        if (key != null) {
            synchronized (this) {
                bitmap = this.map.get(key);
            }
            return bitmap;
        }
        throw new NullPointerException("key == null");
    }

    public final boolean put(String key, Bitmap value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += sizeOf(key, value);
            Bitmap previous = (Bitmap) this.map.put(key, value);
            if (previous != null) {
                this.size -= sizeOf(key, previous);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trimToSize(int r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            monitor-enter(r5)
            int r2 = r5.size     // Catch:{ all -> 0x0077 }
            if (r2 < 0) goto L_0x0058
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r5.map     // Catch:{ all -> 0x0077 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x0013
            int r2 = r5.size     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0058
        L_0x0013:
            int r2 = r5.size     // Catch:{ all -> 0x0077 }
            if (r2 <= r6) goto L_0x0056
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r5.map     // Catch:{ all -> 0x0077 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x0020
            goto L_0x0056
        L_0x0020:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r5.map     // Catch:{ all -> 0x0077 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0077 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0077 }
            java.lang.Object r2 = r2.next()     // Catch:{ all -> 0x0077 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0034
            monitor-exit(r5)     // Catch:{ all -> 0x0077 }
            goto L_0x0057
        L_0x0034:
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0077 }
            r0 = r3
            java.lang.Object r3 = r2.getValue()     // Catch:{ all -> 0x0054 }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ all -> 0x0054 }
            r1 = r3
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r3 = r5.map     // Catch:{ all -> 0x0052 }
            r3.remove(r0)     // Catch:{ all -> 0x0052 }
            int r3 = r5.size     // Catch:{ all -> 0x0052 }
            int r4 = r5.sizeOf(r0, r1)     // Catch:{ all -> 0x0052 }
            int r3 = r3 - r4
            r5.size = r3     // Catch:{ all -> 0x0052 }
            monitor-exit(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x0002
        L_0x0052:
            r2 = move-exception
            goto L_0x0078
        L_0x0054:
            r2 = move-exception
            goto L_0x0078
        L_0x0056:
            monitor-exit(r5)     // Catch:{ all -> 0x0077 }
        L_0x0057:
            return
        L_0x0058:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.Class r4 = r5.getClass()     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0077 }
            r3.append(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = ".sizeOf() is reporting inconsistent results!"
            r3.append(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0077 }
            r2.<init>(r3)     // Catch:{ all -> 0x0077 }
            throw r2     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r2 = move-exception
        L_0x0078:
            monitor-exit(r5)     // Catch:{ all -> 0x007a }
            throw r2
        L_0x007a:
            r2 = move-exception
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache.trimToSize(int):void");
    }

    public final Bitmap remove(String key) {
        Bitmap previous;
        if (key != null) {
            synchronized (this) {
                previous = (Bitmap) this.map.remove(key);
                if (previous != null) {
                    this.size -= sizeOf(key, previous);
                }
            }
            return previous;
        }
        throw new NullPointerException("key == null");
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    public void clear() {
        trimToSize(-1);
    }

    private int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.maxSize)});
    }
}
