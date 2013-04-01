package com.tw.container;

import com.google.common.collect.Maps;

import java.util.Map;

public class PillContext {
    public static final String PILL_ID = "id";
    private final Map<String, Map<String, Object>> map;

    public PillContext(Map pillMap) {
        map = Maps.newHashMap(pillMap);
    }

    public Map<String, Object> getPill(String pillName) {
        return map.get(pillName);
    }

    public Class<?> getPillClass(String pillName) throws ClassNotFoundException {
        Map<String, Object> pill = getPill(pillName);
        return Class.forName(pill.get("class").toString());
    }
}
