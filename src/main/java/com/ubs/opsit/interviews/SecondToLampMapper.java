package com.ubs.opsit.interviews;

/**
 * Converts seconds to lamp.
 *
 * Created by dmgcodevil on 4/13/2015.
 */
public class SecondToLampMapper implements TimeUnitToLampMapper {

    /**
     * Converts seconds to indicator line.
     * The round yellow light crowning the clock at the top is of minor significance for telling the time:
     * It blinks every second.
     *
     * @param seconds the seconds
     * @return flashing lamp
     */
    @Override
    public String apply(Integer seconds) {
        return (seconds % 2 == 0) ? Lamp.YELLOW.getShortcut() : Lamp.OFF.getShortcut();
    }
}
