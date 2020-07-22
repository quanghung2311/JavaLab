package JLP0023;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        int choice = 0;
        do {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                
                case 1:
                    Manager.createFruit(lf);
                    break;
                    
                case 2:
                    Manager.viewOrder(ht);
                    break;
                    
                case 3:
                    Manager.shopping(lf, ht);
                    break;
                    
                case 4:
                    return;
                    default: System.out.println("Enter 1, 2, 3 and 4 only!!");
            }
        } while (choice <= 4);
    }
}
