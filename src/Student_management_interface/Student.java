package Student_management_interface;

public class Student {

    private int rollnumber;
    private String sname;
    private String section;
    private String department;
    private String semester;

    public Student(int rollnumber,String sname,String section, String department, String semester) {

        this.rollnumber = rollnumber;
        this.sname = sname.toUpperCase();
        this.section = section.toUpperCase();
        this.department = department.toUpperCase();
        this.semester = semester.toUpperCase();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname.toUpperCase();
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section.toUpperCase();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department.toUpperCase();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester.toUpperCase();
    }

    @Override
    public String toString(){

        return "Name:" + sname
                + "\nRoll number:" + rollnumber
                +"\nSection:"+ section
                +"\nDepartment:"+ department
                +"\nSemester:"+ semester + "\n";
    }

}
