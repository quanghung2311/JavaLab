package JSP0054;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Contact> lc = new ArrayList<>();
        Manager man = new Manager();
        int choice = 0;
        do {
            System.out.println("=======Contact Program=======");
            System.out.println("1. Add a contact.");
            System.out.println("2. Display all contact.");
            System.out.println("3. Delete a contact.");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                
                case 1:
                    man.createContact(lc);
                    break;

                case 2:
                    man.printAllContact(lc);
                    break;

                case 3:
                    man.deleteContactd(lc);
                    break;

                case 4:
                    break;
                    default: System.out.println("Enter 1,2,3 and 4 only!!");
            }
        } while (choice <= 4);

    }
}
