package JSP0063;

import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Input must be digit.");
            }
        }
    }

    public static double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result < 0) {
                    System.out.println("Salary is greater than zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You must input digidt.");
                System.out.print("Please input salary: ");
            }
        }
    }

    public static int checkInputNumberStudent() {
        System.out.print("Enter number student: ");
        int n = checkInputInt();
        return n;
    }

    public static Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Person(name, address, salary);
    }

    public static void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    public static void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.out.println("Sort sussess.");
        return;
    }

    public static void main(String[] args) {
        int n = checkInputNumberStudent();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);
        System.out.println("");
        for (int i = 0; i < persons.length; i++) {
            System.out.println("Information of Person you have entered:");
            listPersonWrapper[i].p.displayPersonInfo();
            System.out.println("");
        }
       
    }
}
