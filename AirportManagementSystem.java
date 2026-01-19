import java.util.ArrayList;
import java.util.Scanner;

// Flight Class
class Flight {
    String flightNumber, destination, airline;
    int capacity, bookedSeats;

    public Flight(String flightNumber, String destination, String airline, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.airline = airline;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public boolean bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        System.out.println("Flight: " + flightNumber + " | Destination: " + destination + 
                           " | Airline: " + airline + " | Capacity: " + capacity + 
                           " | Booked Seats: " + bookedSeats);
    }
}

// Passenger Class
class Passenger {
    int id;
    String name, flightNumber;

    public Passenger(int id, String name, String flightNumber) {
        this.id = id;
        this.name = name;
        this.flightNumber = flightNumber;
    }

    public void display() {
        System.out.println("Passenger ID: " + id + " | Name: " + name + " | Flight: " + flightNumber);
    }
}

// Airline Class
class Airline {
    String name, code;

    public Airline(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void display() {
        System.out.println("Airline: " + name + " | Code: " + code);
    }
}

// Main Class for Airport Management System
public class AirportManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static ArrayList<Airline> airlines = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Airport Management System =====");
            System.out.println("1. Add Flight");
            System.out.println("2. Add Passenger");
            System.out.println("3. Add Airline");
            System.out.println("4. View Flights");
            System.out.println("5. View Passengers");
            System.out.println("6. View Airlines");
            System.out.println("7. Search Flight");
            System.out.println("8. Book Flight");
            System.out.println("9. View Ticket");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    addPassenger();
                    break;
                case 3:
                    addAirline();
                    break;
                case 4:
                    viewFlights();
                    break;
                case 5:
                    viewPassengers();
                    break;
                case 6:
                    viewAirlines();
                    break;
                case 7:
                    searchFlight();
                    break;
                case 8:
                    bookFlight();
                    break;
                case 9:
                    viewTicket();
                    break;
                case 10:
                    System.out.println("Exiting system. Safe travels! ");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        } while (choice != 10);
    }

    // Method to add a Flight
    public static void addFlight() {
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Airline: ");
        String airline = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();

        flights.add(new Flight(flightNumber, destination, airline, capacity));
        System.out.println("Flight added successfully!");
    }

    // Method to add a Passenger
    public static void addPassenger() {
        System.out.print("Enter Passenger ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();

        passengers.add(new Passenger(id, name, flightNumber));
        System.out.println("Passenger added successfully!");
    }

    // Method to add an Airline
    public static void addAirline() {
        System.out.print("Enter Airline Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Airline Code: ");
        String code = scanner.nextLine();

        airlines.add(new Airline(name, code));
        System.out.println("Airline added successfully!");
    }

    // Method to view Flights
    public static void viewFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available!");
        } else {
            System.out.println("\n===  Flight Records ===");
            for (Flight f : flights) {
                f.display();
                System.out.println("-----------------------");
            }
        }
    }

    // Method to view Passengers
    public static void viewPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers found!");
        } else {
            System.out.println("\n=== 🧑‍✈️ Passenger Records ===");
            for (Passenger p : passengers) {
                p.display();
                System.out.println("-----------------------");
            }
        }
    }

    // Method to view Airlines
    public static void viewAirlines() {
        if (airlines.isEmpty()) {
            System.out.println("No airlines found!");
        } else {
            System.out.println("\n=== Airline Records ===");
            for (Airline a : airlines) {
                a.display();
                System.out.println("-----------------------");
            }
        }
    }

    // Method to Search a Flight by Destination
    public static void searchFlight() {
        System.out.print("Enter destination to search: ");
        String destination = scanner.nextLine();
        boolean found = false;

        for (Flight f : flights) {
            if (f.destination.equalsIgnoreCase(destination)) {
                f.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found for this destination.");
        }
    }

    // Method to Book a Flight
    public static void bookFlight() {
        System.out.print("Enter Flight Number to book: ");
        String flightNumber = scanner.nextLine();

        for (Flight f : flights) {
            if (f.flightNumber.equalsIgnoreCase(flightNumber)) {
                if (f.bookSeat()) {
                    System.out.println("Seat booked successfully on Flight: " + flightNumber);
                } else {
                    System.out.println("Sorry, the flight is fully booked!");
                }
                return;
            }
        }
        System.out.println("Flight not found!");
    }

    // Method to View a Passenger's Ticket
    public static void viewTicket() {
        System.out.print("Enter Passenger ID to view ticket: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Passenger p : passengers) {
            if (p.id == id) {
                System.out.println("\n===  Passenger Ticket ===");
                p.display();
                return;
            }
        }
        System.out.println("Passenger not found!");
    }
}
