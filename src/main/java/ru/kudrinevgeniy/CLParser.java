package ru.kudrinevgeniy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CLParser {
    private final String[] args;
    private boolean addMode = false;
    private boolean fullStatistic = false;
    private boolean shortStatistic = false;
    private boolean noPrefixValue = false;
    private String resultPath = "";
    private String prefix = "";
    private List<String> inputFiles = new ArrayList<>();
    private List<String> errorsDescription = new ArrayList<>();

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
        return !prefix.isEmpty();
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
                fullStatistic = true;
            } else if ("-s".equals(arg)) {
                shortStatistic = true;
            }
            if ("-a".equals(arg)) {
                addMode = true;
            }
            if ("-o".equals(arg)) {
                if (iterator.hasNext()) {
                    resultPath = iterator.next();
                }
            }
            if ("-p".equals(arg)) {
                if (iterator.hasNext()) {
                    prefix = iterator.next();
                }
                if (prefix.contains(".txt")) {
                    inputFiles.add(arg);
                    prefix = "";
                    noPrefixValue = true;
                }
            }
            if (arg.contains(".txt")) {
                inputFiles.add(arg);
            }
        }
        return checkIsParsing();
    }

    boolean checkIsParsing() {
        boolean isParsing = true;
        if (!fullStatistic && !shortStatistic) {
            errorsDescription.add("Don't config statistic flags -s of -f.");
            isParsing = false;
        }
        if (inputFiles.isEmpty()) {
            errorsDescription.add("Don't contains input files.");
            isParsing = false;
        }
        if (noPrefixValue) {
            errorsDescription.add("Args contain the -p flag but no prefix value.");
            isParsing = false;
        }
        return isParsing;
    }

    List<String> description() {
        return errorsDescription;
    }
}
