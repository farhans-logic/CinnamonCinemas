package org.cinnamoncinemas;

import org.cinnamoncinemas.cinema.Cinema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema("Cinnamon", 5, 10);
    }

    @Test
    void getName_ReturnsCorrectName() {

        String expected = "Cinnamon";

        String name = cinema.getName();

        assertEquals(expected, name);
    }

    @Test
    void getRows_ReturnsCorrectRows() {
        int expected = 5;

        int rows = cinema.getRows();

        assertEquals(expected, rows);
    }

    @Test
    void getRowSeats_ReturnsCorrectRowSeats() {
        int expected = 10;

        int rowSeats = cinema.getRowSeats();

        assertEquals(expected, rowSeats);
    }

    @Test
    void getMaxSeats_ReturnsCorrectMaxSeats() {
        int expected = 50;


        int maxSeats = cinema.getMaxSeats();

        assertEquals(expected, maxSeats);
    }
}