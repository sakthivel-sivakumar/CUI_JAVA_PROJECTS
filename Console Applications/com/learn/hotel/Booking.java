package com.learn.hotel;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Booking{
	private static int id_generator = 1;
	private String bookingId;
	private String guestId;
	private String roomId;
	private Guest guest;
	private Room room;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	private int totalBill;
	
	
	public Booking() {
		
	}
	
	public Booking(Guest guest,Room room,String guestId, String roomId, LocalDateTime checkInTime) {
		this.guest = guest;
		this.room = room;
		this.bookingId = "BK"+(id_generator++);
		this.guestId = guestId;
		this.roomId = roomId;
		this.checkInTime = checkInTime;
	}
		
	public String getBookingId() {
		return bookingId;
	}


	public String getGuestId() {
		return guestId;
	}


	public String getRoomId() {
		return roomId;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}
