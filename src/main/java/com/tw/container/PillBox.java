package com.tw.container;

import example.Aspirin;

public class PillBox {
    public Object create_pill(String pillName) {
        return new Aspirin();
    }

    public static PillBox loadContext(String path) {
        return new PillBox();

    }
}
