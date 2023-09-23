### Project Design

1. **App Class** (Main Class):
    - The entry point of the application.
    - Creates an instance of `CinemaManager` to manage seat bookings.
    - Uses a `Random` generator to simulate customer requests.
    - Handles exceptions for incorrect seat numbers and low seat availability.
    - Loops until there are no available seats.

2. **CinemaManager Class**:
    - Manages cinema-related operations.
    - Contains a `Cinema` and a `SeatAllocator`.
    - Provides methods for booking seats, checking available seats, and displaying booked seats.

3. **Cinema Class**:
    - Represents the cinema.
    - Stores cinema name, number of rows, number of seats per row, and provides a method to calculate the maximum
      seating capacity.

4. **SeatAllocator Class**:
    - Manages seat allocation.
    - Stores available seats and allocates seats based on customer requests.
    - Throws exceptions for incorrect seat numbers and low seat availability.

5. **Exception Classes**:
    - Custom exception classes for handling different error scenarios.

### UML Class Diagram

UML class diagram:

```plaintext
            +--------------------------------+
            |            App                 |
            +--------------------------------+
            | - main(String[] args)          |
            +--------------------------------+
                     |
                     |
                     v
            +--------------------------------+
            |     CinemaManager              |
            +--------------------------------+
            | - cinema: Cinema               |
            | - seatAllocator: SeatAllocator |
            +--------------------------------+
            | + bookSeats(int numberOfSeats) |
            | + getAvailableSeats()          |
            | + showBookedSeats(...)         |
            | + getMaxSeatingCapacity()      |
            +--------------------------------+
                     |
                     |
          +----------+-------------+
          |                        |
          v                        v
+-----------------+         +--------------------------------+
|     Cinema      |         |  SeatAllocator                 |
+-----------------+         +--------------------------------+
| - name: String  |         | - availableSeats: List<String> |
| - rows: int     |         | - setAvailableSeats(...)       |
| - rowSeats: int |         | - allocateSeats(...)           |
| + getMaxSeats() |         | + getAvailableSeatCount()      |
+-----------------+         +--------------------------------+

           |
           |
           v
+-------------------------------------------------+
| IncorrectNumberOfSeatsException                 |
+-------------------------------------------------+
| + IncorrectNumberOfSeatsException(int maxSeats) |
+-------------------------------------------------+

+---------------------------------+
| LowAvailableSeatingException    |
+---------------------------------+
| + LowAvailableSeatingException()|
+---------------------------------+

+--------------------------------+
| NoAvailableSeatingException    |
+--------------------------------+
| + NoAvailableSeatingException()|
+--------------------------------+
```
