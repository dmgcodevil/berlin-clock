package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link SecondToLampMapper}.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class SecondToLampMapperTest {

    private SecondToLampMapper secondToLampMapper = new SecondToLampMapper();

    @Test
    public void apply_given0Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 0;
        // when
        String lamp = secondToLampMapper.apply(seconds);
        // then
        assertEquals(Lamp.YELLOW.getShortcut(), lamp);
    }


    @Test
    public void apply_given1Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 1;
        // when
        String lamp = secondToLampMapper.apply(seconds);
        // then
        assertEquals(Lamp.OFF.getShortcut(), lamp);
    }


    @Test
    public void apply_given59Seconds_shouldReturnCorrespondingLamps() {
        // given
        int seconds = 59;
        // when
        String lamp = secondToLampMapper.apply(seconds);
        // then
        assertEquals(Lamp.OFF.getShortcut(), lamp);
    }
}
