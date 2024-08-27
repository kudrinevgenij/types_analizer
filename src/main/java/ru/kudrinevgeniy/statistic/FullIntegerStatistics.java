package ru.kudrinevgeniy.statistic;

public class FullIntegerStatistics implements Statistics {
    private int size;
    private int sum;

    @Override
    public void add(Object value) {
        size++;
        sum += (Long) value;
    }

    @Override
    public String info() {
        var out = new StringBuilder();
        out.append("Total sum: ").append(sum).append(System.lineSeparator());
        out.append("Total size: ").append(size).append(System.lineSeparator());
        return out.toString();
    }

    @Override
    public boolean isEmpty() {
        return sum == 0;
    }
}
