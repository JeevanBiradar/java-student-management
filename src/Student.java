public class Student {

    private String sname;
    private int rollnumber;
    private String section;
    private String department;
    private String semester;

    public Student(String sname, int rollnumber, String section, String department, String semester) {
        this.sname = sname;
        this.rollnumber = rollnumber;
        this.section = section;
        this.department = department;
        this.semester = semester;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
        section = section;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString(){

        return "Name:" + sname
                + "\nRollnumber:" + rollnumber
                +"\nSection:"+ section
                +"\nDepartment:"+ department
                +"\nSemster:"+ semester + "\n"
                +"----------------------------";
    }

}
