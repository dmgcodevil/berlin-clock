package com.ubs.opsit.interviews;

/**
 * Basic converter interface to convert a time unit value into lamps.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public interface TimeUnitToLampConverter {

    /**
     *
     * @param time
     * @return
     * @throws IllegalArgumentException
     */
    String convert(Integer time) throws IllegalArgumentException;
}
