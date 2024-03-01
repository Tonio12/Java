public class Drink {
    private String type;
    private String size;

    private double basePrice;

    public Drink(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
       if (type.equalsIgnoreCase("medium")){
           basePrice = 5.0;
       }
        if (type.equalsIgnoreCase("small")){
            basePrice = 3.0;
        }
        if (type.equalsIgnoreCase("small")){
            basePrice = 7.0;
        }
        return basePrice;
    }
}
