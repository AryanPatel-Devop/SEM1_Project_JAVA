package TryingPackages.Model;


public class User {
    public String username, password;
    public boolean booked = false;
    public double amount = 0;

    public boolean hotelBooked = false;
    public String hotelName;
    public String stayType;
    public int stayCount;
    public double hotelAmount;

    public User(String u, String p) {
        username = u;
        password = p;
    }
}
