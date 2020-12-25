package com.ismaeldivita.chipnavigation.util;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a(\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\n*\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TEXT_STATE_ANIMATOR_DURATION", "", "colorAnimator", "Landroid/animation/Animator;", "Landroid/widget/TextView;", "from", "", "to", "durationInMillis", "setColorStateListAnimator", "", "color", "unselectedColor", "chip-navigation-bar_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: TextView.kt */
public final class TextViewKt {
    private static final long TEXT_STATE_ANIMATOR_DURATION = 350;

    public static final Animator colorAnimator(TextView $this$colorAnimator, int from, int to, long durationInMillis) {
        Intrinsics.checkParameterIsNotNull($this$colorAnimator, "$this$colorAnimator");
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(from), Integer.valueOf(to)});
        ValueAnimator $this$apply = ofObject;
        $this$apply.setDuration(durationInMillis);
        $this$apply.addUpdateListener(new TextViewKt$colorAnimator$$inlined$apply$lambda$1($this$colorAnimator, durationInMillis));
        Intrinsics.checkExpressionValueIsNotNull(ofObject, "ValueAnimator.ofObject(A…atedValue as Int)\n    }\n}");
        return ofObject;
    }

    public static final void setColorStateListAnimator(TextView $this$setColorStateListAnimator, int color, int unselectedColor) {
        Intrinsics.checkParameterIsNotNull($this$setColorStateListAnimator, "$this$setColorStateListAnimator");
        StateListAnimator stateList = new StateListAnimator();
        StateListAnimator $this$apply = stateList;
        $this$apply.addState(new int[]{16842913}, colorAnimator($this$setColorStateListAnimator, unselectedColor, color, TEXT_STATE_ANIMATOR_DURATION));
        $this$apply.addState(new int[0], colorAnimator($this$setColorStateListAnimator, color, unselectedColor, TEXT_STATE_ANIMATOR_DURATION));
        $this$setColorStateListAnimator.setStateListAnimator(stateList);
        $this$setColorStateListAnimator.refreshDrawableState();
    }
}
