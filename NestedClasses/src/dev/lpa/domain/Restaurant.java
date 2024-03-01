package dev.lpa.domain;

import dev.lpa.burger.Meal;

public class Restaurant {
    public static void main(String[] args) {
        var myMeal = new Meal();

        myMeal.addToppings("pickle", "cheese", "onion", "cheese", "tomatoes");
        System.out.println(myMeal);
    }
}
