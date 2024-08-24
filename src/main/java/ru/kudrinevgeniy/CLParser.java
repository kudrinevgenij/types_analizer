package ru.kudrinevgeniy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CLParser {
    private final String[] args;
    private boolean addMode = false;
    private boolean fullStatistics = false;
    private List<String> resultPaths;
    private String prefix = "";
    private List<String> inputFiles = new ArrayList<>();
    boolean isPassed = true;

    public CLParser(String[] args) {
        this.args = args;
    }

    public boolean isAddMode() {
        return addMode;
    }

    public boolean isFullStatistics() {
        return fullStatistics;
    }

    public boolean hasPrefix() {

        return !prefix.isEmpty();
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void parse() {
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
        checkIsPassing();
    }

    void checkIsPassing() {
        if (inputFiles.isEmpty()) {
            System.out.println("Командная строка неверна, нет входных данных");
            isPassed = false;
        }

        if (prefix.contains(".txt")) {
            prefix = "";
            System.out.println("Пропущен префикс выходных файлов");
            isPassed = false;
        }
    }
}
