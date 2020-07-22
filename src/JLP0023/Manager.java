package JLP0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Quang Hung
 */
public class Manager {

    public static void createFruit(ArrayList<Fruit> lf) {
        while (true) {
            System.out.println("Input fruit ID: ");
            String fruitID = Validation.checkInputString();
            if (!Validation.checkIdExist(lf, fruitID)) {
                System.err.println("ID already exist");
                return;
            }

            System.out.println("Input fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.println("Input price: ");
            double price = Validation.checkInputDouble();
            System.out.println("Input quantity: ");
            int quatity = Validation.checkInputInt();
            System.out.println("Input origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitID, fruitName, price, quatity, origin));
            if (!Validation.checkInputYN()) {
                return;
            }
        }

    }

    public static void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    public static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<Order>> ht) {
        if (lf.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            displayListFruit(lf);
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, lf.size());
            Fruit fruit = getFruitByItem(lf, item);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (!Validation.checkItemExist(lo, fruit.getFruitID())) {
                updateOrder(lo, fruit.getFruitID(), quantity);
            } else {
                lo.add(new Order(fruit.getFruitID(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayListOrder(lo);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        ht.put(name, lo);
        System.err.println("Add successfull");
    }

    public static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    public static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) { 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitID().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
