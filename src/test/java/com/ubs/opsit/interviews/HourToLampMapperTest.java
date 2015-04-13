package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link HourToLampMapper}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class HourToLampMapperTest {

    private HourToLampMapper hourToLampMapper = new HourToLampMapper();

    @Test
    public void apply_given0HoursShouldReturnCorrespondingLamps() {
        // given
        int hours = 0;
        String lampsFiveHours = "OOOO";
        String lampsLeftHours = "OOOO";

        // when
        String[] lamps = hourToLampMapper.apply(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[0]);
        assertEquals(lampsLeftHours, lamps[1]);
    }

    @Test
    public void apply_given13HoursShouldReturnCorrespondingLamps() {
        // given
        int hours = 13;
        String lampsFiveHours = "RROO";
        String lampsLeftHours = "RRRO";

        // when
        String[] lamps = hourToLampMapper.apply(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[0]);
        assertEquals(lampsLeftHours, lamps[1]);
    }

    @Test
    public void apply_given23HoursShouldReturnCorrespondingLamps() {
        // given
        int hours = 23;
        String lampsFiveHours = "RRRR";
        String lampsLeftHours = "RRRO";

        // when
        String[] lamps = hourToLampMapper.apply(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[0]);
        assertEquals(lampsLeftHours, lamps[1]);
    }

    @Test
    public void apply_given24HoursShouldReturnCorrespondingLamps() {
        // given
        int hours = 24;
        String lampsFiveHours = "RRRR";
        String lampsLeftHours = "RRRR";

        // when
        String[] lamps = hourToLampMapper.apply(hours).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveHours, lamps[0]);
        assertEquals(lampsLeftHours, lamps[1]);
    }

}
