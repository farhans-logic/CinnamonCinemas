package org.cinnamoncinemas.exeptions;

public class IncorrectNumberOfSeatsException extends Exception {
    public IncorrectNumberOfSeatsException(int maxSeats) {
        super("Invalid order: Only a max Number of " + maxSeats + " seats can be booked");
    }
}