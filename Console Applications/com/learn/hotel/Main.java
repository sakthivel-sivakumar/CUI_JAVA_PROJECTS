package com.learn.hotel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelManagement manager = new HotelManagement();
		int choice;
        do
        {
            System.out.println("\n=====================================");
            System.out.println("1. Add Room ");
            System.out.println("2. Check In ");
            System.out.println("3. Check Out ");
            System.out.println("4. View Bookings ");
            System.out.println("5. View CheckedOut ");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    manager.addRoom();
                    break;

                case 2:
                    manager.checkIn();
                    break;

                case 3:
                		manager.checkOut();
                    break;

                case 4:
                    manager.showBookings();
                    break;
                    
                case 5:
                    manager.showCheckedOutList();
                    break;
                    
                case 6:
                    System.out.println("Exiting !!!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }while(choice<=5);
        sc.close();
	}

}
