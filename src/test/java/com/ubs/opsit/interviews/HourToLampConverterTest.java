package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link HourToLampConverter}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class HourToLampConverterTest {

    private static final int TOP_HOUR_ROW = 0;
    private static final int BOTTOM_HOUR_ROW = 1;

    private HourToLampConverter hourToLampConverter = new HourToLampConverter();

    @Test
    public void apply_given0HoursShouldReturnCorrespondingFiveHoursLamps() {
        // given
        int hours = 0;
        String lampsFiveHours = "OOOO";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[TOP_HOUR_ROW]);
    }

    @Test
    public void apply_given0HoursShouldReturnCorrespondingLeftHoursLamps() {
        // given
        int hours = 0;
        String lampsLeftHours = "OOOO";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftHours, lamps[BOTTOM_HOUR_ROW]);
    }

    @Test
    public void apply_given13HoursShouldReturnCorrespondingFiveHoursLamps() {
        // given
        int hours = 13;
        String lampsFiveHours = "RROO";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[TOP_HOUR_ROW]);
    }

    @Test
    public void apply_given13HoursShouldReturnCorrespondingLeftHoursLamps() {
        // given
        int hours = 13;
        String lampsLeftHours = "RRRO";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftHours, lamps[BOTTOM_HOUR_ROW]);
    }


    @Test
    public void apply_given23HoursShouldReturnCorrespondingFiveHoursLamps() {
        // given
        int hours = 23;
        String lampsFiveHours = "RRRR";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[TOP_HOUR_ROW]);

    }

    @Test
    public void apply_given23HoursShouldReturnCorrespondingLeftHoursLamps() {
        // given
        int hours = 23;
        String lampsLeftHours = "RRRO";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftHours, lamps[BOTTOM_HOUR_ROW]);
    }

    @Test
    public void apply_given24HoursShouldReturnCorrespondingFiveHoursLamps() {
        // given
        int hours = 24;
        String lampsFiveHours = "RRRR";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[TOP_HOUR_ROW]);
    }

    @Test
    public void apply_given24HoursShouldReturnCorrespondingLeftHoursLamps() {
        // given
        int hours = 24;
        String lampsLeftHours = "RRRR";

        // when
        String[] lamps = hourToLampConverter.convert(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftHours, lamps[BOTTOM_HOUR_ROW]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNullShouldThrowException() {
        // given
        Integer hours = null;

        // when
        hourToLampConverter.convert(hours);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNegativeNumberShouldThrowException() {
        // given
        int hours = -1;

        // when
        hourToLampConverter.convert(hours);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_given25HoursShouldThrowException() {
        // given
        int hours = 25;

        // when
        hourToLampConverter.convert(hours);

        // then
        // expects exception
    }

}
