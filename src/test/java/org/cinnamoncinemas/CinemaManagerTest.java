package org.cinnamoncinemas;

import org.cinnamoncinemas.cinemamanager.CinemaManager;
import org.cinnamoncinemas.exeptions.IncorrectNumberOfSeatsException;
import org.cinnamoncinemas.exeptions.LowAvailableSeatingException;
import org.cinnamoncinemas.exeptions.NoAvailableSeatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaManagerTest {

    private CinemaManager cinemaManager;

    @BeforeEach
    void setUp() {
        cinemaManager = new CinemaManager();
    }

    @Test
    void bookSeats_ReturnsBookedSeats() throws Exception {

        int numberOfSeats = 3;
        String expected = "A1 A2 A3";

        String actual = cinemaManager.bookSeats(numberOfSeats);

        assertEquals(expected, actual);
    }

    @Test
    void bookSeats_InvalidNumberOfSeats_ThrowsIncorrectNumberOfSeatsException() throws Exception {

        String expected = "Invalid order: Only a max Number of 3 seats can be booked";

        IncorrectNumberOfSeatsException thrown = assertThrows(
                IncorrectNumberOfSeatsException.class,
                () -> cinemaManager.bookSeats(4));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void bookSeats_InvalidNumberOfSeatsBelowMin_ThrowsIncorrectNumberOfSeatsException() throws Exception {

        String expected = "Invalid order: Only a max Number of 3 seats can be booked";

        IncorrectNumberOfSeatsException thrown = assertThrows(
                IncorrectNumberOfSeatsException.class,
                () -> cinemaManager.bookSeats(0));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void bookSeats_InvalidNumberOfSeatsAboveMax_ThrowsIncorrectNumberOfSeatsException() throws Exception {

        String expected = "Invalid order: Only a max Number of 3 seats can be booked";

        IncorrectNumberOfSeatsException thrown = assertThrows(
                IncorrectNumberOfSeatsException.class,
                () -> cinemaManager.bookSeats(4));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void bookSeats_NoAvailableSeating_ThrowsNoAvailableSeatingException() throws Exception {

        String expected = "Invalid Order: No seats are available for booking.";

        for (int i = 0; i < 5; i++) {
            cinemaManager.bookSeats(3);
        }

        NoAvailableSeatingException thrown = assertThrows(
                NoAvailableSeatingException.class,
                () -> cinemaManager.bookSeats(1));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void bookSeats_NoAvailableSeating_ThrowsLowAvailableSeatingException() throws Exception {

        String expected = "Invalid Order: Not enough seats are available for this order";

        for (int i = 0; i < 7; i++) {
            cinemaManager.bookSeats(2);
        }

        LowAvailableSeatingException thrown = assertThrows(
                LowAvailableSeatingException.class,
                () -> cinemaManager.bookSeats(2));

        assertTrue(thrown.getMessage().contains(expected));
    }

    @Test
    void getAvailableSeats_ReturnsCorrectAvailableSeats() {

        int expected = 15;

        int actual = cinemaManager.getAvailableSeats();

        assertEquals(expected, actual);
    }

    @Test
    void getMaxSeatingCapacity_ReturnsCorrectMaxSeatingCapacity() {

        int expected = 15;

        int actual = cinemaManager.getMaxSeatingCapacity();

        assertEquals(expected, actual);
    }
}