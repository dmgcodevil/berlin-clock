package com.ubs.opsit.interviews.validation;

import org.apache.commons.lang.Validate;

/**
 * Validate that the specified time value is positive number.
 * <p>
 * Created by dmgcodevil on 4/14/2015.
 */
public class PositiveValueValidator implements TimeUnitValidator {
    private static final NotNullValidator NOT_NULL_VALIDATOR = new NotNullValidator();

    @Override
    public void validate(Integer value) throws IllegalArgumentException {
        NOT_NULL_VALIDATOR.validate(value);
        Validate.isTrue(value >= 0, "value should be positive number: gt 0", value);
    }
}
