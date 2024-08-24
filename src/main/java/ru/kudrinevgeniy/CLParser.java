package ru.kudrinevgeniy;

import java.util.List;

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
        for (int i = 0; i < args.length; i++) {
            if ("-f".equals(args[i])) {
                fullStatistics = true;
            }
            if ("-a".equals(args[i])) {
                addMode = true;
            }
            if (args[i].contains(".txt")) {
                inputFiles.add(args[i]);
            }
            if ("-p".equals(args[i]) && i < args.length - 1) {
                prefix = args[i + 1];
            }
        }
    }
}
