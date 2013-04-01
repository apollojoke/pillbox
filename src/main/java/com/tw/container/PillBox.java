package com.tw.container;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.istack.internal.Nullable;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterators.transform;

public class PillBox {

    private final PillContext pillContext;

    public PillBox(PillContext pillContext) {
        this.pillContext = pillContext;

    }

    public Object create_pill(String pillName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Map<String, Object> objectInfo = pillContext.getPill(pillName);
        return createObject(objectInfo);
    }

    private Object createObject(Map<String, Object> objectInfo) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName(objectInfo.get("class").toString());
        final Map argPills = objectInfo.containsKey("constructor-args") ?
                (Map)objectInfo.get("constructor-args") :
                Maps.newHashMap();

        final List<Class<?>> classesOfArgs = getClassesOfArgs(argPills);
        Constructor<?> ctor = clazz.getConstructor(classesOfArgs.toArray(new Class<?>[0]));
        final List<Object> objectsOfArgs = getObjectsOfArgs(argPills);
        return ctor.newInstance(objectsOfArgs.toArray());
    }

    private List<Object> getObjectsOfArgs(Map<String, String> argPills) {
        return Lists.newArrayList(transform(argPills.entrySet().iterator(), new Function<Map.Entry<String, String>, Object>() {
            @Override
            public Object apply(@Nullable Map.Entry entry) {
                final Map<String, Object> pill = pillContext.getPill((String) entry.getValue());
                try {
                    return createObject(pill);
                } catch (ClassNotFoundException e) {
                } catch (InvocationTargetException e) {
                } catch (NoSuchMethodException e) {
                } catch (InstantiationException e) {
                } catch (IllegalAccessException e) {
                }
                return null;
            }
        }));
    }

    private List<Class<?>> getClassesOfArgs(Map<String, String> args) {
        return Lists.newArrayList(transform(args.entrySet().iterator(), new Function<Map.Entry<String, String>, Class<?>>() {
            @Override
            public Class<?> apply(@Nullable Map.Entry entry) {
                final Map<String, Object> pill = pillContext.getPill((String) entry.getValue());
                try {
                    return Class.forName(pill.get("class").toString());
                } catch (ClassNotFoundException e) {
                    return null;
                }
            }
        }));

    }

    public static PillBox loadContext(String path) throws FileNotFoundException {
        PillContext pillContext = new ContextLoader().getContextDefinition(path);
        return new PillBox(pillContext);

    }

}
