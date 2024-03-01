public class SideItem {
    private String type;

    private double  basePrice = 5.0;

    public SideItem(String type){
        this.type = type;
    }

    public SideItem(String type, double basePrice) {
        this.type = type;
        this.basePrice  = basePrice;
    }

    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
