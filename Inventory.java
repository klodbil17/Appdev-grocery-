import java.util.*;

public class Inventory {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(String name, double price, int quantity) {
        String key = name.toLowerCase();
        if (items.containsKey(key)) {
            // Update stock if item exists
            Item existing = items.get(key);
            int newQuantity = existing.getQuantity() + quantity;
            items.put(key, new Item(existing.getName(), price, newQuantity));
            System.out.println("Updated " + existing.getName() + " stock to " + newQuantity);
        } else {
            // Add as new item
            items.put(key, new Item(name, price, quantity));
            System.out.println(name + " added to inventory.");
        }
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
