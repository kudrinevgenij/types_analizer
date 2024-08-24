package ru.kudrinevgeniy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CLParser {
    private final String[] args;
    boolean addMode = false;
    boolean fullStatistics = false;
    List<String> resultPaths;
    String prefix = "";
    List<String> inputFiles;

    public CLParser(String[] args) {
        this.args = args;
    }

    public void parseSwitch(String[] args) {
        List<String> list = (List.of(args));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if ("-f".equals(arg)) {
                fullStatistics = true;
            }
            if ("-a".equals(arg)) {
                addMode = true;
            }
            if ("-p".equals(arg)) {
                prefix = iterator.next();
            }
            if (arg.contains(".txt")) {
                inputFiles.add(arg);
            }
        }
    }
}
