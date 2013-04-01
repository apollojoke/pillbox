package com.tw.container;

import org.yaml.snakeyaml.Yaml;

import java.util.List;

public class ContextLoader {
    public static List getContextDefinition(String path) {
        Yaml yaml = new Yaml();
        String document = "- id: aspirin\n  class: example.Aspirin\n- id: vitamin\n" +
                "  class: example.Vitamin\n";
        List pillMap = (List) yaml.load(document);
        System.out.println(pillMap);
        return pillMap;
    }
}
