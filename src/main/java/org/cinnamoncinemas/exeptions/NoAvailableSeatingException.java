package org.cinnamoncinemas.exeptions;

public class NoAvailableSeatingException extends Exception {
    private static final String ERROR_MESSAGE = "Invalid Order: No seats are available for booking.";

    public NoAvailableSeatingException() {
        super(ERROR_MESSAGE);
    }
}
