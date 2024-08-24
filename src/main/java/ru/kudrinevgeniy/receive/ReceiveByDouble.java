package ru.kudrinevgeniy.receive;

import ru.kudrinevgeniy.DataType;

import java.io.PrintWriter;

public class ReceiveByDouble implements ReceiveByType {
    private final PrintWriter writer;

    public ReceiveByDouble(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public boolean isGoodFor(DataType data) {
        return data.type() == DataType.Types.DOUBLE;
    }

    @Override
    public void proceed(DataType data) {
        writer.println(data.value());
    }
}
