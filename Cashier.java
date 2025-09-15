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
        if (cart.isEmpty()) {
            System.out.println("\nCart is empty. Nothing to checkout.");
            return;
        }

        double total = 0;
        System.out.println("\n--- Receipt ---");
        Date now = new Date();
        System.out.println("Date: " + now);
        System.out.println("-------------------------");

        for (Item item : cart) {
            double subtotal = item.getPrice() * item.getQuantity();
            System.out.printf("%d x %s PHP%.2f = PHP%.2f%n",
                    item.getQuantity(), item.getName(), item.getPrice(), subtotal);
            total += subtotal;
        }
        System.out.println("-------------------------");
        System.out.printf("TOTAL: PHP%.2f%n", total);
        System.out.println("-------------------------");
        cart.clear(); 
    }
}
