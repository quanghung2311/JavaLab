package JSP0052;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Quang Hung
 */
public class ManageEastAsiaCountries {

    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int rs = Integer.parseInt(Main.sc.nextLine().trim());
                if (rs < min || rs > max) {
                    throw new NumberFormatException();

                }
                return rs;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double rs = Double.parseDouble(Main.sc.nextLine());
                return rs;
            } catch (NumberFormatException e) {
                System.err.println("Please input number double!!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkCountryExist(ArrayList<Country> list, String id) {
        for (Country country : list) {
            if (country.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static String checkInputString() {
        while (true) {
            String rs = Main.sc.nextLine().trim();
            if (rs.isEmpty()) {
                System.err.println("Not empty!!");
                System.out.print("Enter again: ");
            } else {
                return rs;
            }
        }
    }

    public static void addCountry(ArrayList<Country> list) {
        System.out.print("Enter id of country: ");
        String id = checkInputString();
        if (!checkCountryExist(list, id)) {
            System.out.print("Id already exist!!");
            return;
        }
        System.out.print("Enter name of country: ");
        String name = checkInputString();
        System.out.print("Enter total area of country: ");
        double area = checkInputDouble();
        System.out.print("Enter terrain of country: ");
        String terrain = checkInputString();
        list.add(new Country(terrain, id, name, area));
        System.err.println("Add Successfull!!");
    }

    public static void displayCountry(ArrayList<Country> list) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : list) {
            country.display();
        }
    }

    public static void printCountrySorted(ArrayList<Country> list) {
        Collections.sort(list);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : list) {
            country.display();
        }
    }

    public static void searchByName(ArrayList<Country> list) {
        System.out.print("Enter the name you want to search for: ");
        String name = checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : list) {
            if (country.getName().equalsIgnoreCase(name)) {
                country.display();
            }
        }
    }

}
