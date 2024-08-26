package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.util.Optional;

public class DetectByDouble implements DetectBy {
    @Override
    public Optional<DataType> get(String value) {
        Double data;
        try {
            data = Double.valueOf(value);
        } catch (NumberFormatException e) {
            data = null;
        }
        return data == null ? Optional.empty() : Optional.of(new DataType(DataType.Types.DOUBLE, data));
    }
}
