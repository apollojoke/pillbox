package com.tw.container;

import java.util.List;

public class PillContext {
    private final List pillMap;

    public PillContext(List pillMap) {
        this.pillMap = pillMap;
    }

    public List getMap() {
        return pillMap;
    }
}
