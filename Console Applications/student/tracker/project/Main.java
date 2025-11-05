package student.tracker.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n ------ Student Record Management System ------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Display Top Performer");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.addStudent(scanner);
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    manager.searchStudent(searchRoll);
                    break;
                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = scanner.nextInt();
                    manager.deleteStudent(deleteRoll);
                    break;
                case 5:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = scanner.nextInt();
                    manager.updateStudent(updateRoll, scanner);
                    break;
                case 6:
                    manager.displayTopPerformer();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}