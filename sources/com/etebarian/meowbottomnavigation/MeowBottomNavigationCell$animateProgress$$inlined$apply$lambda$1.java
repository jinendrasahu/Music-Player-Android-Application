package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/etebarian/meowbottomnavigation/MeowBottomNavigationCell$animateProgress$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigationCell.kt */
final class MeowBottomNavigationCell$animateProgress$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ long $d$inlined;
    final /* synthetic */ boolean $enableCell$inlined;
    final /* synthetic */ boolean $isAnimate$inlined;
    final /* synthetic */ MeowBottomNavigationCell this$0;

    MeowBottomNavigationCell$animateProgress$$inlined$apply$lambda$1(MeowBottomNavigationCell meowBottomNavigationCell, boolean z, long j, boolean z2) {
        this.this$0 = meowBottomNavigationCell;
        this.$enableCell$inlined = z;
        this.$d$inlined = j;
        this.$isAnimate$inlined = z2;
    }

    public final void onAnimationUpdate(ValueAnimator it) {
        float f;
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        float f2 = it.getAnimatedFraction();
        MeowBottomNavigationCell meowBottomNavigationCell = this.this$0;
        if (this.$enableCell$inlined) {
            f = f2;
        } else {
            f = 1.0f - f2;
        }
        meowBottomNavigationCell.setProgress(f);
    }
}
