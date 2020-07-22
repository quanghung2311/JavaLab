
package JLP0025;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class Main {
      public static void main(String[] args) throws FileNotFoundException {
        String str = readfile();
        str = str.toLowerCase();
        //System.out.println(st);
        str = space(str);
        str = afdoc(str);
        str = afquote(str);
        str = newline(str);
        writefile(str);
        //System.out.println(st);
    }

    private static void writefile(String str) {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    private static String newline(String str) {
        int i=0;
        while (i<str.length()){
            if (str.charAt(i)=='\n' && str.charAt(i+2)=='\n'){
                str = str.substring(0, i) + str.substring(i+2);
                i--;
            }
            if (str.charAt(i)=='\n')
                str = str.substring(0, i+1)+Character.toUpperCase(str.charAt(i+1))+str.substring(i+2); 
            i++;
        }
        return str;
    }

    private static String afquote(String str) {
        int i=0;
        int x=0;
        while (i<str.length()){
            if (str.charAt(i)=='"'){
                if (x==0){
                    if (str.charAt(i-1)!=' ')
                        str = str.substring(0, i) + " " + str.substring(i);
                    if (str.charAt(i+1)==' '){
                        str = str.substring(0, i+1) + str.substring(i+2);
                        i--;
                    }
                    x=1;
                    i+=2;
                }
                else if (x==1){
                    if (str.charAt(i+1)!=' ')
                        str = str.substring(0, i+1) + " " + str.substring(i+1);
                    if (str.charAt(i-1)==' '){
                        str = str.substring(0, i+1) + str.substring(i+2);
                        i--;
                    }  
                    x=0;
                    i+=2;
                }
            }
            i++;
        }
        return str;
    }

    private static String afdoc(String str) {
        int i=0;
        if(Character.isLowerCase(str.charAt(i)))
            str=Character.toUpperCase(str.charAt(i))+str.substring(i+1);
        while (i<str.length()){
            if ((str.charAt(i)=='.'||str.charAt(i)==','||str.charAt(i)==':') && str.charAt(i-1)==' '){
                str = str.substring(0, i-1) + str.substring(i);
                i--;
            }
            if ((str.charAt(i)=='.'||str.charAt(i)==','||str.charAt(i)==':') && str.charAt(i+1)!=' ')
                str = str.substring(0, i+1) + " " + str.substring(i+1);
            if (str.charAt(i)=='.' )
                str = str.substring(0, i+2)+Character.toUpperCase(str.charAt(i+2))+str.substring(i+3);
            i++;
        }
        if (str.charAt(str.length()-1)!='.')
            str+=".";
        return str;
    }

    private static String space(String str) {
        int i=0;
        while (i<str.length()){
            if ((str.charAt(i)==' '&& str.charAt(i+1)==' ')||(str.charAt(i)==' '&& str.charAt(i-1)==' '))
                str = str.substring(0, i) + str.substring(i+1);
            else
                i++;
        }
        return str;
    }
    private static String readfile() throws FileNotFoundException {
        String data="";
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\Z"); 
            data=sc.next();
        return data;
    }
}
