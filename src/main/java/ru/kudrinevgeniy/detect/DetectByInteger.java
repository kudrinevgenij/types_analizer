package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.util.Optional;

public class DetectByInteger implements DetectBy {
    @Override
    public Optional<DataType> get(String value) {
        Integer data;
        try {
            data = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            data = null;
        }
        return data == null ? Optional.empty() : Optional.of(new DataType(DataType.Types.INTEGER, data));
    }
}
