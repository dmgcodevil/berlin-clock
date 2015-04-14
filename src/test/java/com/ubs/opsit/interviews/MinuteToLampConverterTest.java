package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link MinuteToLampConverter}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class MinuteToLampConverterTest {

    private static final int TOP_MINUTE_ROW = 0;
    private static final int BOTTOM_MINUTE_ROW = 1;

    private MinuteToLampConverter minuteToLampConverter = new MinuteToLampConverter();

    @Test
    public void apply_given0MinutesShouldReturnCorrespondingFiveMinutesLamps() {
        // given
        int minutes = 0;
        String lampsFiveMinutes = "OOOOOOOOOOO";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[TOP_MINUTE_ROW]);
    }

    @Test
    public void apply_given0MinutesShouldReturnCorrespondingLeftMinutesLamps() {
        // given
        int minutes = 0;
        String lampsLeftMinutes = "OOOO";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftMinutes, lamps[BOTTOM_MINUTE_ROW]);
    }

    @Test
    public void apply_given17MinutesShouldReturnCorrespondingFiveMinutesLamps() {
        // given
        int minutes = 17;
        String lampsFiveMinutes = "YYROOOOOOOO";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[TOP_MINUTE_ROW]);
    }

    @Test
    public void apply_given17MinutesShouldReturnCorrespondingLeftMinutesLamps() {
        // given
        int minutes = 17;
        String lampsLeftMinutes = "YYOO";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftMinutes, lamps[BOTTOM_MINUTE_ROW]);
    }

    @Test
    public void apply_given59MinutesShouldReturnCorrespondingFiveMinutesLamps() {
        // given
        int minutes = 59;
        String lampsFiveMinutes = "YYRYYRYYRYY";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[TOP_MINUTE_ROW]);
    }

    @Test
    public void apply_given59MinutesShouldReturnCorrespondingLeftMinutesLamps() {
        // given
        int minutes = 59;
        String lampsLeftMinutes = "YYYY";

        // when
        String[] lamps = minuteToLampConverter.convert(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsLeftMinutes, lamps[BOTTOM_MINUTE_ROW]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNullShouldThrowException() {
        // given
        Integer minutes = null;

        // when
        minuteToLampConverter.convert(minutes);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNegativeNumberShouldThrowException() {
        // given
        int minutes = -1;

        // when
        minuteToLampConverter.convert(minutes);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_given60MinutesShouldThrowException() {
        // given
        int minutes = 60;

        // when
        minuteToLampConverter.convert(minutes);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_given120MinutesShouldThrowException() {
        // given
        int minutes = 120;

        // when
        minuteToLampConverter.convert(minutes);

        // then
        // expects exception
    }

}
