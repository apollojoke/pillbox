package com.tw.container;

import org.yaml.snakeyaml.Yaml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PillBox {
    private final Object target;

    public PillBox(Object object) {
        target = object;

    }

    public Object create_pill(String pillName) {
        return target;
    }

    public static PillBox loadContext(String path) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Yaml yaml = new Yaml();
        String document = "- id: aspirin\n  class: example.Aspirin";
        List<String> list = (List<String>) yaml.load(document);
        System.out.println(list);
        Class<?> clazz = Class.forName("example.Aspirin");
        Constructor<?> ctor = clazz.getConstructor();
        Object object = ctor.newInstance();
        return new PillBox(object);

    }
}
