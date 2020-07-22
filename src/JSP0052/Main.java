
package JSP0052;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */

public class Main {

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArrayList<Country> list = new ArrayList<>();
        ManageEastAsiaCountries man = new ManageEastAsiaCountries();
        int choice = 0;
        do {   
            System.out.println("===============================MENU==================================");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending");
            System.out.println("5. Exit");
            System.out.println("======================================================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    man.addCountry(list);
                    break;
                case 2:
                    man.displayCountry(list);
                    break;
                case 3:
                    man.searchByName(list);
                    break;
                case 4:
                    man.printCountrySorted(list);
                    break;
                case 5:
                    return;
                    default: System.out.println("Enter 1,2,3,4 and 5 only!!");
            }
        } while (choice <= 5);
    }
}
