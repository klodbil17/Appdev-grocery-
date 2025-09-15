import java.util.*;

public class Cashier {
    private List<Item> cart = new ArrayList<>();

    public void addToCart(Item item, int quantity) {
        if (item != null && item.getQuantity() >= quantity) {
            item.reduceQuantity(quantity);
            cart.add(new Item(item.getName(), item.getPrice(), quantity));
            System.out.println(quantity + " x " + item.getName() + " added to cart.");
        } else {
            System.out.println("Item unavailable or insufficient stock.");
        }
    }

    public void checkout() {
        double total = 0;
        System.out.println("\n--- Receipt ---");
        for (Item item : cart) {
            double subtotal = item.getPrice() * item.getQuantity();
            System.out.printf("%d x %s @ PHP%.2f = PHP%.2f%n",
                    item.getQuantity(), item.getName(), item.getPrice(), subtotal);
            total += subtotal;
        }
        System.out.println("TOTAL: PHP" + total);
        cart.clear();
    }
}
