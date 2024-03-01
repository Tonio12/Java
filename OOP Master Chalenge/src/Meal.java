public class Meal {
    private Burger  burger;
    private Drink drink;
    private SideItem sideItem;

    public Meal() {
        burger =  new Burger();
        drink = new Drink("Coke",  "medium");
        sideItem = new SideItem("fries");
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem){
        this.sideItem = sideItem;
        this.burger = burger;
        this.drink = drink;
    }

    public void orderMeal(){
        System.out.println("Order");
        System.out.println("-".repeat(20));
        System.out.printf("Burger Type: %s%n", burger.getBurgerType());
        System.out.printf("Drink : %s%n", drink.getType());
        System.out.printf("Side : %s%n", sideItem.getType());
        System.out.printf("Total Cost : $%.2f%n", getPrice());
        System.out.println("-".repeat(20));

    }

    private double getPrice(){
        double burgerPrice = burger.getBasePrice();
        double drinkPrice = drink.getPrice();
        double sidePrice = sideItem.getBasePrice();
        return (burgerPrice + drinkPrice +  sidePrice);
    }
}
