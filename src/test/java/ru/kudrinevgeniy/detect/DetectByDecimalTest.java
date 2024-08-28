package ru.kudrinevgeniy.detect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kudrinevgeniy.CLParser;
import ru.kudrinevgeniy.DataType;
import ru.kudrinevgeniy.statistic.FullStringStatistics;
import ru.kudrinevgeniy.statistic.Statistics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class DetectByDecimalTest {
    @Test
    public void when3dot1415() {
        String input = "3.1415";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.DECIMAL, BigDecimal.valueOf(3.1415)));
        Optional<DataType> result = new DetectByDecimal().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }

    @Test
    public void whenMinus0dot001() {
        String input = "-0.001";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.DECIMAL, BigDecimal.valueOf(-0.001)));
        Optional<DataType> result = new DetectByDecimal().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }

    @Test
    public void whenBidDecimalWithE() {
        String input = "1.528535047E-25";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.DECIMAL, BigDecimal.valueOf(1.528535047E-25)));
        Optional<DataType> result = new DetectByDecimal().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }

    @Test
    public void whenString() {
        String input = "1.5S";
        Optional<DataType> expected = Optional.empty();
        Optional<DataType> result = new DetectByDecimal().get(input);
        assertThat(result).isEqualTo(expected);
    }
}