package com.tw.container;

import com.google.common.collect.Maps;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class PillBox {
    public static final String PILL_ID = "id";
    private final Map<String, Map<String, String>> map;

    public PillBox(List<Map<String, String>> info) {
        this.map = Maps.newHashMap();
        for (Map<String, String> item : info) {
            map.put(item.get(PILL_ID), item);
        }
    }

    public Object create_pill(String pillName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Map<String, String> objectInfo = map.get(pillName);
        return createObject(objectInfo);
    }

    private Object createObject(Map<String, String> objectInfo) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println(objectInfo);
        Class<?> clazz = Class.forName(objectInfo.get("class"));
        Constructor<?> ctor = clazz.getConstructor();
        return ctor.newInstance();
    }

    public static PillBox loadContext(String path)  {
        List pillMap = ContextLoader.getContextDefinition(path);
        return new PillBox(pillMap);

    }

}
