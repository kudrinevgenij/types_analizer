package ru.kudrinevgeniy;

public record DataType(Types type, String value) {
    public enum Types {
        INTEGER,
        DOUBLE,
        STRING;
    }
}
