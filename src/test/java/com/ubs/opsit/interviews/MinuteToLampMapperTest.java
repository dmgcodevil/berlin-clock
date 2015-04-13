package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link MinuteToLampMapper}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class MinuteToLampMapperTest {

    private MinuteToLampMapper minuteToLampMapper = new MinuteToLampMapper();

    @Test
    public void apply_given0MinutesShouldReturnCorrespondingLamps() {
        // given
        int minutes = 0;
        String lampsFiveMinutes = "OOOOOOOOOOO";
        String lampsLeftMinutes = "OOOO";

        // when
        String[] lamps = minuteToLampMapper.apply(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[0]);
        assertEquals(lampsLeftMinutes, lamps[1]);
    }

    @Test
    public void apply_given17MinutesShouldReturnCorrespondingLamps() {
        // given
        int minutes = 17;
        String lampsFiveMinutes = "YYROOOOOOOO";
        String lampsLeftMinutes = "YYOO";

        // when
        String[] lamps = minuteToLampMapper.apply(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[0]);
        assertEquals(lampsLeftMinutes, lamps[1]);
    }

    @Test
    public void apply_given59MinutesShouldReturnCorrespondingLamps() {
        // given
        int minutes = 59;
        String lampsFiveMinutes = "YYRYYRYYRYY";
        String lampsLeftMinutes = "YYYY";

        // when
        String[] lamps = minuteToLampMapper.apply(minutes).split(System.lineSeparator());

        // then
        assertEquals(lampsFiveMinutes, lamps[0]);
        assertEquals(lampsLeftMinutes, lamps[1]);
    }

}
