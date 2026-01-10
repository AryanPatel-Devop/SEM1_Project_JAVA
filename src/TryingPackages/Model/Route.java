package TryingPackages.Model;


public class Route {
    public String fromCity;
    public String toCity;

    public Route(String from, String to) {
        this.fromCity = from;
        this.toCity = to;
    }

    public void show() {
        System.out.println(fromCity + " → " + toCity);
    }
}
