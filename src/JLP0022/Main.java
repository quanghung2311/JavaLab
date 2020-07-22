package JLP0022;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        ArrayList<Candidate> candidate = new ArrayList<>();
        CandidateManagement man = new CandidateManagement();
        int choice = 0;
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                   
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                    default: System.out.println("Enter 1,2,3,4 and 5 only!!");
            }
        } while (choice <= 5);
    }
}
