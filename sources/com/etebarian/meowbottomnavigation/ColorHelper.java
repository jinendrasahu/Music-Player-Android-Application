package com.etebarian.meowbottomnavigation;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/etebarian/meowbottomnavigation/ColorHelper;", "", "()V", "mixTwoColors", "", "color1", "color2", "amount", "", "meowbottomnavigation_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class ColorHelper {
    public static final ColorHelper INSTANCE = new ColorHelper();

    private ColorHelper() {
    }

    public final int mixTwoColors(int color1, int color2, float amount) {
        float inverseAmount = 1.0f - amount;
        return ((((int) ((((float) ((color1 >> 24) & 255)) * amount) + (((float) ((color2 >> 24) & 255)) * inverseAmount))) & 255) << 24) | ((((int) ((((float) ((color1 >> 16) & 255)) * amount) + (((float) ((color2 >> 16) & 255)) * inverseAmount))) & 255) << 16) | ((((int) ((((float) ((color1 >> 8) & 255)) * amount) + (((float) ((color2 >> 8) & 255)) * inverseAmount))) & 255) << 8) | (((int) ((((float) (color1 & 255)) * amount) + (((float) (color2 & 255)) * inverseAmount))) & 255);
    }
}
