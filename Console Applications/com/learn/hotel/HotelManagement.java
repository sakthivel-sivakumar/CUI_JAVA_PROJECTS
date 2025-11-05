package com.learn.hotel;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class HotelManagement {
	GuestManagement gm = new GuestManagement();
	RoomManagement rm = new RoomManagement();
	Scanner sc = new Scanner(System.in);
	
	private HashMap<String, Booking> bookingsList = new HashMap<>();
	private HashMap<String,Booking> checkedOutList = new HashMap<>();
	
	public void addRoom()
	{
		rm.addRoom();
	}

	public void checkIn() {
		System.out.println("Enter room type : ");
		String roomType = sc.nextLine();
		if (rm.checkAvailibility(roomType)) {
			System.out.println("Room Available : ");
			System.out.println("Please provide your details : ");
			Guest guest = gm.addGuest();
			if (!guest.getBookedStatus()) {
				Room room = rm.getAvailableRoom(roomType);
				Booking b = new Booking(guest,room,guest.getGuestId(), room.getRoomId(), LocalDateTime.now());
				guest.setBookedStatus(true);
				bookingsList.put(b.getBookingId(), b);
				System.out.println(
					    "Booking successful!\nGuest ID: " + b.getGuestId() +
					    "\nBooking ID: " + b.getBookingId()
					);
				room.setAvailablity(false);

			} else {
				System.out.println("Already booking exists for this guest id");
			}
		} else {
			System.out.println("Sorry " + roomType + "room not exists!");
		}

	}

	public void checkOut() {
		System.out.println("Enter Booking Id :");
		String bookingId = sc.nextLine();
		if(bookingsList.containsKey(bookingId)) {
			Booking b = bookingsList.get(bookingId);
			Guest g = b.getGuest();
			Room r = b.getRoom();
			g.setBookedStatus(false);
			r.setAvailablity(true);
			b.setCheckOutTime(LocalDateTime.now());
			checkedOutList.put(bookingId, b);
			bookingsList.remove(bookingId);
			System.out.println("Checkout done !!");
			System.out.println("See you again !!");
		}else {
			System.out.println("Invalid Booking id!!");
		}
	}
	
	public void showBookings() {
	    if (bookingsList.isEmpty()) {
	        System.out.println("No active bookings.");
	        return;
	    }

	    // Print header
	    System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-20s |\n",
	            "Booking ID", "Guest ID", "Guest Name", "Room ID", "Check-In Time");
	    System.out.println("------------------------------------------------------------------------------------------");

	    // Print each booking in table format
	    for (Booking b : bookingsList.values()) {
	        System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-20s |\n",
	                b.getBookingId(),
	                b.getGuestId(),
	                b.getGuest().getGuestName(),
	                b.getRoomId(),
	                b.getCheckInTime().toString());
	    }
	}
	
	public void showCheckedOutList() {
		// Print header
		if(checkedOutList.isEmpty()) {
			System.out.println("No check Outs !");
			return;
		}
	    System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-20s | %-20s |\n",
	            "Booking ID", "Guest ID", "Guest Name", "Room ID", "Check-In Time","Check-Out Time");
	    System.out.println("------------------------------------------------------------------------------------------");

	    // Print each booking in table format
	    for (Booking b : checkedOutList.values()) {
	        System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-20s | %-20s |\n",
	                b.getBookingId(),
	                b.getGuestId(),
	                b.getGuest().getGuestName(),
	                b.getRoomId(),
	                b.getCheckInTime().toString(),b.getCheckOutTime());
	    }
		
	}

}

