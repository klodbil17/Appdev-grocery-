import java.util.*;

public class Inventory {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(String name, double price, int quantity) {
        items.put(name.toLowerCase(), new Item(name, price, quantity));
    }

    public Item getItem(String name) {
        return items.get(name.toLowerCase());
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            System.out.println("\n--- Inventory ---");
            for (Item item : items.values()) {
                System.out.println(item);
            }
        }
    }
}