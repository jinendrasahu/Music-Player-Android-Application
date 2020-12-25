package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/etebarian/meowbottomnavigation/CellImageView$changeColorByAnim$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: CellImageView.kt */
final class CellImageView$changeColorByAnim$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ long $d$inlined;
    final /* synthetic */ int $lastColor$inlined;
    final /* synthetic */ int $newColor$inlined;
    final /* synthetic */ CellImageView this$0;

    CellImageView$changeColorByAnim$$inlined$apply$lambda$1(CellImageView cellImageView, long j, int i, int i2) {
        this.this$0 = cellImageView;
        this.$d$inlined = j;
        this.$newColor$inlined = i;
        this.$lastColor$inlined = i2;
    }

    public final void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkExpressionValueIsNotNull(animation, "animation");
        this.this$0.setColor(ColorHelper.INSTANCE.mixTwoColors(this.$newColor$inlined, this.$lastColor$inlined, animation.getAnimatedFraction()));
    }
}
