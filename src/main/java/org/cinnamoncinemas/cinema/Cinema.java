package org.cinnamoncinemas.cinema;

public class Cinema {

    private final String name;

    private final int rows;

    private final int rowSeats;

    public Cinema(String name, int rows, int rowSeats) {
        this.name = name;
        this.rows = rows;
        this.rowSeats = rowSeats;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getRowSeats() {
        return rowSeats;
    }

    public int getMaxSeats() {
        return rows * rowSeats;
    }
}
