package com.javaanalyzer.patterns;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Patterns {

    public static final String PATTERNS_FILE = "patterns.txt";
    public static final Map<String, String> PATTERN_MAP = new HashMap<>();

    public static void readPatterns() {

        Thread thread = new Thread(() -> {
            try {
                FileReader fileReader =
                        new FileReader(PATTERNS_FILE);

                int read;
                boolean newPattern = true;

                String name = null;
                String pattern;

                StringBuilder sb = new StringBuilder();

                while ((read = fileReader.read()) != -1) {
                    char c = (char) read;

                    if (newPattern) {
                        if (c != '{')
                            sb.append(c);
                        else {
                            name = normalize(sb.toString());
                            sb = new StringBuilder();
                            newPattern = false;
                        }
                    }
                    else {
                        if (c != '}')
                            sb.append(c);
                        else {
                            pattern = normalize(sb.toString());
                            PATTERN_MAP.put(name, pattern);
                            sb = new StringBuilder();
                            newPattern = true;
                        }
                    }
                }
            }
            catch(IOException ignored) { }
        });
        thread.setName("Pattern Reading Thread");
        thread.start();
    }

    private static String normalize(String str) {
        return Arrays.stream(str.split(System.lineSeparator()))
                .filter(e -> !e.isEmpty())
                .map(s -> Arrays.stream(s.split("\\s"))
                        .filter(e -> !e.isEmpty())
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
