package student.tracker.project;

public class Student 
{
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
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Roll No: ").append(rollNo).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Department: ").append(dept).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Marks: ");
        for (int mark : marks) {
            sb.append(mark).append(" ");
        }
        sb.append("\nAverage: ").append(getAverage());
        return sb.toString();
    }
}
