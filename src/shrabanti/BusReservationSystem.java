
package shrabanti;

import java.util.ArrayList;
import java.util.Scanner;


public class BusReservationSystem {
    ArrayList<Bus> availableBuses = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public void reserveBus() {
        System.out.println("Enter Departure City:");
        String departureCity = scanner.nextLine();

        System.out.println("Enter Destination City:");
        String destinationCity = scanner.nextLine();

        System.out.println("Enter Date:");
        String date = scanner.nextLine();

        System.out.println("Enter Number of Passengers:");
        int numberOfPassengers = scanner.nextInt();

        // Assume buses are available based on user input
        Bus bus = new Bus(departureCity, destinationCity, date, 50);
        availableBuses.add(bus);

        // Reserve seats
        if (bus.availableSeats >= numberOfPassengers) {
            bus.availableSeats -= numberOfPassengers;
            System.out.println("Reservation Successful!");
            Reservation reservation = new Reservation("John Doe", departureCity, destinationCity, date, numberOfPassengers);
            reservations.add(reservation);
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    public void viewReservations() {
        System.out.println("Your Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Passenger: " + reservation.passengerName +
                    ", From: " + reservation.departureCity +
                    ", To: " + reservation.destinationCity +
                    ", Date: " + reservation.date +
                    ", Passengers: " + reservation.numberOfPassengers);
        }
    }

    public void advice() {
        System.out.println("For advice, please contact: +1234567890");
    }
       ArrayList<User> users = new ArrayList<>();
    User currentUser = null;

    public void registerUser() {
        System.out.println("Enter your desired username:");
        String username = scanner.nextLine();

        // Check if the username is already taken
        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("Username already taken. Please choose another one.");
                return;
            }
        }

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Create a new user
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful! You can now log in.");
    }

    public void login() {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Login failed. Invalid username or password.");
    }

    // Modify displayMenu to handle login and registration
    public void displayMenu() {
        if (currentUser == null) {
            System.out.println("Welcome to BUSRESERVE. Please log in or register.");
            System.out.println("1. Log in");
            System.out.println("2. Register");
        } else {
            System.out.println("Welcome, " + currentUser.username + "!");
            System.out.println("1. Reserve a Bus");
            System.out.println("2. View Reservations");
            System.out.println("3. Advice");
            System.out.println("4. Log out");
            System.out.println("5. Exit");
        }
    }

    // Modify main to handle login and registration
    public void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    if (currentUser == null) {
                        login();
                    } else {
                        reserveBus();
                    }
                    break;
                case 2:
                    if (currentUser == null) {
                        registerUser();
                    } else {
                        viewReservations();
                    }
                    break;
                case 3:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                    } else {
                        advice();
                    }
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("Exiting...");
                        System.exit(0);
                    } else {
                        // Logout
                        currentUser = null;
                        System.out.println("Logout successful!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

   
}

