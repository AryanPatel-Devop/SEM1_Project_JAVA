package TryingPackages.Model;


public class Transport extends Route {
    public String type;
    public double price;

    public Transport(String from, String to, String type, double price) {
        super(from, to);
        this.type = type;
        this.price = price;
    }

    public void showTransport() {
        System.out.println(fromCity + " → " + toCity + " | " + type + " | ₹" + price);
    }
}

