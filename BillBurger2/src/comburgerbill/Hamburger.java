package comburgerbill;

public class Hamburger {
    private String name;
    private String  meat;
    private double price;
    private  String breadRollType;
    private String  addition1Name;
    private double addition1Price;
    private String  addition2Name;
    private double addition2Price;
    private String  addition3Name;
    private double addition3Price;
    private String  addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price,  String breadRollType){
        this.name= name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.printf("%s Hamburger on a  %s with %s, price is %.2f%n", name, breadRollType, meat, price);
    }

    public void addHamburgerAddition1(String name, double price){
        this.addition1Price = price;
        this.addition1Name = name;
        System.out.printf("Added %s for and extra %.2f%n", name, price);
    }

    public void addHamburgerAddition2(String name, double price){
        this.addition2Price = price;
        this.addition2Name = name;
        System.out.printf("Added %s for and extra %.2f%n", name, price);
    }

    public void addHamburgerAddition3(String name, double price){
        this.addition3Price = price;
        this.addition3Name = name;
        System.out.printf("Added %s for and extra %.2f%n", name, price);
    }

    public void addHamburgerAddition4(String name, double price){
        this.addition4Price = price;
        this.addition4Name = name;
        System.out.printf("Added %s for and extra %.2f%n", name, price);
    }

    public double itemizeHamburger(){
        return this.price + this.addition4Price + this.addition3Price + this.addition2Price + this.addition1Price;
    }




}
