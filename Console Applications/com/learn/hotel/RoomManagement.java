package com.learn.hotel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class RoomManagement {
	private List<Room> singleAvailRoom = new ArrayList<>();
	private List<Room> doubleAvailRoom = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void addRoom() {
		System.out.println("Enter room type : ");
		Room r = new Room(sc.nextLine().trim().toLowerCase());
		if (r.getRoomType().equals("single"))
			singleAvailRoom.add(r);
		else
			doubleAvailRoom.add(r);
		System.out.println("Room Added successfully !!");
	}

	public boolean checkAvailibility(String roomType) {
		if (roomType.equals("single") && singleAvailRoom.size() != 0)
			return true;
		if (roomType.equals("double") && doubleAvailRoom.size() != 0)
			return true;
		return false;
	}
	
	public Room getAvailableRoom(String roomType)
	{
		if(roomType.equals("single"))
			return singleAvailRoom.remove(0);
		if(roomType.equals("double"))
			return doubleAvailRoom.remove(0);
		return null;
	}
}
