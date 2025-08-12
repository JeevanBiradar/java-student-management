import java.util.ArrayList;
import java.util.Scanner;



public class StudentInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentsList= new ArrayList<>();

        studentsList.add(new Student("jeevan",1,"d","cse","4-1"));
        studentsList.add(new Student("Neelesh",2,"d","cse","2-1"));



        while(true){

            System.out.println("====Student database Menu=====");
            System.out.println("1.Add student details \n" +""+
                    "2.update student details \n"+""+
                    "3.Print All students details \n"+""+
                    "4.Delete employee by roll_number \n"+""+
                    "5.Find Student by roll number \n"+""+
                    "6.Exit");
            System.out.println("===============================");
            System.out.println("Enter options to perform operation:");


            int options = sc.nextInt();
            switch (options)
            {
                case 1:
                    StudentDriver.Addstudent(studentsList,sc);
                    break;

                case 2:
                    StudentDriver.updateStudentInfo(studentsList,sc);
                    break;

                case 3:
                    StudentDriver.PrintallStudentDetails(studentsList);
                    break;

                case 4:
                   StudentDriver.deleteStudentByRollnumber(studentsList,sc);
                    break;
                case 5:
                    System.out.println("Enter roll number to search:");
                    int rollnumber = sc.nextInt();
                    Student found = StudentDriver.findStudentByRollnumber(studentsList,rollnumber);
                    if(found != null)
                    {
                        System.out.println("Student found: \n"+ found);
                    }else{
                        System.out.println("Student not found. ");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye");
                    return;
                default:
                    System.out.println("Inavalid choice.Plese enter a number betweeb 1 to 6");
            }
        }

    }
}
