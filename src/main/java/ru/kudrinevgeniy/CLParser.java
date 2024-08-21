package ru.kudrinevgeniy;

public class CLParser {
    boolean addMode = false;
    boolean fullStatistics = false;
    String resultPaths;
    String prefix;
    String[] inputFiles;
    public void parse(String[] args) {
        if ("-f".equals(args[0])) {
            fullStatistics = true;
        }
        if ("-a".equals(args[1])) {
            addMode = true;
        }
        if ("-p".equals(args[2])) {
            prefix = args[3];
        }
    }
}
