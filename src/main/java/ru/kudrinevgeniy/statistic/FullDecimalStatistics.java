package ru.kudrinevgeniy.statistic;

import java.math.BigDecimal;

public class FullDecimalStatistics implements Statistics {
    private int size;
    private BigDecimal min = new BigDecimal(0);
    private BigDecimal max = new BigDecimal(0);
    private BigDecimal average = new BigDecimal(0);
    private BigDecimal sum = new BigDecimal(0);

    @Override
    public void add(Object value) {
        size++;
        sum = sum.add((BigDecimal) value);
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
        return sum.equals(0);
    }
}
