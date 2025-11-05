package com.learn.hotel;

public class Room {
	private static int id_generator = 1;
	private String roomId;
	private String roomType;
	private int price;
	private boolean availablity;
	
	public Room(String roomType) {
		this.roomId = "R"+(id_generator++);
		this.roomType = roomType;
		this.price = (roomType.equals("single")?2000:4000);
		this.availablity = true;
	}
	
	public String getRoomId() {
		return roomId;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}
	
		
}
