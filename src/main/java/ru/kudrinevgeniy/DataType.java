package ru.kudrinevgeniy;

public record DataType(Types type, Object value) {
    public enum Types {
        INTEGER,
        DECIMAL,
        STRING;
    }
}