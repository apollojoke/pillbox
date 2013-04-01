package com.tw.container;

import com.google.common.collect.Maps;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class PillBox {

    private final PillContext pillContext;

    public PillBox(PillContext pillContext) {
        this.pillContext = pillContext;

    }

    public Object create_pill(String pillName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Map<String, String> objectInfo = pillContext.getPill(pillName);
        return createObject(objectInfo);
    }

    private Object createObject(Map<String, String> objectInfo) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println(objectInfo);
        Class<?> clazz = Class.forName(objectInfo.get("class"));
        Constructor<?> ctor = clazz.getConstructor();
        return ctor.newInstance();
    }

    public static PillBox loadContext(String path) throws FileNotFoundException {
        PillContext pillContext = new ContextLoader().getContextDefinition(path);
        return new PillBox(pillContext);

    }

}
