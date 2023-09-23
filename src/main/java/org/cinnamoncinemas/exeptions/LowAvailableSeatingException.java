package org.cinnamoncinemas.exeptions;

public class LowAvailableSeatingException extends Exception {

    public LowAvailableSeatingException() {
        super("Invalid Order: Not enough seats are available for this order");
    }
}
