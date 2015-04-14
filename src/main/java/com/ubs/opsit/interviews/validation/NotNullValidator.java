package com.ubs.opsit.interviews.validation;

/**
 * Validate that the specified time value is not {@code null}.
 * <p>
 * Created by dmgcodevil on 4/14/2015.
 */
public class NotNullValidator implements TimeUnitValidator {
    @Override
    public void validate(Integer value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
    }
}
