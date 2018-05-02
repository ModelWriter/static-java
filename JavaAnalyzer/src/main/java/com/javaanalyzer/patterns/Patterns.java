package com.javaanalyzer.patterns;

import java.util.HashMap;
import java.util.Map;

public class Patterns {

    public static final Map<String, String> PATTERN_MAP = new HashMap<>();

    static {
        PATTERN_MAP.put("Composite Pattern",
                "Composite" + System.lineSeparator()
                        + "Component" + System.lineSeparator()
                        + "Leaf" + System.lineSeparator()
                        + "Component in Leaf.(extends + implements)" + System.lineSeparator()
                        + "Component in Composite.(extends + implements)" + System.lineSeparator()
                        + "Component in Composite.contains" + System.lineSeparator()
                        + "!(Component in Leaf.contains)");

        PATTERN_MAP.put("Circular Dependency",
                "Class a" + System.lineSeparator() +
                        "Class b" + System.lineSeparator() +
                        "!(a = b)" + System.lineSeparator() +
                        "a in b.*(calls + contains + implements + extends)" + System.lineSeparator() +
                        "b in a.(calls + contains + implements + extends)");

        PATTERN_MAP.put("Singleton",
                "Class singleton" + System.lineSeparator() +
                        "Field field" + System.lineSeparator() +
                        "!(Public in singleton.constructors.access)" + System.lineSeparator() +
                        "field in singleton.fields" + System.lineSeparator() +
                        "True = field.static" + System.lineSeparator() +
                        "singleton = field.type");
    }

}
