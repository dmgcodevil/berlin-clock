package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.validation.TimeValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

/**
 * Implementation of {@link TimeConverter} interface.
 *
 * Created by dmgcodevil on 4/13/2015.
 */
public class TimeConverterImpl implements TimeConverter {

    private static final Map<Integer, TimeUnitToLampMapper> LAMP_MAPPERS;

    private static final int HOURS_IDX = 0;
    private static final int MINUTES_IDX = 1;
    private static final int SECONDS_IDX = 2;

    static {
        LAMP_MAPPERS = new HashMap<>();
        LAMP_MAPPERS.put(HOURS_IDX, new HourToLamp());
        LAMP_MAPPERS.put(MINUTES_IDX, new MinuteToLamp());
        LAMP_MAPPERS.put(SECONDS_IDX, new SecondToLamp());
    }

    @Override
    public String convertTime(String aTime) {
        if (!TimeValidator.isValid(aTime)) {
            throw new IllegalArgumentException("invalid time format. Expected string in 24-Hour format: hh:mm:ss. " +
                    "Regexp: " + TimeValidator.TIME_FORMAT_REGEXP);
        }
        int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();

        return IntStream.of(SECONDS_IDX, HOURS_IDX, MINUTES_IDX)
                .mapToObj(idx -> toLamp(parts, idx)).collect(joining(lineSeparator()));
    }

    private String toLamp(int[] parts, int current) {
        return LAMP_MAPPERS.get(current).apply(parts[current]);
    }
}
