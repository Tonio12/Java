import java.util.Objects;

public class Burger {
    private String burgerType;
    private double basePrice=20;

    private boolean cheeseTopping;
    private boolean pickleTopping;
    private  boolean baconTopping;

    public  Burger(){
        this.burgerType = "regular";
        this.baconTopping = false;
        this.pickleTopping = false;
        this.cheeseTopping = false;
    }

    public Burger(String burgerType, double basePrice) {
        this.burgerType = burgerType;
        this.basePrice = basePrice;
    }

    public Burger(String burgerType, String topping){
        this.burgerType = burgerType;
        if(Objects.equals(topping, "cheese")){
            this.basePrice  +=  5;
            cheeseTopping = true;
        }
        if(Objects.equals(topping, "pickle") ){
            this.basePrice += 5;
            pickleTopping = true;
        }

        if(Objects.equals(topping, "bacon")){
            this.basePrice += 5;
            baconTopping = true;
        }
    }

    public Burger(String burgerType,String topping1, String topping2){
        this.burgerType = burgerType;
        if(Objects.equals(topping1, "cheese")){
            this.basePrice  +=  5;
            cheeseTopping = true;
        }
        if(Objects.equals(topping1, "pickle") ){
            this.basePrice += 5;
            pickleTopping = true;
        }

        if(Objects.equals(topping1, "bacon")){
            this.basePrice += 5;
            baconTopping = true;
        }
        if(Objects.equals(topping2, "cheese")){
            this.basePrice  +=  5;
            cheeseTopping = true;
        }
        if(Objects.equals(topping2, "pickle") ){
            this.basePrice += 5;
            pickleTopping = true;
        }

        if(Objects.equals(topping2, "bacon")){
            this.basePrice += 5;
            baconTopping = true;
        }
    }

    public Burger(String burgerType, boolean cheeseTopping, boolean pickleTopping, boolean baconTopping) {
        this.burgerType = burgerType;
        this.cheeseTopping = cheeseTopping;
        this.pickleTopping = pickleTopping;
        this.baconTopping = baconTopping;

        if(this.cheeseTopping){
            this.basePrice += 5;
        }
        if(this.pickleTopping){
            this.basePrice += 5;
        }
        if(this.baconTopping){
            this.basePrice += 5;
        }
    }

    public String getBurgerType() {
        return burgerType;
    }

    public double getBasePrice() {
        return basePrice;
    }

}
