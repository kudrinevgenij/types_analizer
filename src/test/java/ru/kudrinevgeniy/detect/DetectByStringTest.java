package ru.kudrinevgeniy.detect;

import org.junit.jupiter.api.Test;
import ru.kudrinevgeniy.DataType;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class DetectByStringTest {
    @Test
    public void whenString() {
        String input = "тестовое задание";
        Optional<DataType> expected = Optional.of(new DataType(DataType.Types.STRING, "тестовое задание"));
        Optional<DataType> result = new DetectByString().get(input);
        assertThat(result.get()).isEqualTo(expected.get());
    }

    @Test
    public void whenEmpty() {
        String input = null;
        Optional<DataType> expected = Optional.empty();
        Optional<DataType> result = new DetectByInteger().get(input);
        assertThat(result).isEqualTo(expected);
    }
}