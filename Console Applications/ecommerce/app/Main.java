package ecommerce.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Sample products
        platform.addProduct(new Product(1, "Laptop", 55000.0, "Electronics", 10));
        platform.addProduct(new Product(2, "Mobile", 22000.0, "Electronics", 15));
        platform.addProduct(new Product(3, "Shoes", 2500.0, "Footwear", 20));

        // Register users
        platform.registerUser(new Admin("A101", "Admin One", "admin@shop.com", "admin123"));
        platform.registerUser(new Customer("C101", "John", "john@gmail.com", "1234"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mini E-Commerce Platform");

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String pwd = sc.nextLine();

        User user = platform.login(email, pwd);

        if (user == null) {
            System.out.println("Invalid login credentials!");
            sc.close();
            return;
        }

        if (user instanceof Admin) {
            System.out.println("Welcome Admin: " + user.getName());
            // You can extend admin actions here
        } else if (user instanceof Customer) {
            System.out.println("Welcome Customer: " + user.getName());

            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. View Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Checkout");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\nAvailable Products:");
                        for (Product p : platform.getAllProducts()) {
                            System.out.println(p);
                        }
                        break;
                    case 2:
                    	System.out.println("\nAvailable Products:");
                        for (Product p : platform.getAllProducts()) {
                            System.out.println(p);
                        }
                        System.out.print("Enter Product ID to Add: ");
                        int pid = sc.nextInt();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        Product selected = null;
                        for (Product p : platform.getAllProducts()) {
                            if (p.getId() == pid) {
                                selected = p;
                                break;
                            }
                        }

                        if (selected != null) {
                            platform.getCart(email).addItem(selected, qty);
                            System.out.println("Added to cart.");
                        } else {
                            System.out.println("Invalid product ID.");
                        }
                        break;
                    case 3:
                        Cart cart = platform.getCart(email);
                        System.out.println("Your Cart:");
                        for (CartItem item : cart.getItems()) {
                            System.out.println(item.getProduct().getName() + " x" + item.getQuantity());
                        }
                        System.out.println("Total: ₹" + cart.getTotalAmount());
                        break;
                    case 4:
                    	if(platform.checkCart(email))
                    	{
                    		System.out.print("Enter payment method (UPI/Card): ");
                            sc.nextLine(); // consume leftover newline
                            String method = sc.nextLine();
                            platform.checkout(email, method);
                    	}
                    	else
                    	{
                    		System.out.println("Sorry your cart Looks Empty");
                    	}
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for shopping!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }

        sc.close();
    }
}
