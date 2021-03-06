package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.validation.MaxValueValidator;

import java.util.stream.Stream;

import static com.ubs.opsit.interviews.Lamp.off;
import static com.ubs.opsit.interviews.Lamp.red;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

/**
 * Converts hours to lamps.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class HourToLampConverter implements TimeUnitToLampConverter {

    private static final MaxValueValidator MAX_VALUE_VALIDATOR = new MaxValueValidator(24);
    private static final int ELAPSED_HOURS = 5;

    /**
     * Converts the given hours into two lines.
     * The first, uppermost row consists of 4 red lights, whereby each of these lights stands for 5 full hours.
     * The 4 red lights in the second row display one full hour apiece.
     *
     * @param hours the hours
     * @return lamps
     */
    @Override
    public String convert(Integer hours) throws IllegalArgumentException {
        MAX_VALUE_VALIDATOR.validate(hours);
        int fiveHours = hours / ELAPSED_HOURS;
        int oneHour = hours % ELAPSED_HOURS;
        return Stream.of(hoursLamps(fiveHours), hoursLamps(oneHour)).collect(joining(lineSeparator()));
    }

    private String hoursLamps(int hours) {
        int totalLamsInRow = 4;
        return concat(
                range(0, hours).mapToObj(red()),
                range(hours, totalLamsInRow).mapToObj(off()))
                .collect(joining());
    }
}
