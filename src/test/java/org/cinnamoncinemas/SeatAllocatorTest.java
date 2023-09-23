package org.cinnamoncinemas;

import org.cinnamoncinemas.cinemamanager.SeatAllocator;
import org.cinnamoncinemas.exeptions.IncorrectNumberOfSeatsException;
import org.cinnamoncinemas.exeptions.LowAvailableSeatingException;
import org.cinnamoncinemas.exeptions.NoAvailableSeatingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeatAllocatorTest {

    private SeatAllocator seatAllocator;

    @BeforeEach
    void setUp() {
        seatAllocator = new SeatAllocator(3, 5);
    }

    @AfterEach
    void destroy() {
        seatAllocator = null;
    }

    @Test
    void allocateSeats_MaxSeats_Success() throws Exception {

        List<String> allocatedSeats = seatAllocator.allocateSeats(3);

        assertEquals(3, allocatedSeats.size());
        assertEquals(12, seatAllocator.getAvailableSeatCount());
    }

    @Test
    void allocateSeats_SingleSeat_Success() throws Exception {

        List<String> allocatedSeats = seatAllocator.allocateSeats(1);

        assertEquals(1, allocatedSeats.size());
        assertEquals(14, seatAllocator.getAvailableSeatCount());
    }

    @Test
    void allocateSeats_InvalidNumberOfSeatsBelowMin_ThrowsIncorrectNumberOfSeatsException() {

        assertThrows(
                IncorrectNumberOfSeatsException.class,
                () -> seatAllocator.allocateSeats(0));
    }

    @Test
    void allocateSeats_InvalidNumberOfSeatsAboveMax_ThrowsIncorrectNumberOfSeatsException() {

        assertThrows(IncorrectNumberOfSeatsException.class, () -> {
            seatAllocator.allocateSeats(7);
        });
    }

    @Test
    void allocateSeats_InvalidNumberOfSeats_ThrowsIncorrectNumberOfSeatsException() {
        String expected = "Invalid order: Only a max Number of 3 seats can be booked";

        IncorrectNumberOfSeatsException thrown = assertThrows(
                IncorrectNumberOfSeatsException.class,
                () -> seatAllocator.allocateSeats(4));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void allocateSeats_AllSeats_Success() throws Exception {

        List<String> allocatedSeats = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            allocatedSeats.addAll(seatAllocator.allocateSeats(3));
        }

        assertEquals(15, allocatedSeats.size());
        assertEquals(0, seatAllocator.getAvailableSeatCount());
    }

    @Test
    void allocateSeats_NoAvailableSeating_ThrowsNoAvailableSeatingException() throws Exception {

        String expected = "Invalid Order: No seats are available for booking.";

        for (int i = 0; i < 5; i++) {
            seatAllocator.allocateSeats(3);
        }

        NoAvailableSeatingException thrown = assertThrows(
                NoAvailableSeatingException.class,
                () -> seatAllocator.allocateSeats(1));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void allocateSeats_LowAvailableSeating_ThrowsLowAvailableSeatingException() throws Exception {

        String expected = "Invalid Order: Not enough seats are available for this order";

        for (int i = 0; i < 7; i++) {
            seatAllocator.allocateSeats(2);
        }

        LowAvailableSeatingException thrown = assertThrows(
                LowAvailableSeatingException.class,
                () -> seatAllocator.allocateSeats(2));

        assertTrue(thrown.getMessage().contains(expected));
    }


    @Test
    void getAvailableSeatCount_ReturnsCorrectCount() throws Exception {

        int expected = 12;
        seatAllocator.allocateSeats(3);

        assertEquals(expected, seatAllocator.getAvailableSeatCount());
    }
}