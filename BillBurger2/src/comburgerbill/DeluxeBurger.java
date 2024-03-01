package comburgerbill;

public class DeluxeBurger extends Hamburger{
    public DeluxeBurger(){
        super("DeluxeBurger", "Sausage", 19.10, "White roll");
        System.out.println("Added Chips for an extra 2.75");
        System.out.println("Added Drinks for an extra 1.81");
    }

    public void addHamburgerAddition1(String n, double p){
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    public void addHamburgerAddition2(String n, double p){
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    public void addHamburgerAddition3(String n, double p){
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    public void addHamburgerAddition4(String n, double p){
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

}
