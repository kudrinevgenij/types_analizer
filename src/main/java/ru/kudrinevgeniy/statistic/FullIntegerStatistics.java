package ru.kudrinevgeniy.statistic;

public class FullIntegerStatistics implements Statistics {
    private int size;
    private long sum;
    private long min;
    private long max;
    private long average;

    @Override
    public void add(Object value) {
        size++;
        sum += (Long) value;
    }

    @Override
    public String info() {
        var out = new StringBuilder();
        out.append("Total size: ").append(size).append(System.lineSeparator());
        out.append("Total sum: ").append(sum).append(System.lineSeparator());
        out.append("Min: ").append(min).append(System.lineSeparator());
        out.append("Max: ").append(max).append(System.lineSeparator());
        return out.toString();
    }

    @Override
    public boolean isEmpty() {
        return sum == 0;
    }
}
