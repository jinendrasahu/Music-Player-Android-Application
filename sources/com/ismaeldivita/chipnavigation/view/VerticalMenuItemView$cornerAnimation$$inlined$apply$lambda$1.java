package com.ismaeldivita.chipnavigation.view;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/ismaeldivita/chipnavigation/view/VerticalMenuItemView$cornerAnimation$1$1"}, k = 3, mv = {1, 1, 15})
/* compiled from: VerticalMenuItemView.kt */
final class VerticalMenuItemView$cornerAnimation$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ GradientDrawable $this_cornerAnimation$inlined;
    final /* synthetic */ VerticalMenuItemView this$0;

    VerticalMenuItemView$cornerAnimation$$inlined$apply$lambda$1(VerticalMenuItemView verticalMenuItemView, GradientDrawable gradientDrawable) {
        this.this$0 = verticalMenuItemView;
        this.$this_cornerAnimation$inlined = gradientDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator it) {
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue != null) {
            float corner = ((Float) animatedValue).floatValue();
            this.$this_cornerAnimation$inlined.setCornerRadii(this.$this_cornerAnimation$inlined.getLayoutDirection() == 0 ? new float[]{corner, corner, this.this$0.radius, this.this$0.radius, this.this$0.radius, this.this$0.radius, corner, corner} : new float[]{this.this$0.radius, this.this$0.radius, corner, corner, corner, corner, this.this$0.radius, this.this$0.radius});
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
