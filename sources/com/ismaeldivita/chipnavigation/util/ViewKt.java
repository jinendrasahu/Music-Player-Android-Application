package com.ismaeldivita.chipnavigation.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\t"}, d2 = {"beginDelayedTransitionOnParent", "", "Landroid/view/View;", "transition", "Landroid/transition/Transition;", "setCustomRipple", "selectedBackground", "Landroid/graphics/drawable/Drawable;", "mask", "chip-navigation-bar_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: View.kt */
public final class ViewKt {
    public static final void setCustomRipple(View $this$setCustomRipple, Drawable selectedBackground, Drawable mask) {
        Intrinsics.checkParameterIsNotNull($this$setCustomRipple, "$this$setCustomRipple");
        Intrinsics.checkParameterIsNotNull(selectedBackground, "selectedBackground");
        Intrinsics.checkParameterIsNotNull(mask, "mask");
        Context context = $this$setCustomRipple.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        ColorStateList colorStateList = ColorStateList.valueOf(ContextKt.getValueFromAttr(context, 16843820));
        Intrinsics.checkExpressionValueIsNotNull(colorStateList, "ColorStateList.valueOf(highlightColor)");
        RippleDrawable unselected = new RippleDrawable(colorStateList, (Drawable) null, mask);
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{16842913}, selectedBackground);
        states.addState(new int[0], new ColorDrawable(0));
        $this$setCustomRipple.setBackground(states);
        $this$setCustomRipple.setForeground(unselected);
    }

    public static /* synthetic */ void beginDelayedTransitionOnParent$default(View view, Transition transition, int i, Object obj) {
        if ((i & 1) != 0) {
            transition = null;
        }
        beginDelayedTransitionOnParent(view, transition);
    }

    public static final void beginDelayedTransitionOnParent(View $this$beginDelayedTransitionOnParent, Transition transition) {
        Intrinsics.checkParameterIsNotNull($this$beginDelayedTransitionOnParent, "$this$beginDelayedTransitionOnParent");
        ViewParent parent = $this$beginDelayedTransitionOnParent.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup it = (ViewGroup) parent;
        if (it != null) {
            TransitionManager.beginDelayedTransition(it, transition);
        }
    }
}
