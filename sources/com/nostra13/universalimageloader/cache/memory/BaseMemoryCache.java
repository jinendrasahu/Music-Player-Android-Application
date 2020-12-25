package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class BaseMemoryCache implements MemoryCache {
    private final Map<String, Reference<Bitmap>> softMap = Collections.synchronizedMap(new HashMap());

    /* access modifiers changed from: protected */
    public abstract Reference<Bitmap> createReference(Bitmap bitmap);

    public Bitmap get(String key) {
        Reference<Bitmap> reference = this.softMap.get(key);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public boolean put(String key, Bitmap value) {
        this.softMap.put(key, createReference(value));
        return true;
    }

    public Bitmap remove(String key) {
        Reference<Bitmap> bmpRef = this.softMap.remove(key);
        if (bmpRef == null) {
            return null;
        }
        return bmpRef.get();
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    public void clear() {
        this.softMap.clear();
    }
}
