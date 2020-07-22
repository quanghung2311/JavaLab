package JLP0022;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Quang Hung
 */
public class Validation {

    private static ArrayList<Candidate> candidates = new ArrayList<>();
            
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public static int checkInputIntLimit(int min, int max) {

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

    public static String checkInputString() {
        while (true) {
            String rs = Main.sc.nextLine().trim();
            if (rs.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return rs;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String rs = checkInputString();
            if (rs.equalsIgnoreCase("Y")) {
                return true;
            } else if (rs.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPhone() {
        while (true) {
            String rs = checkInputString();
            if (rs.matches(PHONE_VALID)) {
                return rs;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        while (true) {
            String rs = checkInputString();

            if (rs.matches(EMAIL_VALID)) {
                return rs;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputGraduationRank() {
        while (true) {
            String rs = checkInputString();
            if (rs.equalsIgnoreCase("Excellence")
                    || rs.equalsIgnoreCase("Good")
                    || rs.equalsIgnoreCase("Fair")
                    || rs.equalsIgnoreCase("Poor")) {
                return rs;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
}
