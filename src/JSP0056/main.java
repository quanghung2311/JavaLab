package JSP0056;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Worker> lw = new ArrayList<>();
        ArrayList<History> lh = new ArrayList<>();
        Manager man = new Manager();
        int choice = 0;
        do {
            System.out.println("");
            System.out.println("============Worker Management==========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display information salary");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                
                case 1:
                    man.addWorker(lw);
                    break;

                case 2:
                    man.changeSalary(lw, lh, 1);
                    break;

                case 3:
                    man.changeSalary(lw, lh, 2);
                    break;

                case 4:
                    man.printListHistory(lh);
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Enter 1, 2, 3, 4 and 5 only!!");
            }

        } while (choice <= 5);
    }
}
