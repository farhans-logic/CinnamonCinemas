package org.cinnamoncinemas;

import org.cinnamoncinemas.cinemamanager.CinemaManager;
import org.cinnamoncinemas.exeptions.IncorrectNumberOfSeatsException;
import org.cinnamoncinemas.exeptions.LowAvailableSeatingException;
import org.cinnamoncinemas.exeptions.NoAvailableSeatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private CinemaManager cinemaManager;

    @BeforeEach
    void setUp() {
        cinemaManager = new CinemaManager();
    }

    @Test
    void bookSeats_ValidNumberOfSeats_ReturnsBookedSeats() throws Exception {
        String bookedSeats = cinemaManager.bookSeats(3);
        assertNotNull(bookedSeats);
    }

    @Test
    void bookSeats_InvalidNumberOfSeats_ThrowsIncorrectNumberOfSeatsException() {
        assertThrows(IncorrectNumberOfSeatsException.class, () -> {
            cinemaManager.bookSeats(0);
        });
    }

    @Test
    void bookSeats_LowAvailableSeating_ThrowsLowAvailableSeatingException() throws Exception {
        for (int i = 0; i < 7; i++) {
            cinemaManager.bookSeats(2);
        }
        assertThrows(LowAvailableSeatingException.class, () -> {
            cinemaManager.bookSeats(2);
        });
    }

    @Test
    void bookSeats_NoAvailableSeating_ThrowsNoAvailableSeatingException() throws Exception {
        for (int i = 0; i < 5; i++) {
            cinemaManager.bookSeats(3);
        }

        assertThrows(NoAvailableSeatingException.class, () -> {
            cinemaManager.bookSeats(1);
        });
    }

    @Test
    void getAvailableSeats_InitialSeats_ReturnsAvailableSeats() {
        int expected = 15;

        int availableSeats = cinemaManager.getAvailableSeats();

        assertEquals(expected, availableSeats);
    }

    @Test
    void getAvailableSeats_AllSeatsBooked_ReturnsZero() throws Exception {
        int expected = 0;

        for (int i = 0; i < 5; i++) {
            cinemaManager.bookSeats(3);
        }
        int availableSeats = cinemaManager.getAvailableSeats();

        assertEquals(expected, availableSeats);
    }
}