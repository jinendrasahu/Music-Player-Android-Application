package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/etebarian/meowbottomnavigation/MeowBottomNavigation$anim$2$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigation.kt */
final class MeowBottomNavigation$anim$$inlined$apply$lambda$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ long $animDuration$inlined;
    final /* synthetic */ FastOutSlowInInterpolator $animInterpolator$inlined;
    final /* synthetic */ MeowBottomNavigation this$0;

    MeowBottomNavigation$anim$$inlined$apply$lambda$2(MeowBottomNavigation meowBottomNavigation, long j, FastOutSlowInInterpolator fastOutSlowInInterpolator) {
        this.this$0 = meowBottomNavigation;
        this.$animDuration$inlined = j;
        this.$animInterpolator$inlined = fastOutSlowInInterpolator;
    }

    public final void onAnimationUpdate(ValueAnimator it) {
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        MeowBottomNavigation.access$getBezierView$p(this.this$0).setProgress(2.0f * it.getAnimatedFraction());
    }
}
