package ru.kudrinevgeniy;

public class TypeDetect {
    public static DataType of(String line) {
        DataType type = null;
        type = IntegerParser.parse(line);
        if (type == null) {
            type = DoubleParser.parse(line);
        }
        if (type == null) {
            type = DataType.STRING;
        }
        return type;
    }
}
