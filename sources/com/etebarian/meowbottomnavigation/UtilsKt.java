package com.etebarian.meowbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u001aA\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f*\u0002H\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"dip", "", "context", "Landroid/content/Context;", "i", "dipf", "", "f", "getDP", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "res", "runAfterDelay", "", "T", "Landroid/view/View;", "delay", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "meowbottomnavigation_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class UtilsKt {
    private static final float getDP(Context context) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return resources.getDisplayMetrics().density;
    }

    public static final float dipf(Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return getDP(context) * f;
    }

    public static final float dipf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ((float) i) * getDP(context);
    }

    public static final int dip(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return (int) (((float) i) * getDP(context));
    }

    public static final Drawable getDrawableCompat(Context $receiver, int res) {
        Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
        return ContextCompat.getDrawable($receiver, res);
    }

    public static final <T extends View> void runAfterDelay(T $receiver, long delay, Function1<? super T, Unit> f) {
        Intrinsics.checkParameterIsNotNull(f, "f");
        if ($receiver != null) {
            $receiver.postDelayed(new UtilsKt$runAfterDelay$1($receiver, f), delay);
        }
    }
}
