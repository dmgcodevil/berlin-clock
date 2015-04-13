package com.ubs.opsit.interviews.validation;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * A validator to validate time in 24-Hour format.
 * <p/>
 * Created by dmgcodevil on 4/13/2015.
 */
public class TimeValidator {

    /**
     * Time in 24-Hour Format Regular Expression Pattern.
     * <pre>
     * 1st Capturing group
     * (
     *  [01]?[0-9]          - [01]? match a single character present in the list below. Quantifier: ? Between zero and one time
     *                        [0-9] a single character in the range between 0 and 9
     *  |                   - or
     *  2[0-4]              - Alternative: 2 matches the character 2 literally, [0-4] - a single character in the range between 0 and 4
     *  )
     *  :                   - delimiter
     *  [0-5][0-9]          - first number must be in the range between 0 and 5, a second one in the range between 0 and 9
     *  :                   - delimiter
     *  [0-5][0-9]
     *
     * </pre>
     */
    public static final String TIME_FORMAT_REGEXP = "([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";

    private static final Pattern PATTERN = Pattern.compile(TIME_FORMAT_REGEXP);

    public static boolean isValid(String time) {
        return !StringUtils.isBlank(time) && PATTERN.matcher(time).matches();
    }
}
