package TryingPackages.MainMethod;

import TryingPackages.Model.Hotel;
import TryingPackages.Model.Route;
import TryingPackages.Model.Transport;
import TryingPackages.Model.User;
import java.util.*;

public class TravelBookingSystem {

    static Scanner sc = new Scanner(System.in);

    static Route[] routes = new Route[20];
    static Transport[] transports = new Transport[50];
    static User[] users = new User[20];
    static Hotel[] hotels = new Hotel[20];

    static int rCount = 0, tCount = 0, uCount = 0, hCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== TRAVEL BOOKING SYSTEM =====");
            System.out.println("1. User Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            switch (sc.nextInt()) {
                case 1 -> userAuth();
                case 2 -> adminLogin();
                case 3 -> System.exit(0);
            }
        }
    }

    // ================= USER AUTH =================
    static void userAuth() {
        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Back");
            System.out.print("Choice: ");

            switch (sc.nextInt()) {
                case 1 -> userLogin();
                case 2 -> signUp();
                case 3 -> {
                    return;
                }
            }
        }
    }

    static void signUp() {
        sc.nextLine();
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();
        users[uCount++] = new User(u, p);
        System.out.println("Account Created!");
    }

    static void userLogin() {
        sc.nextLine();
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        for (int i = 0; i < uCount; i++) {
            if (users[i].username.equals(u) && users[i].password.equals(p)) {
                userPanel(users[i]);
                return;
            }
        }
        System.out.println("Invalid Login!");
    }

    // ================= USER PANEL (FIXED) =================
    static void userPanel(User user) {
        while (true) {
            System.out.println("\n--- USER PANEL ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Book Hotel");
            System.out.println("3. View Combined Bill");
            System.out.println("4. Back");
            System.out.print("Choice: ");

            switch (sc.nextInt()) {
                case 1 -> bookTicket(user);
                case 2 -> bookHotel(user);
                case 3 -> viewCombinedBill(user);
                case 4 -> {
                    return;
                }
            }
        }
    }

    // ================= ADMIN LOGIN =================
    static void adminLogin() {
        sc.nextLine();
        System.out.print("Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (id.equals("admin123") && pass.equals("admin@123")) {
            adminPanel(); // FIXED: full CRUD panel
        } else {
            System.out.println("Wrong Credentials!");
        }
    }

    // ================= ADMIN PANEL (FULL CRUD) =================
    static void adminPanel() {
        while (true) {
            System.out.println("\n--- ADMIN PANEL ---");
            System.out.println("1. Add Route");
            System.out.println("2. Edit Route");
            System.out.println("3. Delete Route");
            System.out.println("4. Add Transport");
            System.out.println("5. Edit Transport");
            System.out.println("6. Delete Transport");
            System.out.println("7. Add Hotel");
            System.out.println("8. Edit Hotel");
            System.out.println("9. Delete Hotel");
            System.out.println("10. View All");
            System.out.println("11. Back");
            System.out.print("Choice: ");

            switch (sc.nextInt()) {
                case 1 -> addRoute();
                case 2 -> editRoute();
                case 3 -> deleteRoute();
                case 4 -> addTransport();
                case 5 -> editTransport();
                case 6 -> deleteTransport();
                case 7 -> addHotel();
                case 8 -> editHotel();
                case 9 -> deleteHotel();
                case 10 -> viewAll();
                case 11 -> {
                    return;
                }
            }
        }
    }

    // ================= ROUTE CRUD =================
    static void addRoute() {
        sc.nextLine();
        System.out.print("From City: ");
        String from = sc.nextLine();
        System.out.print("To City: ");
        String to = sc.nextLine();
        routes[rCount++] = new Route(from, to);
        System.out.println("Route Added!");
    }

    static void editRoute() {
        if (rCount == 0) {
            System.out.println("No Routes Found!");
            return;
        }
        for (int i = 0; i < rCount; i++) {
            System.out.print((i + 1) + ". ");
            routes[i].show();
        }
        System.out.print("Select Route: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("New From City: ");
        routes[r - 1].fromCity = sc.nextLine();
        System.out.print("New To City: ");
        routes[r - 1].toCity = sc.nextLine();
        System.out.println("Route Updated!");
    }

    static void deleteRoute() {
        if (rCount == 0) {
            System.out.println("No Routes Found!");
            return;
        }
        for (int i = 0; i < rCount; i++) {
            System.out.print((i + 1) + ". ");
            routes[i].show();
        }
        System.out.print("Select Route: ");
        int r = sc.nextInt();
        for (int i = r - 1; i < rCount - 1; i++)
            routes[i] = routes[i + 1];
        rCount--;
        System.out.println("Route Deleted!");
    }

    // ================= TRANSPORT CRUD =================
    static void addTransport() {
        if (rCount == 0) {
            System.out.println("Add route first!");
            return;
        }
        for (int i = 0; i < rCount; i++) {
            System.out.print((i + 1) + ". ");
            routes[i].show();
        }
        int r = sc.nextInt();
        Route route = routes[r - 1];
        sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        transports[tCount++] = new Transport(route.fromCity, route.toCity, type, price);
        System.out.println("Transport Added!");
    }

    static void editTransport() {
        if (tCount == 0) {
            System.out.println("No Transport Found!");
            return;
        }
        for (int i = 0; i < tCount; i++) {
            System.out.print((i + 1) + ". ");
            transports[i].showTransport();
        }
        int t = sc.nextInt();
        sc.nextLine();
        System.out.print("New Type: ");
        transports[t - 1].type = sc.nextLine();
        System.out.print("New Price: ");
        transports[t - 1].price = sc.nextDouble();
        System.out.println("Transport Updated!");
    }

    static void deleteTransport() {
        if (tCount == 0) {
            System.out.println("No Transport Found!");
            return;
        }
        for (int i = 0; i < tCount; i++) {
            System.out.print((i + 1) + ". ");
            transports[i].showTransport();
        }
        int t = sc.nextInt();
        for (int i = t - 1; i < tCount - 1; i++)
            transports[i] = transports[i + 1];
        tCount--;
        System.out.println("Transport Deleted!");
    }

    // ================= HOTEL CRUD =================
    static void addHotel() {
        sc.nextLine();
        System.out.print("Hotel Name: ");
        String name = sc.nextLine();
        System.out.print("Day Price: ");
        double day = sc.nextDouble();
        System.out.print("Night Price: ");
        double night = sc.nextDouble();
        hotels[hCount++] = new Hotel(name, day, night);
        System.out.println("Hotel Added!");
    }

    static void editHotel() {
        if (hCount == 0) {
            System.out.println("No Hotels Found!");
            return;
        }
        for (int i = 0; i < hCount; i++) {
            System.out.print((i + 1) + ". ");
            hotels[i].show();
        }
        int h = sc.nextInt();
        sc.nextLine();
        System.out.print("New Name: ");
        hotels[h - 1].name = sc.nextLine();
        System.out.print("New Day Price: ");
        hotels[h - 1].dayPrice = sc.nextDouble();
        System.out.print("New Night Price: ");
        hotels[h - 1].nightPrice = sc.nextDouble();
        System.out.println("Hotel Updated!");
    }

    static void deleteHotel() {
        if (hCount == 0) {
            System.out.println("No Hotels Found!");
            return;
        }
        for (int i = 0; i < hCount; i++) {
            System.out.print((i + 1) + ". ");
            hotels[i].show();
        }
        int h = sc.nextInt();
        for (int i = h - 1; i < hCount - 1; i++)
            hotels[i] = hotels[i + 1];
        hCount--;
        System.out.println("Hotel Deleted!");
    }

    // ================= VIEW =================
    static void viewAll() {
        System.out.println("\n--- ROUTES ---");
        for (int i = 0; i < rCount; i++)
            routes[i].show();

        System.out.println("\n--- TRANSPORTS ---");
        for (int i = 0; i < tCount; i++)
            transports[i].showTransport();

        System.out.println("\n--- HOTELS ---");
        for (int i = 0; i < hCount; i++)
            hotels[i].show();
    }

    // ================= USER FEATURES =================
    static void bookTicket(User user) {
        if (tCount == 0) {
            System.out.println("No transports available!");
            return;
        }

        System.out.println("\n--- AVAILABLE TRANSPORTS ---");
        for (int i = 0; i < tCount; i++) {
            System.out.print((i + 1) + ". ");
            transports[i].showTransport();
        }

        System.out.print("Select transport: ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > tCount) {
            System.out.println("Invalid choice!");
            return;
        }

        Transport t = transports[choice - 1];
        user.booked = true;
        user.amount = t.price;

        System.out.println("Ticket booked successfully!");
        System.out.println("Amount: ₹" + t.price);
    }

    static void bookHotel(User user) {
        if (hCount == 0) {
            System.out.println("No hotels available!");
            return;
        }

        System.out.println("\n--- AVAILABLE HOTELS ---");
        for (int i = 0; i < hCount; i++) {
            System.out.print((i + 1) + ". ");
            hotels[i].show();
        }

        System.out.print("Select hotel: ");
        int hChoice = sc.nextInt();
        sc.nextLine();

        if (hChoice < 1 || hChoice > hCount) {
            System.out.println("Invalid choice!");
            return;
        }

        Hotel h = hotels[hChoice - 1];
        user.hotelName = h.name;

        System.out.print("Stay type (day/night): ");
        user.stayType = sc.nextLine();

        System.out.print("Number of stays: ");
        user.stayCount = sc.nextInt();

        if (user.stayType.equalsIgnoreCase("day")) {
            user.hotelAmount = user.stayCount * h.dayPrice;
        } else if (user.stayType.equalsIgnoreCase("night")) {
            user.hotelAmount = user.stayCount * h.nightPrice;
        } else {
            System.out.println("Invalid stay type!");
            return;
        }

        user.hotelBooked = true;

        System.out.println("Hotel booked successfully!");
        System.out.println("Hotel Amount: ₹" + user.hotelAmount);
    }

    static void viewCombinedBill(User user) {
    double total = 0;

    System.out.println("\n===== FINAL BILL =====");

    if (user.booked) {
        System.out.println("Transport Amount: ₹" + user.amount);
        total += user.amount;
    } else {
        System.out.println("No transport booked.");
    }

    if (user.hotelBooked) {
        System.out.println("Hotel (" + user.hotelName + ") Amount: ₹" + user.hotelAmount);
        total += user.hotelAmount;
    } else {
        System.out.println("No hotel booked.");
    }

    System.out.println("----------------------");
    System.out.println("TOTAL AMOUNT: ₹" + total);
}

}
