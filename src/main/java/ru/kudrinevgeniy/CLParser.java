package ru.kudrinevgeniy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CLParser {
    private final String[] args;
    private boolean addMode = false;
    private boolean fullStatistics = false;
    private boolean shortStatistics = false;
    private String resultPath;
    private String prefix;
    private List<String> inputFiles = new ArrayList<>();

    public CLParser(String[] args) {
        this.args = args;
    }
    public boolean hasResultPath() {
        return !resultPath.isEmpty();
    }
    public boolean isAddMode() {
        return addMode;
    }
    public boolean isShortStatistic() {
        return shortStatistic;
    }
    public boolean isFullStatistic() {
        return fullStatistic;
    }
    public boolean hasPrefix() {
        return prefix != null;
    }
    public String getPrefix() {
        return prefix;
    }
    public String getResultPath() {
        return resultPath;
    }
    public List<String> getInputFiles() {
        return inputFiles;
    }

    public boolean parse() {
        List<String> list = (List.of(args));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String arg = iterator.next();
            if ("-f".equals(arg)) {
                fullStatistics = true;
            } else if ("-s".equals(arg)) {
                shortStatistics = true;
            }
            if ("-a".equals(arg)) {
                addMode = true;
            }
            if ("-o".equals(arg)) {
                resultPath = iterator.next();
                iterator.next();
            }
            if ("-p".equals(arg)) {
                prefix = iterator.next();
            }
            if (arg.contains(".txt")) {
                inputFiles.add(arg);
            }
        }
        return checkIsParsing();
    }

    boolean checkIsParsing() {
        boolean isParsing = true;
        if (inputFiles.isEmpty()) {
            System.out.println("Командная строка неверна, нет входных данных");
            isParsing = false;
        }

        if (prefix.contains(".txt")) {
            prefix = "";
            System.out.println("Пропущен префикс выходных файлов");
            isParsing = false;
        }
        return isParsing;
    }
}
