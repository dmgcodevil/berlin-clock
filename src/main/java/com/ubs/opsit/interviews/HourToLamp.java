package com.ubs.opsit.interviews;

import java.util.stream.Stream;

import static com.ubs.opsit.interviews.Lamp.off;
import static com.ubs.opsit.interviews.Lamp.red;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

/**
 * Converts hours to lamps.
 *
 * Created by dmgcodevil on 4/13/2015.
 */
public class HourToLamp implements TimeUnitToLampMapper {

    /**
     * Converts the given hours into two lines.
     * The first, uppermost row consists of 4 red lights, whereby each of these lights stands for 5 full hours.
     * The 4 red lights in the second row display one full hour apiece.
     *
     * @param hours the hours
     * @return lamps
     */
    @Override
    public String apply(Integer hours) {
        int fiveHours = hours / 5;
        int oneHour = hours % 5;
        return Stream.of(hoursLamps(fiveHours), hoursLamps(oneHour)).collect(joining(lineSeparator()));
    }

    private String hoursLamps(int hours) {
        return concat(
                range(0, hours).mapToObj(red()),
                range(hours, 4).mapToObj(off()))
                .collect(joining());
    }
}
