package ru.kudrinevgeniy.statistic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FullStringStatisticsTest {
    @Test
    public void when3Integers() {
        List<String> input = List.of(
                "Lorem ipsum dolor sit amet",
                "Пример",
                "consectetur adipiscing",
                "тестовое задание",
                "Нормальная форма числа с плавающей запятой",
                "Long"
        );
        Statistics statistics = new FullStringStatistics();
        for (String el : input) {
            statistics.add(el);
        };
        assertThat(statistics.isEmpty()).isFalse();
        assertThat(statistics.info()).isEqualTo(
                "Total size: 6" + System.lineSeparator()
                        + "Min string length: 4" + System.lineSeparator()
                        + "Max string length: 42" + System.lineSeparator());
    }
}