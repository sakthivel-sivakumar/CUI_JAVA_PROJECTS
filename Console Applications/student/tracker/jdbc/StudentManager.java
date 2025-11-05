package student.tracker.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private StudentDAO dao = new StudentDAO();

    public void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Roll No: ");
            int rollNo = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            int[] marks = new int[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(scanner.nextLine());
            }

            Student student = new Student(name, rollNo, dept, email, marks);
            dao.insertStudent(student);
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error while adding student: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    public void viewAllStudents() {
        try {
            List<Student> list = dao.getAllStudents();
            if (list.isEmpty()) {
                System.out.println("No student records found.");
                return;
            }
            for (Student s : list) {
                System.out.println("---------------------------");
                System.out.println(s);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    public void deleteStudent(Scanner scanner) {
        try {
            System.out.print("Enter roll number to delete: ");
            int rollNo = Integer.parseInt(scanner.nextLine());

            boolean deleted = dao.deleteStudent(rollNo);
            if (deleted) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with roll number " + rollNo + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
        }
    }

    public void updateStudent(Scanner scanner) {
        try {
            System.out.print("Enter roll number to update: ");
            int rollNo = Integer.parseInt(scanner.nextLine());

            Student existingStudent = dao.getStudent(rollNo);
            if (existingStudent == null) {
                System.out.println("Student with roll number " + rollNo + " not found.");
                return;
            }

            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Department: ");
            String dept = scanner.nextLine();

            System.out.print("Enter new Email: ");
            String email = scanner.nextLine();

            int[] marks = new int[5];
            System.out.println("Enter new marks for 5 subjects:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(scanner.nextLine());
            }

            Student updatedStudent = new Student(name, rollNo, dept, email, marks);
            boolean updated = dao.updateStudent(updatedStudent);
            if (updated) {
                System.out.println("✅ Student updated successfully.");
            } else {
                System.out.println("Update failed.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    public void searchStudent(Scanner scanner) {
        try {
            System.out.print("Enter roll number to search: ");
            int rollNo = Integer.parseInt(scanner.nextLine());

            Student student = dao.getStudent(rollNo);
            if (student == null) {
                System.out.println("Student with roll number " + rollNo + " not found.");
            } else {
                System.out.println("Student found:");
                System.out.println(student);
            }
        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
        }
    }

    public void displayTopPerformer() {
        try {
            List<Student> list = dao.getAllStudents();
            if (list.isEmpty()) {
                System.out.println("No student records found.");
                return;
            }

            Student top = list.get(0);
            for (Student s : list) {
                if (s.getAverage() > top.getAverage()) {
                    top = s;
                }
            }

            System.out.println("Top Performer:");
            System.out.println(top);
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }
}
