package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.util.Optional;

public class DetectByString implements DetectBy {
    @Override
    public Optional<DataType> get(String value) {
        return Optional.of(new DataType(DataType.Types.STRING, value));
    }
}
