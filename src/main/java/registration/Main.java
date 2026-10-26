package registration;

import java.util.Scanner;

public class Main {
    private static final String[] EVENTS = {
        "Web Design Workshop", "JavaScript Quiz", "IT Career Talk"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationManager manager = new RegistrationManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Event Registration ===");
            System.out.println("1. Add registration");
            System.out.println("2. Show all registrations");
            System.out.println("3. Find registration by ID");
            System.out.println("4. Delete registration by ID");
            System.out.println("5. Show registrations for an event");
            System.out.println("0. Exit");
            int option = readNumber(scanner, "Choose an option: ");

            switch (option) {
                case 1:
                    add(scanner, manager);
                    break;
                case 2:
                    manager.showAll();
                    break;
                case 3:
                    Registration found = manager.findById(readNumber(scanner, "Enter ID: "));
                    System.out.println(found == null ? "Registration not found." : found);
                    break;
                case 4:
                    boolean deleted = manager.deleteById(readNumber(scanner, "Enter ID: "));
                    System.out.println(deleted ? "Registration deleted." : "Registration not found.");
                    break;
                case 5:
                    String event = chooseEvent(scanner);
                    if (event != null) manager.showByEvent(event);
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Unknown menu option.");
            }
        }
        scanner.close();
    }

    private static void add(Scanner scanner, RegistrationManager manager) {
        System.out.print("Full name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Student group: ");
        String group = scanner.nextLine();
        String event = chooseEvent(scanner);
        if (event == null) return;
        try {
            Registration registration = manager.addRegistration(name, email, group, event);
            System.out.println("Registration created. ID: " + registration.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid registration: " + e.getMessage());
        }
    }

    private static String chooseEvent(Scanner scanner) {
        System.out.println("Available events:");
        for (int i = 0; i < EVENTS.length; i++) {
            System.out.println((i + 1) + ". " + EVENTS[i]);
        }
        int number = readNumber(scanner, "Select event (1-3): ");
        if (number < 1 || number > EVENTS.length) {
            System.out.println("Invalid event choice. Choose 1, 2 or 3.");
            return null;
        }
        return EVENTS[number - 1];
    }

    private static int readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter digits.");
            return -1;
        }
    }
}
