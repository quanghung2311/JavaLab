package jlp0021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class JLP0021 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentList m = new StudentList();

        int choice = 0;
        do {
            System.out.println("WELCOM TO STUDENT MANAGEMENT");
            System.out.println("1. Creat");
            System.out.println("2. Find and Sort ");
            System.out.println("3. Update or Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    m.Creat();
                    m.output();
                    break;

                case 2:
                    m.findAndSort();
                    break;

                case 3:
                    m.updateAndDelete();
                    break;

                case 4:
                    m.Report();
                    break;

                case 5:
                    break;
                    default: System.out.println("Input 1,2,3,4 and 5 only!!");

            }

        } while (choice <= 5);
    }
}
