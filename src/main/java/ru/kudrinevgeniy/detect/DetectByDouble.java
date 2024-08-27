package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.math.BigDecimal;
import java.util.Optional;

public class DetectByDouble implements DetectBy {
    @Override
    public Optional<DataType> get(String value) {
        BigDecimal data;
        try {
            data = BigDecimal.valueOf(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            data = null;
        }
        return data == null ? Optional.empty() : Optional.of(new DataType(DataType.Types.DECIMAL, data));
    }
}