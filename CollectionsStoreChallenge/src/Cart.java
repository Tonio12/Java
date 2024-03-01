import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    enum CartType {PHYSICAL, VIRTUAL};
    private static int last_id =  1;
    private int id;
    private Map<String, Integer> products;

    private LocalDate date;

    private CartType type;

    public Cart(CartType type, int days) {
        this.type = type;
        this.id = last_id++;
        this.date = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }

    public Cart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCartDate() {
        return date;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void addItem(InventoryItem item, Integer quantity){
        this.products.merge(item.getProduct().sku(), quantity, Integer::sum);

        if(!item.reserveItem(quantity)){
            System.out.println("Ouch, something went wrong, could not add item");
        }
    }

    public void removeItem(InventoryItem item, int quantity){
        int current = products.get(item.getProduct().sku());
        if(current <= quantity){
            quantity = current;
            products.remove(item.getProduct().sku());
            System.out.printf("Item [%s] removed from basket%n",
                    item.getProduct().name());
        }else{
            products.merge(item.getProduct().sku(), quantity,
                    (oldVal, newVal) -> oldVal - newVal);
            System.out.printf("%d [%s]s removed%n",quantity,item.getProduct().name());
        }
        item.releaseItem(quantity);
    }

    public void printSalesSlip(Map<String, InventoryItem> inventory){
        double total = 0;
        System.out.println("-".repeat(30));
        for(var cartItem : products.entrySet()){
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            double itemizedPrice = (item.getPrice()*qty);
            total += itemizedPrice;
            System.out.printf("\t%s %-10s (%d)@ $%.2f = %.2f5n",
                    cartItem.getKey(),item.getProduct().name(), qty, item.getPrice(), itemizedPrice);
        }
        System.out.printf("Total Sale: $%.2f%n", total);
        System.out.println("-".repeat(30));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return id == cart.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}