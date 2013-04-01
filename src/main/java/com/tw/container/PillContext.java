package com.tw.container;

import com.google.common.collect.Maps;

import java.util.Map;

public class PillContext {
    public static final String PILL_ID = "id";
    private final Map<String, Map<String, String>> map;

    public PillContext(Map pillMap) {
        map = Maps.newHashMap(pillMap);
    }

    public Map<String, String> getPill(String pillName) {
        return map.get(pillName);
    }
}
