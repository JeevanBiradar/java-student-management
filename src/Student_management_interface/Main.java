package Student_management_interface;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static Student findStudentByRollnumber(ArrayList<Student> studentsList, int rollnumber) {
        for (Student s : studentsList) {
            if (s.getRollnumber() == rollnumber)
                return s;
        }
        return null;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDao dao = new StudentDao();

        ArrayList<Student> studentsList =dao .getAllStudentDetails();

        while(true){

            System.out.println("\n===== Student Database Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Print All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Find Student by Roll Number");
            System.out.println("6. Exit");
            System.out.println("===============================");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    if (findStudentByRollnumber(studentsList, roll) != null) {
                        System.out.println("Error: Student with this roll number already exists.");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Section: ");
                    String section = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Semester: ");
                    String sem = sc.next();
                    Student newStudent = new Student(roll, name, section, dept, sem);
                    if (dao.addStudent(newStudent)) {
                        studentsList.add(newStudent);
                        System.out.println("Student added successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number of student to update: ");
                    int oldRoll = sc.nextInt();
                    Student studentToUpdate = findStudentByRollnumber(studentsList, oldRoll);
                    if (studentToUpdate == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter new Name: ");
                    String newName = sc.next();
                    System.out.print("Enter new Section: ");
                    String newSection = sc.next();
                    System.out.print("Enter new Department: ");
                    String newDepartment = sc.next();
                    System.out.print("Enter new Semester: ");
                    String newSemsester = sc.next();
                    //... get other updated info ...
                    Student updatedStudent = new Student(oldRoll, newName, newSection, newDepartment, newSemsester);
                    if (dao.updateStudent(oldRoll, updatedStudent)) {
                        // Update local list
                        studentToUpdate.setSname(newName);
                        studentToUpdate.setSection(newSection);
                        studentToUpdate.setDepartment(newDepartment);
                        studentToUpdate.setSemester(newSemsester);
                        System.out.println("Student updated successfully.");
                    }
                    break;

                case 3:
                    studentsList = dao.getAllStudentDetails();
                    if (studentsList.isEmpty()) {
                        System.out.println("No students found in the database.");
                    } else {
                        System.out.println("\n--- All Students Details ---");
                        for (Student s : studentsList) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int rollToDelete = sc.nextInt();
                    if (dao.deleteStudent(rollToDelete)) {
                        studentsList.removeIf(s -> s.getRollnumber() == rollToDelete);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found or could not be deleted.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Roll Number to find: ");
                    int rollToFind = sc.nextInt();
                    Student found = findStudentByRollnumber(studentsList, rollToFind);
                    if (found != null) {
                        System.out.println("Student found: \n" + found);
                    } else {
                        System.out.println("Student not found in the local list.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye");
                    return;
                default:
                    System.out.println("Invalid choice.Please enter a number between 1 to 6");
            }
        }

    }
}
