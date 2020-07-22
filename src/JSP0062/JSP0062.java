package JSP0062;

import java.io.File;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeError;

/**
 *
 * @author Quang Hung
 */
public class JSP0062 {

    public static Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        while (true) {
            String rs = sc.nextLine().trim();
            if (rs.length() == 0) {
                System.err.print("Not empty.");
            } else {
                return rs;
            }

        }
    }

    public static void inputPath() {
        System.out.println("========== Analysis Path Program =========");
        System.out.println("Please input Path: ");
        String path = checkInputString();
        System.out.println("Disk: " + getDisk(path));
        System.out.println("Extension: " + getExtension(path));
        System.out.println("File name: " + getFileName(path));
        System.out.println("Path: " + getPath(path));
        getForders(path);

    }

    public static String getPath(String path) {
        int nameFile = path.lastIndexOf("\\");
        return path.substring(0, nameFile);
    }

    public static String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot + 1, path.length());
    }

    public static String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    public static String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon);
    }

    public static void getForders(String path) {
        String[] folder = path.split("\\\\");
        System.out.print("Folder: ");
        for (int i = 1; i < folder.length - 1; i++) {
            System.out.print("[" + folder[i] + "]");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        inputPath();
    }
}
