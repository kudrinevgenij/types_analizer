package ru.kudrinevgeniy;

import ru.kudrinevgeniy.detect.DetectBy;

import java.util.List;

public class TypeDetect {
    private final List<DetectBy> detects;

    public TypeDetect(List<DetectBy> detects) {
        this.detects = detects;
    }

    public DataType of(String line) {
        for (DetectBy detect : detects) {
                var result = detect.get(line);
            if (result.isPresent()) {
                return result.get();
            }
        }
        return new DataType(DataType.Types.STRING, line);
    }
}
