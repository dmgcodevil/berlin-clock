package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.validation.MaxValueValidator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ubs.opsit.interviews.Lamp.RED;
import static com.ubs.opsit.interviews.Lamp.YELLOW;
import static com.ubs.opsit.interviews.Lamp.off;
import static com.ubs.opsit.interviews.Lamp.yellow;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.concat;

/**
 * Converts minutes to lamps.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class MinuteToLampConverter implements TimeUnitToLampConverter {

    private static final MaxValueValidator MAX_VALUE_VALIDATOR = new MaxValueValidator(59);
    private static final int ELAPSED_MINUTES = 5;

    /**
     * The result row is composed of 11 lights: 3 red and 8 yellow. Each light in this row stands for 5 elapsed minutes.
     * The 3 red lights have been assigned to mark the quarters of an hour and are intended to make reading the clock easier.
     * Last of all, the yellow row at the very bottom displays units of single minutes.
     *
     * @param minutes the minutes to convert
     * @return result row is composed of 11 lights
     */
    @Override
    public String convert(Integer minutes) {
        MAX_VALUE_VALIDATOR.validate(minutes);
        return Stream.of(
                fiveMinutesLamps(minutes),
                oneMinuteLamps(minutes))
                .collect(joining(System.lineSeparator()));
    }


    private String fiveMinutesLamps(int minutes) {
        int fiveMinutes = minutes / ELAPSED_MINUTES;
        int totalLampsInRow = 11;
        return concat(
                rangeClosed(1, fiveMinutes).mapToObj(this::minuteToLamp),
                range(fiveMinutes, totalLampsInRow).mapToObj(off()))
                .collect(Collectors.joining());
    }

    private String oneMinuteLamps(int minutes) {
        int oneMinute = minutes % ELAPSED_MINUTES;
        int totalLampsInRow = 4;
        return concat(
                range(0, oneMinute).mapToObj(yellow()),
                range(oneMinute, totalLampsInRow).mapToObj(off()))
                .collect(joining());
    }

    /**
     * Convert minutes to lamp. The 3 red lights are assigned to mark the quarters of an hour
     * and are intended to make reading the clock easier.
     *
     * @param minutes the minutes to convert
     * @return corresponding lamp
     */
    private String minuteToLamp(int minutes) {
        return isQuarter(minutes) ? RED.getShortcut() : YELLOW.getShortcut();
    }


    private boolean isQuarter(int minutes) {
        return minutes % 3 == 0;
    }
}
