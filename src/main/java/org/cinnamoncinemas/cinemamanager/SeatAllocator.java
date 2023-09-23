package org.cinnamoncinemas.cinemamanager;

import org.cinnamoncinemas.exeptions.IncorrectNumberOfSeatsException;
import org.cinnamoncinemas.exeptions.LowAvailableSeatingException;
import org.cinnamoncinemas.exeptions.NoAvailableSeatingException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeatAllocator {

    private final char MIN_ROW = 'A';

    private final int MIN_SEAT_ALLOCATION = 1;

    private final int MAX_SEAT_ALLOCATION = 3;

    private List<String> availableSeats;

    public SeatAllocator(int maxRows, int maxRowSeats) {
        setAvailableSeats(maxRows, maxRowSeats);
    }

    public void setAvailableSeats(int maxRows, int maxRowSeats) {
        availableSeats = IntStream.rangeClosed(MIN_ROW, MIN_ROW + maxRows - 1)
                .mapToObj(row -> IntStream.rangeClosed(1, maxRowSeats)
                        .mapToObj(seat -> String.valueOf((char) row) + seat))
                .flatMap(seatsInRow -> seatsInRow)
                .collect(Collectors.toList());
    }

    public List<String> allocateSeats(int numberOfSeats) throws Exception {

        if (numberOfSeats < MIN_SEAT_ALLOCATION || numberOfSeats > MAX_SEAT_ALLOCATION) {
            throw new IncorrectNumberOfSeatsException(MAX_SEAT_ALLOCATION);
        }

        if (availableSeats.isEmpty()) {
            throw new NoAvailableSeatingException();
        }

        if (availableSeats.size() < MAX_SEAT_ALLOCATION) {
            throw new LowAvailableSeatingException();
        }



        List<String> allocatedSeats = availableSeats.stream()
                .limit(numberOfSeats)
                .collect(Collectors.toList());

        availableSeats.removeAll(allocatedSeats);

        return allocatedSeats;
    }

    public int getAvailableSeatCount() {
        return availableSeats.size();
    }

}
