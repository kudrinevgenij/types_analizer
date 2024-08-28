package ru.kudrinevgeniy.statistic;

public class FullStringStatistics implements Statistics {
    private int size;
    private int minSize;
    private int maxSize;
    @Override
    public void add(Object value) {
        String string = (String) value;
        if (string.length() < minSize || minSize == 0) {
            minSize = string.length();
        }
        if (string.length() > maxSize) {
            maxSize = string.length();
        }
        size++;
    }

    @Override
    public String info() {
        var out = new StringBuilder();
        out.append("Total size: ").append(size).append(System.lineSeparator());
        out.append("Min string length: ").append(minSize).append(System.lineSeparator());
        out.append("Max string length: ").append(maxSize).append(System.lineSeparator());
        return out.toString();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
