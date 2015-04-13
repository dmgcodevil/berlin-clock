package com.ubs.opsit.interviews;

import java.util.function.Function;

/**
 * Basic mapper interface to convert a time unit value into lamps.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public interface TimeUnitToLampMapper extends Function<Integer, String> {
}
