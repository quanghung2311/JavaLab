
package JSP0058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Quang Hung
 */
public class DictionaryProgram {

    private ArrayList<String> list = new ArrayList<>();
    private HashMap<String, String> hm = new HashMap<>();
//    
//    public boolean checkKeywordExist(String english){
//        Set set = hm.entrySet();
//        Iterator i = set.iterator();
//        while (i.hasNext()) {            
//            Map.Entry m = (Map.Entry) i.next();
//            if(english.equalsIgnoreCase(m.getKey().toString())){
//                return false;
//            }
//        }
//        return true;
//    }
    
    public void addWord(){
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        for (String keyEnglis : hm.keySet()) {
            if(english.equalsIgnoreCase(keyEnglis)){
                System.out.println("Key English is exit");
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vn = Validation.checkInputString();
        hm.put(english, vn);
        try {
            FileWriter fw = new FileWriter("test1.txt",true);
            BufferedWriter br = new BufferedWriter(fw);
            br.append("1-" + english + "-" + vn + "\n");
            br.newLine();
            br.flush();
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteWord(){
        System.out.println("------------ Delete ----------------");
        System.out.println("Enter English: ");
        String english = Validation.checkInputString();
        hm.remove(english);
        boolean check = false;
        try {
            FileReader fr = new FileReader("test1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            while((line = br.readLine()) != null){
                if(line.contains(english)){
                    line = line.replace("1", "0");
                    check = true;
                }
                list.add(line);
            }
            br.close();
            
            FileWriter f = new FileWriter("test1.txt");
            BufferedWriter b = new BufferedWriter(f);
            for (String str : list) {
                b.write(str);
                b.newLine();
            }
            b.flush();
            b.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void search(){
        System.out.print("Enter Key English you want to search: ");
        String key = Validation.checkInputString();
        System.out.println("Vietnamese: " + hm.get(key));
        System.out.println("Search successfully!");
    }
    
    public void translateWord(){
        System.out.println("------------- Translate ------------");
        System.out.println("Enter English: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
           if(entry.getKey().equals(english)){
               System.out.println("Vietnamese: " + entry.getValue());
               return;
           }
        }
    }
    
}
