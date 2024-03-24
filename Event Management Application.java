import java.util.ArrayList;
import java.util.Scanner;

class Event {
    private String title;
    private String description;
    private String date;

    public Event(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event: " + title + "\nDescription: " + description + "\nDate: " + date + "\n";
    }
}

class EventManager {
    private ArrayList<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void deleteEvent(String title) {
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(title)) {
                events.remove(event);
                System.out.println("Event '" + title + "' deleted successfully.");
                return;
            }
        }
        System.out.println("Event with title '" + title + "' not found.");
    }
}

public class EventManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();

        while (true) {
            System.out.println("\nEVENT MANAGEMENT APPLICATION");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter event description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String date = scanner.nextLine();
                    eventManager.addEvent(new Event(title, description, date));
                    System.out.println("Event added successfully.");
                    break;
                case 2:
                    System.out.println("\n*** LIST OF EVENTS ***");
                    eventManager.displayEvents();
                    break;
                case 3:
                    System.out.print("Enter title of event to delete: ");
                    String eventTitle = scanner.nextLine();
                    eventManager.deleteEvent(eventTitle);
                    break;
                case 4:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
