package student.tracker.project;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager 
{
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // clear newline

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        Student student = new Student(name, rollNo, dept, email, marks);
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Student s : studentList) {
            System.out.println("------------------------");
            System.out.println(s);
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student found:");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }

    public void deleteStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                studentList.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }

    public void updateStudent(int rollNo, Scanner scanner) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.print("Enter new Name: ");
                scanner.nextLine(); // consume newline
                s.setName(scanner.nextLine());

                System.out.print("Enter new Department: ");
                s.setDept(scanner.nextLine());

                System.out.print("Enter new Email: ");
                s.setEmail(scanner.nextLine());

                int[] newMarks = new int[5];
                System.out.println("Enter new marks for 5 subjects:");
                for (int i = 0; i < 5; i++) {
                    System.out.print("Subject " + (i + 1) + ": ");
                    newMarks[i] = scanner.nextInt();
                }

                s.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }

    public void displayTopPerformer() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student topStudent = studentList.get(0);
        for (Student s : studentList) {
            if (s.getAverage() > topStudent.getAverage()) {
                topStudent = s;
            }
        }

        System.out.println("Top performer:");
        System.out.println(topStudent);
    }
}