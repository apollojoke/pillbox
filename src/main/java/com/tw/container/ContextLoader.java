package com.tw.container;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ContextLoader {

    public PillContext getContextDefinition(String path) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Map pillMap = (Map) yaml.load(new FileInputStream(path));
        return new PillContext(pillMap);
    }
}
