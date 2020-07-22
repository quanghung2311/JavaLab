package JSP0059;

import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Manager man = new Manager();
        int choice = 0;
        do {
            System.out.println("========== File Processing =========");
            System.out.println("1. Find person info.");
            System.out.println("2. Copy Text to new file.");
            System.out.println("3. Exit.");
            System.out.println("Enter your choice: ");
            choice = Validation.checkInputPositiveInt();
            switch (choice) {
                case 1:
                    man.search();
                    break;
                case 2:
                    man.CoppyFile();
                    break;
                case 3:
                    return;
            }
        } while (true);

    }
}
