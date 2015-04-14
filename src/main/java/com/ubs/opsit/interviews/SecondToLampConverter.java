package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.validation.MaxValueValidator;

/**
 * Converts seconds to lamp.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public class SecondToLampConverter implements TimeUnitToLampConverter {

    private static final MaxValueValidator MAX_VALUE_VALIDATOR = new MaxValueValidator(59);

    /**
     * Converts seconds to indicator line.
     * The round yellow light crowning the clock at the top is of minor significance for telling the time:
     * It blinks every second.
     *
     * @param seconds the seconds
     * @return flashing lamp
     */
    @Override
    public String convert(Integer seconds) throws IllegalArgumentException {
        MAX_VALUE_VALIDATOR.validate(seconds);
        return (seconds % 2 == 0) ? Lamp.YELLOW.getShortcut() : Lamp.OFF.getShortcut();
    }
}
