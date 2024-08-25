package ru.kudrinevgeniy.statistic;

public class ShortStatistics implements Statistics {
    private int size;

    @Override
    public void add(Number number) {
        size++;
    }

    @Override
    public String info() {
        return "Total size: " + size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }
}
