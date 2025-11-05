package student.tracker.jdbc;

public class Student {
    private String name;
    private int rollNo;
    private String dept;
    private String email;
    private int[] marks;

    public Student(String name, int rollNo, String dept, String email, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.dept = dept;
        this.email = email;
        this.marks = marks;
    }

    public double getAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public String getEmail() { return email; }
    public int[] getMarks() { return marks; }

    public void setMarks(int[] marks) { this.marks = marks; }
    public void setName(String name) { this.name = name; }
    public void setDept(String dept) { this.dept = dept; }
    public void setEmail(String email) { this.email = email; }
}
