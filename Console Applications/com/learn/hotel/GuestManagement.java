package com.learn.hotel;

import java.util.Scanner;

public class GuestManagement {
	
	Scanner sc = new Scanner(System.in);
	public Guest addGuest()
	{
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		System.out.println("Enter mobile Num : ");
		String num = sc.nextLine();
		Guest g = new Guest(name,num);
		System.out.println("Guest added with guest id : "+g.getGuestId());
		return g;
	}
}


