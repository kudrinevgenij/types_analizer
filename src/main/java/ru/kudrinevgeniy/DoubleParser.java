package ru.kudrinevgeniy;

public class DoubleParser {
    public static DataType parse(String line) {
        DataType type = null;
        try {
            Double.parseDouble(line);
            type = DataType.DOUBLE;
        } catch (NumberFormatException e) {

        }
        return type;
    }
}
