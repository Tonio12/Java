package dev.lpa.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular",  5.99);
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    public void addToppings(String... toppings){
        for(var top : toppings){
            if(top.equalsIgnoreCase("pickle")){
                burger.toppings.add(new Item(top, "Topping", 2.0));
            }else if(top.equalsIgnoreCase("cheese")){
                burger.toppings.add(new Item(top, "Topping", 3.0));
            }
                else{
                burger.toppings.add(new Item(top, "Topping", 0));
            }
        }

    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total Due: ", getTotal());
    }

    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }


        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item {
        private List<Item>  toppings = new ArrayList<>();

        public Burger(){
            super("Regular", "Burger", 5.99);
        }

        public Burger(String name, double price) {
            super(name, "burger", price);
        }
        public double getPrice(){
            double toppingPrice = 0;
            for (var topping : toppings){
                toppingPrice += topping.price;
            }
            return super.price + toppingPrice;
        }

        @Override
        public String toString() {
            StringBuilder itemized = new StringBuilder(super.toString());
            for(Item topping: toppings){
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }
}
