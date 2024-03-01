record Product(String sku,String name, String manufacturer, Category category){}

enum Category{PRODUCE,DAIRY,CEREAL,MEAT,BEVERAGE}
public class InventoryItem implements Comparable<InventoryItem>{
    private final Product product;
    private double price;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;

    public InventoryItem(Product product, double price, int qtyTotal, int qtyLow) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyTotal;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public boolean reserveItem(int quantity){
        if(qtyTotal  > quantity){
            qtyReserved += quantity;
            return true;
        }
        return false;
    }

    public void releaseItem(int quantity){
        qtyReserved -= quantity;
    }

    public boolean sellItem(int quantity){
        if(quantity > qtyTotal) return false;
        qtyTotal -= quantity;
        qtyReserved  -= quantity;
        if(qtyTotal <= qtyLow){
            placeInventoryOrder();
        }
        return true;
    }

    private void placeInventoryOrder(){
        System.out.printf("Ordering qty %d : %s%n", qtyReorder, product);
    }

    @Override
    public String toString() {
        return "%s, $%.2f : [%04d,% 2d]".formatted(product,price,qtyTotal,qtyReserved);
    }

    @Override
    public int compareTo(InventoryItem o) {
        return this.product.name().compareTo(o.product.name());
    }
}
