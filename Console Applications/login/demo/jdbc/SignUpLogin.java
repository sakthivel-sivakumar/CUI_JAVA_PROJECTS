package login.demo.jdbc;

import java.sql.*;
import java.util.Scanner;

public class SignUpLogin 
{

    private final String URL = "jdbc:mysql://localhost:3306/KITS";
    private final String USER = "root"; 
    private final String PASSWORD = "sakthi1617"; 
    
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void signUp(Scanner sc) 
    {
        System.out.print("Enter new username: ");
        String username = sc.next();
        System.out.print("Enter new password: ");
        String password = sc.next();

        String checkQuery = "SELECT * FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) 
        {

            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) 
            {
                System.out.println("Username already exists! Try a different one.");
                return;
            }

            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            System.out.println("Signup successful!");

        } catch (SQLException e) {
            System.out.println("Database error during signup: " + e.getMessage());
        }
    }

    // Login
    public void login(Scanner sc) 
    {
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) 
        {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (SQLException e) {
            System.out.println("Database error during login: " + e.getMessage());
        }
    }

    // Run Menu
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Welcome ====");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    signUp(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
