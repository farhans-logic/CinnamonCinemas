package org.cinnamoncinemas;

import org.cinnamoncinemas.cinemamanager.CinemaManager;
import org.cinnamoncinemas.exeptions.IncorrectNumberOfSeatsException;
import org.cinnamoncinemas.exeptions.LowAvailableSeatingException;
import org.cinnamoncinemas.exeptions.NoAvailableSeatingException;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        CinemaManager cinemaManager = new CinemaManager();
        int customerCounter = 1;
        Random randomCustomer = new Random();
        boolean bookingsOpen = true;

        while (bookingsOpen) {
            try {
                int randomCustomerBooking =
                        randomCustomer.nextInt(5) + 1;
                System.out.println();
                System.out.println("Customer " + customerCounter +
                        " requests " + randomCustomerBooking + " seat(s).");
                customerCounter++;
                System.out.println("Allocated the customer seat(s): "
                        + cinemaManager.bookSeats(randomCustomerBooking));
                System.out.println("The cinema has " + cinemaManager.getAvailableSeats()
                        + " free seat(s) remianing");
            } catch (IncorrectNumberOfSeatsException ie) {
                System.out.println(ie.getMessage());
            } catch (LowAvailableSeatingException le) {
                System.out.println(le.getMessage());
                System.out.println("Only "
                        + cinemaManager.getAvailableSeats() + " available for booking.");
            } catch (NoAvailableSeatingException ne) {
                System.out.println(ne.getMessage());
                System.out.println("Bookings have now closed.");
                break;
            } finally {
                bookingsOpen = cinemaManager.getAvailableSeats() > -1;
            }
        }

    }
}
