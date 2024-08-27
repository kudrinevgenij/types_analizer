package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.math.BigInteger;
import java.util.Optional;

public class DetectByInteger implements DetectBy {
    @Override
    public Optional<DataType> get(String value) {
        Long data;
        try {
            data = Long.parseLong(value);
        } catch (NumberFormatException e) {
            data = null;
        }
        return data == null ? Optional.empty() : Optional.of(new DataType(DataType.Types.INTEGER, data));
    }
}
