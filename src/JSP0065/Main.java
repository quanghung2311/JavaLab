package JSP0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        while (true) {
            String rs = sc.nextLine().trim();
            if (rs.isEmpty()) {
                System.err.println("Not empty");
            } else {
                return rs;
            }
        }
    }

    public static int checkInputMark(String nameSubject) {
        while (true) {
            try {
                int rs = Integer.parseInt(sc.nextLine());
                if (rs < 0) {
                    System.err.println(nameSubject + " must be greater than equal zero");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                if (rs > 10) {
                    System.err.println(nameSubject + " must be less than equal ten");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                return rs;
            } catch (NumberFormatException e) {
                System.err.println(nameSubject + " must be is digit");
                System.err.println("Input again!!");
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String rs = checkInputString();
            if (rs.length() == 1) {
                char rsChar = rs.charAt(0);
                if (rsChar == 'y' || rsChar == 'Y') {
                    return true;
                }
                if (rsChar == 'n' || rsChar == 'N') {
                    return false;
                }
            }
            System.err.println("Input again!!");
        }
    }

    public static void addStudent(List<Student> list) {
        while (true) {
            System.out.println("Name: ");
            String name = checkInputString();
            System.out.println("Classes: ");
            String classes = checkInputString();
            System.out.println("Maths: ");
            double math = checkInputMark("Maths");
            System.out.println("Chemistry: ");
            double chemistry = checkInputMark("Chemistry");
            System.out.println("Physical: ");
            double physical = checkInputMark("Physical");
            double average = (math + chemistry + physical) / 3;
            String type;
            if (average > 7.5) {
                type = "A";
            } else if (average >= 6 && average <= 7.5) {
                type = "B";
            } else if (average >= 4 && average <= 6) {
                type = "C";
            } else {
                type = "D";
            }
            list.add(new Student(name, classes, math, physical, chemistry, average, type));
            System.out.println("Do you want to enter more student information ? (Y/N): ");
            if (!checkYN()) {
                return;
            }
        }
    }

    public static void displayInfomationStudent(List<Student> list) {
        int i = 0;
        for (Student st : list) {
            System.out.println("-------Student " + ++i + " Info-------");
            System.out.println("Name: " + st.getName());
            System.out.println("Classes: " + st.getClasses());
            System.out.println("AVG: " + st.getAverage());
            System.out.println("Type: " + st.getType());
            System.out.println("");
        }
    }
// Cách 1
//    public static HashMap<String, Double> percentTypeScore(List<Student> list){
//        HashMap<String, Double> percentType = new HashMap<>();
//        int total = list.size();
//        double typeA = 0;
//        double typeB = 0;
//        double typeC = 0;
//        double typeD = 0;
//        for(int i = 0; i < total; i++){
//            if(list.get(i).getType() == 'A'){
//                typeA++;
//            }
//            if(list.get(i).getType() == 'B'){
//                typeB++;
//            }
//            if(list.get(i).getType() == 'C'){
//                typeC++;
//            }if(list.get(i).getType() == 'D'){
//                typeD++;
//            }
//        }
//        percentType.put("A", typeA / total * 100);
//        percentType.put("B", typeB / total * 100);
//        percentType.put("C", typeC / total * 100);
//        percentType.put("D", typeD / total * 100);
//        return percentType;
//    }
//Cách 2:
    public static HashMap<String, Double> percentTypeScore(List<Student> list) {
        HashMap<String, Double> percentType = new HashMap<>();
        String[] a = {"A", "B", "C", "D"};
        for (String string : a) {
            percentType.put(string, 0.0);
        }
        double num = 0;
        for (Student student : list) {
            num = percentType.get(student.getType());
            num++;
            percentType.put(student.getType(), num);
        }
        return percentType;

    }
     
    public static void main(String[] args) {
        Main st = new Main();
        List<Student> list = new ArrayList<>();
        System.out.println("========Management Student Program======");
        st.addStudent(list);
        st.displayInfomationStudent(list);
        int total = list.size();
        HashMap<String, Double> percentType = percentTypeScore(list);
        System.out.println("--------Classification Info -------");
        for (Map.Entry student : percentType.entrySet()) {
            System.out.println(student.getKey() + ":" + String.format("%.2f", Double.valueOf(student.getValue().toString()) / total * 100) + "%");
        }
    }

}
