package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link SecondToLampConverter}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class SecondToLampConverterTest {

    private SecondToLampConverter secondToLampConverter = new SecondToLampConverter();

    @Test
    public void apply_given0Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 0;
        // when
        String lamp = secondToLampConverter.convert(seconds);
        // then
        assertEquals(Lamp.YELLOW.getShortcut(), lamp);
    }


    @Test
    public void apply_given1Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 1;
        // when
        String lamp = secondToLampConverter.convert(seconds);
        // then
        assertEquals(Lamp.OFF.getShortcut(), lamp);
    }


    @Test
    public void apply_given59Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 59;
        // when
        String lamp = secondToLampConverter.convert(seconds);
        // then
        assertEquals(Lamp.OFF.getShortcut(), lamp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNullShouldThrowException() {
        // given
        Integer minutes = null;

        // when
        secondToLampConverter.convert(minutes);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_givenNegativeNumberShouldThrowException() {
        // given
        int minutes = -1;

        // when
        secondToLampConverter.convert(minutes);

        // then
        // expects exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_given25MinutesShouldThrowException() {
        // given
        int minutes = 60;

        // when
        secondToLampConverter.convert(minutes);

        // then
        // expects exception
    }
}
