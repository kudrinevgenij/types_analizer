package ru.kudrinevgeniy.statistic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kudrinevgeniy.CLParser;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FullDecimalStatisticsTest {
    @Test
    public void when3Decimals() {
        List<BigDecimal> input = List.of(
                new BigDecimal(String.valueOf(3.1415)),
                new BigDecimal(String.valueOf(-0.001)),
                new BigDecimal(String.valueOf(1.528535047E-25))
        );
        Statistics statistics = new FullDecimalStatistics();
        for (BigDecimal el : input) {
            statistics.add(el);
        };
        assertThat(statistics.isEmpty()).isFalse();
        assertThat(statistics.info()).isEqualTo(
                "Total size: 3" + System.lineSeparator()
                + "Total sum: 3.1405000000000000000000001528535047" + System.lineSeparator()
                + "Min: -0.001" + System.lineSeparator()
                + "Max: 3.1415" + System.lineSeparator());
    }
}