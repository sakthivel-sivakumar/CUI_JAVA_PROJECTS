package student.tracker.jdbc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Display Top Performer");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline

                switch (choice) {
                    case 1:
                        manager.addStudent(scanner);
                        break;
                    case 2:
                        manager.viewAllStudents();
                        break;
                    case 3:
                        manager.searchStudent(scanner);
                        break;
                    case 4:
                        manager.deleteStudent(scanner);
                        break;
                    case 5:
                        manager.updateStudent(scanner);
                        break;
                    case 6:
                        manager.displayTopPerformer();
                        break;
                    case 7:
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                        break;
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
                choice = -1; // keep loop going
            }

        } while (choice != 7);

        scanner.close();
    }
}
