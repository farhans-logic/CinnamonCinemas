# Cinnamon Cinemas App

Welcome to the Cinnamon Cinemas App! This Java application allows you to simulate the allocation of seats to customers in a movie theatre.

## Table of Contents

- [Introduction](#introduction)
- [Usage Instructions](#how-to-use-the-app)
- [Project Structure](#project-structure)
- [Exception Handling](#exception-handling)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Cinnamon Cinemas App is a Java application that helps movie theatre managers allocate seats to customers. It adheres to specific business requirements and follows real-world scenarios for seat allocation.

## Usage Instructions

1. Clone or download this repository to your local machine.
2. Open the project in your preferred Java development environment.
3. Run the `App` class, which contains the main method.

### How the App Functions

- The app will continuously allocate seats to customers until there are no more seats available.
- Customers orders are assigned a random number of seats between 1 and 5 to account for edge cases.
- The app will indicate if a customer books and:
  - an invalid amount if seats outwith the allowable range from 1 to 3
  - too much seating if available seating is low (less than 3 seats remaining)
  - if all seats are booked.
- The app will display the customer's request, allocated seats (if available), and the remaining free seats.

### Sample Output

```plaintext
Customer 1 requests 3 seat(s).
Allocated the customer seat(s): A1 A2 A3
The cinema has 12 free seat(s) remaining

Customer 2 requests 2 seat(s).
Allocated the customer seat(s): A4 A5
The cinema has 10 free seat(s) remaining

Customer 3 requests 4 seat(s).
Invalid order: Only a max Number of 3 seats can be booked

Customer 4 requests 1 seat(s).
Allocated the customer seat(s): B1
The cinema has 9 free seat(s) remaining

...

No seats are available for booking.
Bookings have now closed.
```

## Project Structure

The project is organized into packages:

- `org.cinnamoncinemas`: The main package containing the application's entry point and core classes.
- `org.cinnamoncinemas.cinemamanager`: Contains classes related to cinema management and seat allocation.
- `org.cinnamoncinemas.cinema`: Contains the `Cinema` class for defining cinema properties.
- `org.cinnamoncinemas.exeptions`: Contains custom exception classes for error handling.

## Exception Handling

The app handles various exceptions to ensure smooth operation. These exceptions include:

- `IncorrectNumberOfSeatsException`: Thrown when a customer requests an invalid number of seats.
- `LowAvailableSeatingException`: Thrown when there are not enough seats available for a customer's request.
- `NoAvailableSeatingException`: Thrown when there are no seats available, and bookings are closed.

## Contributing

If you'd like to contribute to the development of this app, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
