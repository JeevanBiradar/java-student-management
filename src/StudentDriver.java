import java.util.ArrayList;
import java.util.Scanner;


public class StudentDriver {

    //Add student
    public static void  Addstudent(ArrayList<Student> studentsList,Scanner sc)
    {
        System.out.println("Enter roll number:");
        int rollnumber = sc.nextInt();

        if(findStudentByRollnumber(studentsList,rollnumber) == null)
        {
            System.out.println("Enter name:");
            String sname = sc.next();

            System.out.println("Enter section:");
            String Section =sc.next();

            System.out.println("Enter department:");
            String department = sc.next();

            System.out.println("Enter semester:");
            String Semester = sc.next();

            Student s = new Student(sname,rollnumber,Section,department,Semester);

            studentsList.add(s);

            System.out.println("Student added sucessfully");
        }
        else {
            System.out.println("Student with "+ rollnumber+"Already exists");
        }


    }

    //print all deatils
    public static void PrintallStudentDetails(ArrayList<Student> studentsList)
    {
        if(studentsList.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }
        System.out.println("\n--- All Students Details ---");
        for(Student s:studentsList) {
            System.out.println(s);
        }
    }


    //search a student details
    public static Student findStudentByRollnumber(ArrayList<Student> studentsList,int rollnumber)
    {

             for(Student s:studentsList)
             {
                 if(s.getRollnumber() == rollnumber)
                     return s;
             }
             return null;
    }


    //to delete student from list
    public static void deleteStudentByRollnumber(ArrayList<Student> studentsList,Scanner sc) {

        System.out.println("Enter roll number to delete:");
        int rollnumber = sc.nextInt();
        Student toremove = findStudentByRollnumber(studentsList, rollnumber);

        if (toremove != null) {
            studentsList.remove(toremove);
            System.out.println("Student deleted sucessfully");
        } else {
            System.out.println("Student not found.");
        }
    }

    //to updatestudentinfo
    public static void updateStudentInfo(ArrayList<Student> studentsList,Scanner sc)
    {
        System.out.println("enter rollnumber to update:");
        int rollnumber=sc.nextInt();
        Student tofind = findStudentByRollnumber(studentsList,rollnumber);

        if(tofind != null)
        {
            System.out.println("Enter name:");
             String sname = sc.next();
              tofind.setSname(sname);

            System.out.println("Enter rollnumber:");
             rollnumber = sc.nextInt();
              tofind.setRollnumber(rollnumber);

            System.out.println("Enter Section:");
             String section= sc.next();
              tofind.setSection(section);

            System.out.println("Enter Department:");
             String department = sc.next();
              tofind.setDepartment(department);

            System.out.println("Enter semester:");
             String semester = sc.next();
              tofind.setSemester(semester);

            System.out.println("Student details upated sucessfully");
        }
        else{
            System.out.println("Student not found.");
        }
    }
}