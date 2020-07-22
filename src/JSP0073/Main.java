package JSP0073;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final String DATE_VALID = "^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$";

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputDate() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.matches(DATE_VALID)) {
                    return result;
                } else {
                    System.err.println("Please input format(01-Nov-2000)");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Please input string!");
            } else {
                return result;
            }

        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Please input number!");
            }
        }
    }

    public static void addExpense(ArrayList<Expenses> list, int id) {
        System.out.println("--------Add an expense-------");
        System.out.print("Enter Date: ");
        String date = checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = checkInputDouble();
        System.out.print("Enter Content: ");
        String content = checkInputString();
        list.add(new Expenses(id, date, amount, content));
    }

    public static void displayExpense(ArrayList<Expenses> list) {
        System.out.println("--------Display all expenses-------");
        if (list.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", list.get(i).getId(), list.get(i).getDate(),
                    list.get(i).getAmount(), list.get(i).getContent());
            total += list.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    public static int checkIdExist(ArrayList<Expenses> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteExpense(ArrayList<Expenses> list) {
        System.out.println("----------Delete an expense-----------");
        System.out.print("Enter id: ");
        int id = checkInputInt();
        int checkIdExist = checkIdExist(list, id);
        if (checkIdExist != -1) {
            list.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    public static void main(String[] args) {
        ArrayList<Expenses> list = new ArrayList<>();
        int id = 0;
        while (true) {
            System.out.println("=========Handy Expense program======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.println("Enter your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(list, ++id);
                    break;
                case 2:
                    displayExpense(list);
                    break;
                case 3:
                    deleteExpense(list);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter 1,2,3 and 4 only!!");
            }

        }
    }
}
