package ru.kudrinevgeniy.statistic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FullIntegerStatisticsTest {
    @Test
    public void when3Integers() {
        long[] input = new long[] {
                45,
                100500,
                1234567890123456789L
        };
        Statistics statistics = new FullIntegerStatistics();
        for (long el : input) {
            statistics.add(el);
        }
        assertThat(statistics.isEmpty()).isFalse();
        assertThat(statistics.info()).isEqualTo(
                "Total size: 3" + System.lineSeparator()
                        + "Total sum: 1234567890123557334" + System.lineSeparator()
                        + "Min: 45" + System.lineSeparator()
                        + "Max: 1234567890123456789" + System.lineSeparator());
    }
}