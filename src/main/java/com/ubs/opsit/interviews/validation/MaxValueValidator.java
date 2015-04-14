package com.ubs.opsit.interviews.validation;

import org.apache.commons.lang.Validate;

/**
 * Validate that the specified time value is not more than maxValue.
 * <p>
 * Created by dmgcodevil on 4/14/2015.
 */
public class MaxValueValidator implements TimeUnitValidator {

    private static final PositiveValueValidator POSITIVE_TIME_UNIT_VALIDATOR = new PositiveValueValidator();

    private int maxValue;

    public MaxValueValidator(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void validate(Integer value) throws IllegalArgumentException {
        POSITIVE_TIME_UNIT_VALIDATOR.validate(value);
        Validate.isTrue(value <= maxValue, "value must be 'less than' or 'equal to' max value:" + maxValue, value);
    }
}
