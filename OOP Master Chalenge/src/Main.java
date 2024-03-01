public class Main {
    public static void main(String[] args) {
        Burger hamburger = new Burger("beef burger", "cheese");
        Drink drink = new Drink("coke", "medium");
        SideItem fries = new SideItem("fries");
        Burger  allToppings  = new Burger("hamburger", true, true, true);

        Meal myMeal = new Meal();
        myMeal.orderMeal();

        Meal secondMeal = new Meal(allToppings, drink, fries);
        secondMeal.orderMeal();



    }
}
