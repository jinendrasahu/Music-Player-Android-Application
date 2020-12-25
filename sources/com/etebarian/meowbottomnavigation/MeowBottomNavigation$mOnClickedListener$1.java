package com.etebarian.meowbottomnavigation;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/etebarian/meowbottomnavigation/MeowBottomNavigation$Model;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: MeowBottomNavigation.kt */
final class MeowBottomNavigation$mOnClickedListener$1 extends Lambda implements Function1<MeowBottomNavigation.Model, Unit> {
    public static final MeowBottomNavigation$mOnClickedListener$1 INSTANCE = new MeowBottomNavigation$mOnClickedListener$1();

    MeowBottomNavigation$mOnClickedListener$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MeowBottomNavigation.Model) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MeowBottomNavigation.Model it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
    }
}
