package org.cinnamoncinemas;

import java.util.List;

public class CinemaManager {
    private final String CINEMA_NAME = "Cinnamon Cinemas";
    private final int MAX_ROWS = 3;
    private final int MAX_ROW_SEATS = 5;
    private final Cinema cinema;
    private final SeatAllocator seatAllocator;

    public CinemaManager() {
        cinema = new Cinema(CINEMA_NAME, MAX_ROWS, MAX_ROW_SEATS);
        seatAllocator = new SeatAllocator(cinema.getRows(), cinema.getRowSeats());
    }

    public String bookSeats(int numberOfSeats) throws Exception {
        List<String> bookedSeats;
        bookedSeats = seatAllocator.allocateSeats(numberOfSeats);
        return showBookedSeats(bookedSeats);
    }

    public int getAvailableSeats(){
        return seatAllocator.getAvailableSeatCount();
    }

    public String showBookedSeats(List<String> bookedSeats) {
        return String.join(" ", bookedSeats);
    }

    public int getMaxSeatingCapacity() {
        return cinema.getMaxSeats();
    }
}
