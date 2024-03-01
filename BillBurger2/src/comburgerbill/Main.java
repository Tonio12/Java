package comburgerbill;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("basic", "goat",  5.99, "white roll");
        System.out.println("Total  Price is "+hamburger.itemizeHamburger());
        hamburger.addHamburgerAddition1("sausage",  0.50);
        hamburger.addHamburgerAddition2("Coke", 1.50);
        hamburger.addHamburgerAddition3("Chips", 2.00);
        System.out.println("Total  Price is "+hamburger.itemizeHamburger());
        System.out.println("-".repeat(30));

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition3("Should not do this", 50.53);
        System.out.printf("Total Deluxe Burger price is %.2f%n", db.itemizeHamburger());
        System.out.println("-".repeat(30));

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
    }
}
