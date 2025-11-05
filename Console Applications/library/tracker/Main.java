package library.tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();

        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Lend Book");
            System.out.println("4. View Available Books");
            System.out.println("5. View Issued Books");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    System.out.println("Book Added.");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(userId, name));
                    System.out.println("User Added.");
                    break;

                case 3:
                    System.out.print("Enter Book ID to Lend: ");
                    int lendBookId = sc.nextInt();
                    System.out.print("Enter User ID to Lend To: ");
                    int lendUserId = sc.nextInt();
                    library.lendBook(lendBookId, lendUserId);
                    break;

                case 4:
                    library.viewAvailableBooks();
                    break;

                case 5:
                    library.viewIssuedBooks();
                    break;

                case 6:
                    System.out.print("Enter Book ID to Return: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter User ID Returning the Book: ");
                    int returnUserId = sc.nextInt();
                    library.returnBook(returnBookId, returnUserId);
                    break;

                case 7:
                    System.out.println("Exiting Library System. Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
