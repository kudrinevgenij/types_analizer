package ru.kudrinevgeniy.receive;

import ru.kudrinevgeniy.DataType;

public interface ReceiveByType {
    boolean isGoodFor(DataType data);
    void proceed(DataType data);
}
