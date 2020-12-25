package com.ismaeldivita.chipnavigation.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ismaeldivita/chipnavigation/view/BadgeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "badge", "Lcom/ismaeldivita/chipnavigation/view/BadgeDrawable;", "dismissBadge", "", "setBadgeColor", "color", "", "showBadge", "count", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: BadgeImageView.kt */
public final class BadgeImageView extends AppCompatImageView {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BadgeDrawable badge;

    public BadgeImageView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.badge = new BadgeDrawable(context);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            final /* synthetic */ BadgeImageView this$0;

            {
                this.this$0 = r1;
            }

            public final void onLayoutChange(View $noName_0, int $noName_1, int $noName_2, int $noName_3, int $noName_4, int $noName_5, int $noName_6, int $noName_7, int $noName_8) {
                if (this.this$0.getVisibility() == 0) {
                    BadgeDrawable access$getBadge$p = this.this$0.badge;
                    Rect p1 = new Rect();
                    this.this$0.getDrawingRect(p1);
                    access$getBadge$p.updateBadgeBounds(p1);
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setBadgeColor(int color) {
        this.badge.setColor(color);
    }

    public final void showBadge(int count) {
        Rect bounds = new Rect();
        getDrawingRect(bounds);
        this.badge.setCount(count);
        if (!bounds.isEmpty()) {
            this.badge.updateBadgeBounds(bounds);
        }
        getOverlay().add(this.badge);
        invalidate();
    }

    public final void dismissBadge() {
        getOverlay().remove(this.badge);
        invalidate();
    }
}
