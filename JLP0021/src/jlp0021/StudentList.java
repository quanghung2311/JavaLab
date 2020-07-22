package jlp0021;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Quang Hung
 */
public class StudentList {

 ArrayList<Student> list;
    static Scanner sc = new Scanner(System.in);
    
    public StudentList(){
        list = new ArrayList();
    }
    
    public void Creat(){
        do{
        Student s = new Student();
        System.out.print("Input Student ID: ");
        s.setId(sc.nextLine());
        System.out.print("Input Student Name: ");
        s.setStudentName(sc.nextLine());
        System.out.print("Input Semester: ");
        s.setSemester(sc.nextInt());
        System.out.print("Input Course Name: ");
        sc.nextLine();
        s.setCourseName(sc.nextLine());
        list.add(s);
        System.out.println("Do you want to continue(Y/N): ");
        String yn = sc.nextLine();
        if(yn.equals("N")){
            break;
        }
        }while(true);     
        
    }
    
    public void output(){
        for (Student student : list) {
            System.out.println(student.toString());
            
        }
    }
    
    
    
    public void findAndSort(){
        String name;
        ArrayList<Student> ListName = new ArrayList<>();
        System.out.print("Input Name: ");
        name = sc.nextLine();
        for (Student student : list) {
            if(student.getStudentName().matches("(.*)" + name + "(.*)")){
                ListName.add(student);
            }
                       
        }
        Collections.sort(ListName, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        System.out.printf("%-20s|%8s|%11s \n", "Student Name", "Semester", "Course Name");
        for (Student student : ListName) {
            System.out.printf("%-20s|%-8s|%-11s \n",student.getStudentName(), student.getSemester(), student.getCourseName() );
            
        }  
        System.out.println("");
    }
    
    public Student FindID(){
        String id;
        System.out.print("Input Student ID: ");
        id = sc.nextLine();
        for(Student s : list){
            if(id.equals(s.getId())){
                return s;
            }                
        }
        return null;
    }
    
    
    public void updateAndDelete(){
        Student s = FindID();
        System.out.println("Do you want Update or Delete ?");
        System.out.println("1. Update");
        System.out.println("2. Delete");
        int choice = sc.nextInt();
        switch(choice){
            case 1: {
                System.out.print("Input Student Name: ");
                sc.nextLine();
                s.setStudentName(sc.nextLine());
                System.out.print("Input Semester: ");
                
                s.setSemester(sc.nextInt());
                System.out.print("Input Course Name: ");
                sc.nextLine();
                s.setCourseName(sc.nextLine());
                break;
            }
            case 2: {
                list.remove(s);
                break;
            }
                
        }       
    }
    
    public  void Report(){
        int size = list.size();
        int count[] = new int[size];
        int i = 0;
        for(Student student : list){
            for(Student student1 : list){
                if(student.getId().equals(student1.getId()) && student.getStudentName().equals(student1.getStudentName()) 
                        && student.getCourseName().equals(student1.getCourseName())){
                    count[i]++;
                }
            }
            i++;
        }
        ArrayList<String> print = new ArrayList<>();
        int j = 0;
        for(Student s: list){
            String result = String.format("%-20s|%-10s|%-5d", s.getStudentName(), s.getCourseName(), count[j]);
            print.add(result);
            j++;
        }
        Set<String> set = new HashSet<>(print);
        print.clear();
        print.addAll(set);
        for(String result : set){
            System.out.println(result);
        }
        
    }

}
