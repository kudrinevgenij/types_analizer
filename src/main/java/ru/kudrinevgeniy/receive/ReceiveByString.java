package ru.kudrinevgeniy.receive;

import ru.kudrinevgeniy.DataType;

import java.io.PrintWriter;

public class ReceiveByString implements ReceiveByType {
    private final PrintWriter writer;

    public ReceiveByString(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public boolean isGoodFor(DataType data) {
        return data.type() == DataType.Types.STRING;
    }

    @Override
    public void proceed(DataType data) {
        writer.println(data.value());
    }
}
