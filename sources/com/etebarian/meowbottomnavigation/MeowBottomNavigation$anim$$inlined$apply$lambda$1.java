package com.etebarian.meowbottomnavigation;

import android.animation.ValueAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/etebarian/meowbottomnavigation/MeowBottomNavigation$anim$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigation.kt */
final class MeowBottomNavigation$anim$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ long $animDuration$inlined;
    final /* synthetic */ FastOutSlowInInterpolator $animInterpolator$inlined;
    final /* synthetic */ float $beforeX;
    final /* synthetic */ MeowBottomNavigationCell $cell$inlined;
    final /* synthetic */ MeowBottomNavigation this$0;

    MeowBottomNavigation$anim$$inlined$apply$lambda$1(float f, MeowBottomNavigation meowBottomNavigation, long j, FastOutSlowInInterpolator fastOutSlowInInterpolator, MeowBottomNavigationCell meowBottomNavigationCell) {
        this.$beforeX = f;
        this.this$0 = meowBottomNavigation;
        this.$animDuration$inlined = j;
        this.$animInterpolator$inlined = fastOutSlowInInterpolator;
        this.$cell$inlined = meowBottomNavigationCell;
    }

    public final void onAnimationUpdate(ValueAnimator it) {
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        float f = it.getAnimatedFraction();
        float newX = this.$cell$inlined.getX() + ((float) (this.$cell$inlined.getMeasuredWidth() / 2));
        if (newX > this.$beforeX) {
            BezierView access$getBezierView$p = MeowBottomNavigation.access$getBezierView$p(this.this$0);
            float f2 = this.$beforeX;
            access$getBezierView$p.setBezierX(((newX - f2) * f) + f2);
        } else {
            BezierView access$getBezierView$p2 = MeowBottomNavigation.access$getBezierView$p(this.this$0);
            float f3 = this.$beforeX;
            access$getBezierView$p2.setBezierX(f3 - ((f3 - newX) * f));
        }
        if (f == 1.0f) {
            this.this$0.isAnimating = false;
        }
    }
}
