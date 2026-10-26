package registration;

import java.util.ArrayList;

public class RegistrationManager {
    private final ArrayList<Registration> registrations = new ArrayList<>();
    private int nextId = 1;

    public Registration addRegistration(String name, String email, String group, String event) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Full name must have at least 3 characters.");
        }
        if (email == null || !isValidEmail(email.trim())) {
            throw new IllegalArgumentException("Email must contain @ with text before and after it.");
        }
        if (group == null || group.trim().isEmpty()) {
            throw new IllegalArgumentException("Student group cannot be blank.");
        }
        if (!event.equals("Web Design Workshop") && !event.equals("JavaScript Quiz") && !event.equals("IT Career Talk")) {
            throw new IllegalArgumentException("Unknown event.");
        }
        Registration registration = new Registration(nextId++, name.trim(), email.trim(), group.trim(), event);
        registrations.add(registration);
        return registration;
    }

    private boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        return at > 0 && at < email.length() - 1;
    }

    public void showAll() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }
        for (Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    public Registration findById(int id) {
        for (Registration registration : registrations) {
            if (registration.getId() == id) return registration;
        }
        return null;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < registrations.size(); i++) {
            if (registrations.get(i).getId() == id) {
                registrations.remove(i);
                return true;
            }
        }
        return false;
    }

    public void showByEvent(String event) {
        boolean found = false;
        for (Registration registration : registrations) {
            if (registration.getEventTitle().equals(event)) {
                System.out.println(registration);
                found = true;
            }
        }
        if (!found) System.out.println("No registrations for this event.");
    }
}
