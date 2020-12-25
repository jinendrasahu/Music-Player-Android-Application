package androidx.core.os;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* compiled from: Bundle.kt */
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        Bundle bundle = new Bundle(pairs.length);
        Bundle $receiver = bundle;
        for (Pair<String, ? extends Object> pair : pairs) {
            String key = pair.component1();
            Object value = pair.component2();
            if (value == null) {
                $receiver.putString(key, (String) null);
            } else if (value instanceof Boolean) {
                $receiver.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                $receiver.putByte(key, ((Number) value).byteValue());
            } else if (value instanceof Character) {
                $receiver.putChar(key, ((Character) value).charValue());
            } else if (value instanceof Double) {
                $receiver.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Float) {
                $receiver.putFloat(key, ((Number) value).floatValue());
            } else if (value instanceof Integer) {
                $receiver.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                $receiver.putLong(key, ((Number) value).longValue());
            } else if (value instanceof Short) {
                $receiver.putShort(key, ((Number) value).shortValue());
            } else if (value instanceof Bundle) {
                $receiver.putBundle(key, (Bundle) value);
            } else if (value instanceof CharSequence) {
                $receiver.putCharSequence(key, (CharSequence) value);
            } else if (value instanceof Parcelable) {
                $receiver.putParcelable(key, (Parcelable) value);
            } else if (value instanceof boolean[]) {
                $receiver.putBooleanArray(key, (boolean[]) value);
            } else if (value instanceof byte[]) {
                $receiver.putByteArray(key, (byte[]) value);
            } else if (value instanceof char[]) {
                $receiver.putCharArray(key, (char[]) value);
            } else if (value instanceof double[]) {
                $receiver.putDoubleArray(key, (double[]) value);
            } else if (value instanceof float[]) {
                $receiver.putFloatArray(key, (float[]) value);
            } else if (value instanceof int[]) {
                $receiver.putIntArray(key, (int[]) value);
            } else if (value instanceof long[]) {
                $receiver.putLongArray(key, (long[]) value);
            } else if (value instanceof short[]) {
                $receiver.putShortArray(key, (short[]) value);
            } else if (value instanceof Object[]) {
                Class componentType = value.getClass().getComponentType();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (value != null) {
                        $receiver.putParcelableArray(key, (Parcelable[]) value);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (value != null) {
                        $receiver.putStringArray(key, (String[]) value);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (value != null) {
                        $receiver.putCharSequenceArray(key, (CharSequence[]) value);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    $receiver.putSerializable(key, (Serializable) value);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(componentType, "componentType");
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + key + Typography.quote);
                }
            } else if (value instanceof Serializable) {
                $receiver.putSerializable(key, (Serializable) value);
            } else if (Build.VERSION.SDK_INT >= 18 && (value instanceof Binder)) {
                $receiver.putBinder(key, (IBinder) value);
            } else if (Build.VERSION.SDK_INT >= 21 && (value instanceof Size)) {
                $receiver.putSize(key, (Size) value);
            } else if (Build.VERSION.SDK_INT < 21 || !(value instanceof SizeF)) {
                throw new IllegalArgumentException("Illegal value type " + value.getClass().getCanonicalName() + " for key \"" + key + Typography.quote);
            } else {
                $receiver.putSizeF(key, (SizeF) value);
            }
        }
        return bundle;
    }
}
