package ru.kudrinevgeniy;

public class TypeDetect {
    public static DataTypes of(String line) {
        DataTypes type = DataTypes.STRING;
        try {
            Integer.parseInt(line);
            type = DataTypes.INTEGER;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(line);
                type = DataTypes.DOUBLE;
            } catch (NumberFormatException exception) {

            }
        }
        return type;
    }
}
