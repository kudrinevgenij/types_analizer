package ru.kudrinevgeniy.statistic;

public class FullDoubleStatistics implements Statistics {
    private int size;
    private double sum;

    @Override
    public void add(Object value) {
        size++;
        sum += (Double) value;
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
