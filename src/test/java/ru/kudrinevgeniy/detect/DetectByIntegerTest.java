package ru.kudrinevgeniy.detect;

import org.junit.jupiter.api.Test;
import ru.kudrinevgeniy.DataType;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class DetectByIntegerTest {
    @Test
    public void when100500() {
        String input = "100500";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.INTEGER, 100500L));
        Optional<DataType> result = new DetectByInteger().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }
    @Test
    public void when1234567890123456789() {
        String input = "1234567890123456789";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.INTEGER, 1234567890123456789L));
        Optional<DataType> result = new DetectByInteger().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }

    @Test
    public void whenString() {
        String input = "123456789012345678S";
        Optional<DataType> expected = Optional.empty();
        Optional<DataType> result = new DetectByInteger().get(input);
        assertThat(result).isEqualTo(expected);
    }
}