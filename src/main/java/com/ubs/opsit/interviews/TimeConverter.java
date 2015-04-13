package com.ubs.opsit.interviews;

public interface TimeConverter {


    /**
     * Converts time string to Berlin Clock representation.
     *
     * @param aTime the time to convert
     * @return Berlin Clock representation of the given time
     * @throws IllegalArgumentException if the given time is {@code null}, empty, blank or has invalid format.
     *                                  see {@link com.ubs.opsit.interviews.validation.TimeValidator}
     */
    String convertTime(String aTime) throws IllegalArgumentException;

}
