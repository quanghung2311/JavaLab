
package JLP0023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Validation {
    
    
    public static int checkInputIntLimit(int min, int max){
        while (true) {            
        try{
            int rs = Integer.parseInt(Main.sc.nextLine().trim());
            if(rs < min || rs > max){
                throw new NumberFormatException();
            }
            return rs;
        } catch(NumberFormatException ex){
            System.out.println("Please input number in rage{" + min + "," + max + "}");
            System.out.print("Enter again: ");
        } 
        }
    }
    
    public static String checkInputString(){
        while (true) {            
            String rs = Main.sc.nextLine().trim();
            if(rs.isEmpty()){
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else{
                return rs;
            }
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try{
                int rs = Integer.parseInt(Main.sc.nextLine());
                return rs;
            }catch(NumberFormatException ex){
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkInputDouble(){
        while (true) {            
            try {
                double rs = Double.parseDouble(Main.sc.nextLine());
                return rs;
            } catch (NumberFormatException ex) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkInputYN(){
        System.out.print("Do you want to continue (Y/N) ?");
        while (true) {            
            String rs = checkInputString();
            if(rs.equalsIgnoreCase("Y")){
                return true;
            }
            
            if(rs.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Just input y/Y or n/N");
            System.out.print("Enter again: ");
        }
    }
    
    public static boolean checkIdExist(ArrayList<Fruit> lf, String id){
        for (Fruit fruit : lf) {
            if(id.equalsIgnoreCase(fruit.getFruitID())){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (order.getFruitID().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
    
}
