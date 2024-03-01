package comburgerbill;

public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat,  double price){
        super("Healthy Burger", meat, price, "Brown rye roll");
    }

    public void addHealthyAddition1(String name,  double price){
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
        System.out.printf("Added %s for an extra %.2f%n", name, price);
    }

    public void addHealthyAddition2(String name,  double price){
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
        System.out.printf("Added %s for an extra %.2f%n", name, price);
    }

    public double itemizeHamburger(){
        double  price = super.itemizeHamburger() +  healthyExtra1Price + healthyExtra2Price;
        System.out.printf("Total  Healthy Burger price is %.2f%n", price);
        return price;
    }
}
