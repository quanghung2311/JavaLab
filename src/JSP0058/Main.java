package JSP0058;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        DictionaryProgram dp = new DictionaryProgram();
        HashMap<String, String> hm = new HashMap<>();
        try{
            FileReader fr = new FileReader("test1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String d[] = line.split("-");
                if(d[0].equals("1")){
                    hm.put(d[1], d[2]);
                }
            }
            br.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        int choice = 0;
        do {
            System.out.println("========= Dictionary program ========");
            System.out.println("1. Add new word.");
            System.out.println("2. Delete word.");
            System.out.println("3. Translate word.");
            System.out.println("4.Search word");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    dp.addWord();
                    break;
                case 2:
                    dp.deleteWord();
                    break;
                case 3:
                    dp.translateWord();
                    break;
                case 4:
                    dp.search();
                    break;
                case 5:
                    return;
                    default: System.out.println("Enter 1,2,3,4 and 5 only!!");
            }
        } while (choice <= 5);
    }
}
