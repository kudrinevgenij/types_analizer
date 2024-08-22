package ru.kudrinevgeniy;

public class DoubleParser {
    public static DataType parse(String line) {
        DataType type = DataType.STRING;
        try {
            Double.parseDouble(line);
            type = DataType.DOUBLE;
        } catch (NumberFormatException e) {

        }
        return type;
    }
}
