package com.ubs.opsit.interviews.validation;

/**
 * Basic validator interface to validate time value.
 * <p>
 * Created by dmgcodevil on 4/14/2015.
 */
public interface TimeUnitValidator {

    /**
     * Validate time value.
     *
     * @param value the value tio validate
     * @throws IllegalArgumentException If an argument value is deemed invalid, an IllegalArgumentException is thrown
     */
    void validate(Integer value) throws IllegalArgumentException;

}
