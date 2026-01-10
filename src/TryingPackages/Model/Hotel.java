package TryingPackages.Model;


public class Hotel {
    public String name;
    public double dayPrice;
    public double nightPrice;

    public Hotel(String name, double dayPrice, double nightPrice) {
        this.name = name;
        this.dayPrice = dayPrice;
        this.nightPrice = nightPrice;
    }

    public void show() {
        System.out.println(name + " | Day ₹" + dayPrice + " | Night ₹" + nightPrice);
    }
}

