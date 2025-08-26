package Student_management_interface;
import java.sql.*;
import java.util.ArrayList;


public class StudentDao{

    // ? Database connection Method
    public static Connection connect()
    {
        String url="jdbc:mysql://localhost:3306/student";
        String user="root";
        String password="123456";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            System.out.println("connection to mysql failed :check your sql server");
            System.out.println(e.getMessage());
        }

        return conn;
    }

    //! Getting Student details from Database
    public static ArrayList<Student> getAllStudentDetails()
    {
        String sql ="SELECT * FROM  students";
        ArrayList<Student> studentList = new ArrayList<>();

        try{
            Connection conn = connect();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                Student student = new Student(
                        rs.getInt("rollnumber"),
                        rs.getString("sname"),
                        rs.getString("section"),
                        rs.getString("department"),
                        rs.getString("semester"));
                studentList.add(student);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return studentList;
    }


    // ! Adding Student to Database
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students(rollnumber, sname, section, department, semester) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getRollnumber());
            pstmt.setString(2, student.getSname());
            pstmt.setString(3, student.getSection());
            pstmt.setString(4, student.getDepartment());
            pstmt.setString(5, student.getSemester());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student to database: " + e.getMessage());
            return false;
        }
    }


    //!Update Student Info In Database
    public boolean updateStudent(int originalRollNumber, Student updatedStudent) {
        String sql = "UPDATE students SET rollnumber = ?, sname = ?, section = ?, department = ?, semester = ? WHERE rollnumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, updatedStudent.getRollnumber());
            pstmt.setString(2, updatedStudent.getSname());
            pstmt.setString(3, updatedStudent.getSection());
            pstmt.setString(4, updatedStudent.getDepartment());
            pstmt.setString(5, updatedStudent.getSemester());
            pstmt.setInt(6, originalRollNumber);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student in database: " + e.getMessage());
            return false;
        }
    }


    //! Delete Student Data from Database
    public boolean deleteStudent(int rollNumber) {
        String sql = "DELETE FROM students WHERE rollnumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rollNumber);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student from database: " + e.getMessage());
            return false;
        }
    }
}






