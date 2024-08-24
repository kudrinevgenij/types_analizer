package ru.kudrinevgeniy.detect;

import ru.kudrinevgeniy.DataType;

import java.util.Optional;

public interface DetectBy {
    Optional<DataType> get(String value);
}
