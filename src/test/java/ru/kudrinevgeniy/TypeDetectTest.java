package ru.kudrinevgeniy;

import org.junit.jupiter.api.Test;
import ru.kudrinevgeniy.detect.DetectByDecimal;
import ru.kudrinevgeniy.detect.DetectByInteger;
import ru.kudrinevgeniy.detect.DetectByString;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TypeDetectTest {
    private TypeDetect detects = new TypeDetect(
            List.of(new DetectByInteger(),
                    new DetectByDecimal(),
                    new DetectByString())
    );

    @Test
    public void whenInteger() {
        var result = detects.of("100");
        assertThat(result)
                .isEqualTo(new DataType(DataType.Types.INTEGER, 100L));
    }

    @Test
    public void whenDouble() {
        var result = detects.of("100.100");
        assertThat(result)
                .isEqualTo(new DataType(DataType.Types.DECIMAL, 100.1));
    }

    @Test
    public void whenString() {
        var result = detects.of("100$");
        assertThat(result)
                .isEqualTo(new DataType(DataType.Types.STRING, "100$"));
    }
  
}