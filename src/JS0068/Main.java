package JS0068;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

/**
 *
 * @author Quang Hung
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int rs = Integer.parseInt(sc.nextLine());
                if (rs < min || rs > max) {
                    throw new NumberFormatException();
                }
                return rs;
            } catch (NumberFormatException ex) {
                System.err.println("Input again!!");

            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String rs = sc.nextLine();
            if (rs.length() == 0) {
                System.err.println("Not empty!");
            } else {
                return rs;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String rs = sc.nextLine();
            if (rs.length() == 1 && rs.equalsIgnoreCase("Y")) {
                return true;
            } else if (rs.length() == 1 && rs.equalsIgnoreCase("N")) {
                return false;
            }

        }
    }

    public static float checkInputFloat() {
        while (true) {
            try {
                float rs = Float.parseFloat(sc.nextLine());
                return rs;
            } catch (NumberFormatException ex) {
                System.err.println("Input again!!");
            }
        }
    }
    
    public static void addStudent(ArrayList<Student>list){
        System.out.println("=========Collection Sort Program=======");
        System.out.println("Please input information of student: ");
        System.out.print("Name: ");
        String name = checkInputString();
        System.out.println("Classes: ");
        String classes = checkInputString();
        System.out.println("Mark: ");
        float mark = checkInputFloat();
        list.add(new Student(name, classes, mark));
        
    }
    
    public static void sort(ArrayList<Student> list){
         if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------Student " + i + "--------");
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("Classes: " + list.get(i).getClasses());
            System.out.println("Mark: " + list.get(i).getMark());
        }
    }
    
    public static void display(){
        ArrayList<Student> list = new ArrayList<>();
        addStudent(list);
        while(true){
            System.out.println("Do you want to enter more student information ? (Y/N):");
            if(checkInputYN()){
                addStudent(list);
            }else{
                break;
            }
        }
        sort(list);
    }
    
    public static void main(String[] args) {
        display();
    }

}
