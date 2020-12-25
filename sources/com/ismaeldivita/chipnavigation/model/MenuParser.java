package com.ismaeldivita.chipnavigation.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import com.ismaeldivita.chipnavigation.R;
import com.ismaeldivita.chipnavigation.util.ContextKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ismaeldivita/chipnavigation/model/MenuParser;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "parse", "Lcom/ismaeldivita/chipnavigation/model/Menu;", "menuRes", "", "menuStyle", "Lcom/ismaeldivita/chipnavigation/model/MenuStyle;", "parseMenu", "parser", "Landroid/content/res/XmlResourceParser;", "attrs", "Landroid/util/AttributeSet;", "parseMenuItem", "Lcom/ismaeldivita/chipnavigation/model/MenuItem;", "readBackgroundColor", "sAttr", "Landroid/content/res/TypedArray;", "readIconActiveColor", "readIconTintMode", "Landroid/graphics/PorterDuff$Mode;", "readTextActiveColor", "skipMenuTagStart", "", "Companion", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: MenuParser.kt */
public final class MenuParser {
    @Deprecated
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String XML_MENU_ITEM_TAG = "item";
    public static final String XML_MENU_TAG = "menu";
    private final Context context;

    public MenuParser(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ismaeldivita/chipnavigation/model/MenuParser$Companion;", "", "()V", "XML_MENU_ITEM_TAG", "", "XML_MENU_TAG", "chip-navigation-bar_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: MenuParser.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final Menu parse(int menuRes, MenuStyle menuStyle) {
        Intrinsics.checkParameterIsNotNull(menuStyle, "menuStyle");
        XmlResourceParser parser = this.context.getResources().getLayout(menuRes);
        Intrinsics.checkExpressionValueIsNotNull(parser, "context.resources.getLayout(menuRes)");
        AttributeSet attrs = Xml.asAttributeSet(parser);
        skipMenuTagStart(parser);
        Intrinsics.checkExpressionValueIsNotNull(attrs, "attrs");
        return parseMenu(parser, attrs, menuStyle);
    }

    private final void skipMenuTagStart(XmlResourceParser parser) {
        int currentEvent = parser.getEventType();
        while (currentEvent != 2) {
            currentEvent = parser.next();
            if (currentEvent == 1) {
                return;
            }
        }
        String name = parser.getName();
        if (!Intrinsics.areEqual((Object) name, (Object) XML_MENU_TAG)) {
            throw new IllegalArgumentException(("Expecting menu, got " + name).toString());
        }
    }

    private final Menu parseMenu(XmlResourceParser parser, AttributeSet attrs, MenuStyle menuStyle) {
        List items = new ArrayList();
        int eventType = parser.getEventType();
        boolean isEndOfMenu = false;
        while (!isEndOfMenu) {
            String name = parser.getName();
            if (eventType == 2 && Intrinsics.areEqual((Object) name, (Object) XML_MENU_ITEM_TAG)) {
                items.add(parseMenuItem(attrs, menuStyle));
            } else if (eventType == 3 && Intrinsics.areEqual((Object) name, (Object) XML_MENU_TAG)) {
                isEndOfMenu = true;
            } else if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            eventType = parser.next();
        }
        return new Menu(items);
    }

    private final MenuItem parseMenuItem(AttributeSet attrs, MenuStyle menuStyle) {
        TypedArray sAttr = this.context.obtainStyledAttributes(attrs, R.styleable.ChipMenuItem);
        int resourceId = sAttr.getResourceId(R.styleable.ChipMenuItem_android_id, 0);
        CharSequence text = sAttr.getText(R.styleable.ChipMenuItem_android_title);
        Intrinsics.checkExpressionValueIsNotNull(text, "sAttr.getText(R.styleabl…ipMenuItem_android_title)");
        CharSequence text2 = sAttr.getText(R.styleable.ChipMenuItem_android_contentDescription);
        int resourceId2 = sAttr.getResourceId(R.styleable.ChipMenuItem_android_icon, 0);
        boolean z = sAttr.getBoolean(R.styleable.ChipMenuItem_android_enabled, true);
        Intrinsics.checkExpressionValueIsNotNull(sAttr, "sAttr");
        int readIconActiveColor = readIconActiveColor(sAttr);
        MenuItem item = new MenuItem(resourceId, text, text2, resourceId2, z, readIconTintMode(sAttr), readIconActiveColor, readTextActiveColor(sAttr), readBackgroundColor(sAttr), menuStyle);
        sAttr.recycle();
        return item;
    }

    private final PorterDuff.Mode readIconTintMode(TypedArray sAttr) {
        int i = sAttr.getInt(R.styleable.ChipMenuItem_cnb_iconTintMode, -1);
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return null;
        }
    }

    private final int readIconActiveColor(TypedArray sAttr) {
        return sAttr.getColor(R.styleable.ChipMenuItem_cnb_iconColor, ContextKt.getValueFromAttr(this.context, R.attr.colorAccent));
    }

    private final int readTextActiveColor(TypedArray sAttr) {
        return sAttr.getColor(R.styleable.ChipMenuItem_cnb_textColor, readIconActiveColor(sAttr));
    }

    private final int readBackgroundColor(TypedArray sAttr) {
        int iconTintColor = readIconActiveColor(sAttr);
        return sAttr.getColor(R.styleable.ChipMenuItem_cnb_backgroundColor, Color.argb((int) (((double) Color.alpha(iconTintColor)) * 0.15d), Color.red(iconTintColor), Color.green(iconTintColor), Color.blue(iconTintColor)));
    }
}
