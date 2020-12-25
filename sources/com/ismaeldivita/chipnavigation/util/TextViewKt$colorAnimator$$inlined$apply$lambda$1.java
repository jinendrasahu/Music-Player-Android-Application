package com.ismaeldivita.chipnavigation.util;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/ismaeldivita/chipnavigation/util/TextViewKt$colorAnimator$1$1"}, k = 3, mv = {1, 1, 15})
/* compiled from: TextView.kt */
final class TextViewKt$colorAnimator$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ long $durationInMillis$inlined;
    final /* synthetic */ TextView $this_colorAnimator$inlined;

    TextViewKt$colorAnimator$$inlined$apply$lambda$1(TextView textView, long j) {
        this.$this_colorAnimator$inlined = textView;
        this.$durationInMillis$inlined = j;
    }

    public final void onAnimationUpdate(ValueAnimator animator) {
        TextView textView = this.$this_colorAnimator$inlined;
        Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        if (animatedValue != null) {
            textView.setTextColor(((Integer) animatedValue).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
