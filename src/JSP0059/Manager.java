package JSP0059;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 *
 * @author Quang Hung
 */
public class Manager {

    ArrayList<Person> list = new ArrayList<>();

    public void search() {
        System.out.println("--------- Person info ---------");
        System.out.println("Enter Path: ");
        String path = Validation.checkInputPathFile();
        list = loadFile(path);
        System.out.println("Enter Money: ");
        double money = Validation.checkInputPositiveInt();
        System.out.println("------------- Result ------------");
        display(money);
    }

    public ArrayList<Person> loadFile(String fileName) {
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String countLine;
            while ((countLine = bufferedReader.readLine()) != null) {
                String[] infor = countLine.split(";");
                list.add(new Person(infor[0], infor[1], Double.parseDouble(infor[2])));
            }
        } catch (Exception e) {
            System.err.println("Error!");
        }
        return list;
    }

    public void display(double money) {
        System.out.printf("%-10s %-12s %-12s", "Name", "Address", "Money");
        System.out.println("");
        for (Person person : list) {
            if (person.getMoney() >= money) {
                System.out.println(person.toString());
            }
        }
        sort();
        System.out.println("Max: " + list.get(list.size() - 1).getName());
        System.out.println("Min: " + list.get(0).getName());
    }

    public void sort() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1).getMoney() > list.get(j).getMoney()) {
                    Person t = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, t);
                }
            }
        }
    }

    public void Coppy(File fileTo, File FileFrom) throws IOException {
        Files.copy(FileFrom.toPath(), fileTo.toPath());
    }

    public void CoppyFile() {
        System.out.println("---------- Copy text ---------");
        System.out.println("Enter Source:");
        String fileFrom = Validation.checkInputPathFile();
        System.out.println("Enter new file name:");
        String fileTo = Validation.checkInputPathFile();
        File from = new File(fileFrom);
        File to = new File(fileTo);
        try {
            Coppy(to, from);
            System.err.println("Coppy done.");
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
