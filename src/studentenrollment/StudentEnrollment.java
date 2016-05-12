/*
NYIT, CSCI-185 504, w0X course prog2/java2, FINAL exam section 2
    My name: Mariapaula Carranza (1066809)
    Program title: Student Enrollment List
*
*/
package studentenrollment;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.*;
import java.util.HashMap;

public class StudentEnrollment {
    private static final HashMap<Integer, ArrayList<String>> student = new HashMap<Integer, ArrayList<String>>();
    private static final String fileName = "StudentEnrollmentList.txt";
    
    public static void main(String[] args)  throws IOException {
       int studentID;
       ArrayList<String> classes;
       boolean endClasses; 
       String user;
       Scanner kb = new Scanner(System.in);
       
       System.out.println("Do you wish to enter a student? (Y/N)");
       user = kb.next();
        
       while(user.equalsIgnoreCase("y"))
       {
           System.out.println("Enter student ID number: ");
           studentID = kb.nextInt();
           classes = new ArrayList<String>();
           endClasses = false;
                    
           classes = new ArrayList<String>();
           endClasses = false;
                    
            while (!endClasses)
            {
                System.out.println("Enter the name of a class you would like to enroll in for student ID #" + studentID + "!");
                String className=kb.next();
                       
                classes.add(className);
                System.out.println("Would you like to enroll in more classes? (Y/N)");
                String confirmClasses = kb.next(); 
                
                if (confirmClasses.equalsIgnoreCase("n"))
                {
                    endClasses = true;
                }
            }
            if (student.get(studentID) != null)
            {
                ArrayList<String> combinedClasses = combineLists(student.get(studentID), classes);
                student.put(studentID, combinedClasses);
            } 
            else
            {
                student.put(studentID, classes);
            }
            System.out.println("Enter another student? (Y/N)");
            user = kb.next();
            
       }
        
        makeFile(student);
        
        System.out.println();
        BufferedReader br = new BufferedReader(new FileReader("StudentEnrollmentList.txt"));
        String aLineFromFile = null;
        while ((aLineFromFile = br.readLine()) != null)
        {
            System.out.println(aLineFromFile);
        }
        br.close();
        
    }
    public static void makeFile(HashMap<Integer, ArrayList<String>> student)
    {
        try
        {
            PrintWriter writer = new PrintWriter(fileName);
            for (HashMap.Entry<Integer, ArrayList<String>> entry : student.entrySet()) {
                writer.println("Student ID #" + entry.getKey() + " wants to enroll in " + entry.getValue());
            }
            writer.close();
            
            System.out.println("File created: " + fileName + "!");
        } catch(Exception e)
        {
           System.out.println("File cannot be found!");
        }
    }
    
    public static ArrayList<String> combineLists(ArrayList<String> list1, ArrayList<String> list2)
    {
        ArrayList<String> finalList = new ArrayList<String>();

        for(String str : list1)
        {
            finalList.add(str);
        }

        for(String str : list2)
        {
            finalList.add(str);
        }

        return finalList;
    }
    
}
