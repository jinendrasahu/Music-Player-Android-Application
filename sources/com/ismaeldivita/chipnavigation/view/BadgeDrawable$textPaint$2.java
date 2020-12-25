package com.ismaeldivita.chipnavigation.view;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.ismaeldivita.chipnavigation.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/text/TextPaint;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: BadgeDrawable.kt */
final class BadgeDrawable$textPaint$2 extends Lambda implements Function0<TextPaint> {
    final /* synthetic */ BadgeDrawable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BadgeDrawable$textPaint$2(BadgeDrawable badgeDrawable) {
        super(0);
        this.this$0 = badgeDrawable;
    }

    public final TextPaint invoke() {
        TextPaint textPaint = new TextPaint();
        TextPaint $this$apply = textPaint;
        $this$apply.setAntiAlias(true);
        $this$apply.setColor(-1);
        $this$apply.setTextSize(this.this$0.getContext().getResources().getDimension(R.dimen.cnb_badge_text_size));
        $this$apply.setFakeBoldText(true);
        $this$apply.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        return textPaint;
    }
}
