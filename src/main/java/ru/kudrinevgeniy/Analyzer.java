package ru.kudrinevgeniy;

import ru.kudrinevgeniy.detect.DetectByDouble;
import ru.kudrinevgeniy.detect.DetectByInteger;
import ru.kudrinevgeniy.detect.DetectByString;
import ru.kudrinevgeniy.receive.ReceiveByDouble;
import ru.kudrinevgeniy.receive.ReceiveByInteger;
import ru.kudrinevgeniy.receive.ReceiveByString;
import ru.kudrinevgeniy.receive.ReceiveByType;
import ru.kudrinevgeniy.statistic.FullDoubleStatistics;
import ru.kudrinevgeniy.statistic.FullIntegerStatistics;
import ru.kudrinevgeniy.statistic.FullStringStatistics;
import ru.kudrinevgeniy.statistic.ShortStatistics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final CLParser parser;
    private final List<ReceiveByType> receiveByTypes;
    private final TypeDetect detect;

    public Analyzer(CLParser parser, List<ReceiveByType> receiveByTypes, TypeDetect detect) {
        this.parser = parser;
        this.receiveByTypes = receiveByTypes;
        this.detect = detect;
    }

    public Analyzer init() {
        var it = receiveByTypes.iterator();
        while (it.hasNext()) {
            boolean success = it.next().init(parser.isAddMode());
            if (!success) {
                it.remove();
            }
        }
        return this;
    }

    public Analyzer load(List<String> files) {
        for (String file : files) {
            var source = new File(file);
            if (!source.exists()) {
                System.out.println("File doesn't exist: " + source.getAbsolutePath());
                continue;
            }
            System.out.println("Analyze: " + source.getAbsolutePath());
            try (var input = new BufferedReader(new FileReader(source))) {
                input.lines()
                        .map(detect::of)
                        .forEach(data -> receiveByTypes
                                .forEach(receiveByType -> {
                                    if (receiveByType.isGoodFor(data)) {
                                        receiveByType.proceed(data);
                                    }
                                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void cleanResources() {
        for (ReceiveByType receiveByType : receiveByTypes) {
            receiveByType.destroy();
        }
    }

    public static void main(String[] args) {
        var parser = new CLParser(args);
        parser.parse();
        if (!parser.description().isEmpty()) {
            System.out.println("Invalid args:");
            for (String message : parser.description()) {
                System.out.println(message);
            }
            return;
        }
        var intStat = parser.isShortStatistic() ? new ShortStatistics() : new FullIntegerStatistics();
        var doubleStat = parser.isShortStatistic() ? new ShortStatistics() : new FullDoubleStatistics();
        var stringStat = parser.isShortStatistic() ? new ShortStatistics() : new FullStringStatistics();
        new Analyzer(
                parser,
                new ArrayList<>(
                        List.of(new ReceiveByInteger(parser.getResultPath(), parser.getPrefix(), intStat),
                        new ReceiveByDouble(parser.getResultPath(), parser.getPrefix(), doubleStat),
                        new ReceiveByString(parser.getResultPath(), parser.getPrefix(), stringStat
                        ))),
                new TypeDetect(
                        List.of(new DetectByInteger(),
                                new DetectByDouble(),
                                new DetectByString())
                )
        ).init()
                .load(parser.getInputFiles())
                .cleanResources();
    }
}
