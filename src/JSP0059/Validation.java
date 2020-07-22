package JSP0059;

/**
 *
 * @author Quang Hung
 */
public class Validation {

    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int rs = Integer.parseInt(Main.sc.nextLine().trim());
                if (rs < min || rs > max) {
                    throw new NumberFormatException();
                }
                return rs;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage[" + min + "," + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputPathFile() {
        while (true) {
            String rs = Main.sc.nextLine().trim();
            if (rs.isEmpty()) {
                System.err.println("Not Empty!!");
                System.out.print("Enter again: ");
            } else {
                return rs;
            }
        }
    }

    public static double checkInputMoney() {
        System.out.print("Enter money: ");
        while (true) {
            try {
                double rs = Double.parseDouble(Main.sc.nextLine());
                return rs;
            } catch (NumberFormatException e) {
                System.err.println("Input double only!!");
                System.out.print("Enter again: ");
            }

        }
    }
    
      public static int checkInputPositiveInt() {

        while (true) {
            try {
                int result = Integer.parseInt(Main.sc.nextLine().trim());
                if (result < 0) {
                    System.err.println("Number must be positive");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
}
