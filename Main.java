import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Cashier cashier = new Cashier();
        Scanner sc = new Scanner(System.in);

 
        inventory.addItem("Apple", 20.00, 10);
        inventory.addItem("Banana", 10.00, 15);
        inventory.addItem("Milk", 50.00, 8);

        int choice;
        do {
            System.out.println("\n===== Grocery System =====");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Add New Item to Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    inventory.listItems();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    Item item = inventory.getItem(name);
                    cashier.addToCart(item, qty);
                    break;
                case 3:
                    cashier.checkout();
                    break;
                case 4:
                    System.out.print("Enter new item name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    inventory.addItem(newName, price, quantity);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
