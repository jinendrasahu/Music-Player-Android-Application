package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;

public class LibraryVersionComponent {
    private LibraryVersionComponent() {
    }

    public static Component<?> create(String sdkName, String version) {
        return Component.intoSet(LibraryVersion.create(sdkName, version), LibraryVersion.class);
    }
}
