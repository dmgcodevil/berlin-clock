package com.ubs.opsit.interviews.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link TimeValidator}.
 */
@RunWith(Parameterized.class)
public class TimeValidatorTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // valid values
                {"00:00:00", true},
                {"13:17:01", true},
                {"23:59:59", true},
                {"24:00:00", true},
                {"10:12:15", true},
                {"06:01:02", true},
                {"19:45:09", true},
                //invalid values
                {"00:00", false},
                {"25:17:01", false},
                {"-1:59:59", false},
                {"-10:59:59", false},
                {"10:-1:59", false},
                {"bad:10:10", false},
                {"10:bad:10", false},
                {"10:10:bad", false},
                {"24:60:00", false},
                {"20:12:70", false},
                {"", false},
                {"   ", false}

        });
    }

    private String time;

    private boolean valid;

    public TimeValidatorTest(String time, boolean valid) {
        this.time = time;
        this.valid = valid;
    }

    @Test
    public void isValid_giveDifferentTimeValues_shouldReturnExpectedResult() {
        // given - see TimeValidatorTest.data()
        //when
        boolean actual = TimeValidator.isValid(time);
        //then
        assertEquals(valid, actual);
    }

}
