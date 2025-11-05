package com.learn.hotel;

public class Guest {	
	private static int id_generator = 1;
	private String guestId;
	private String guestName;
	private String mbleNum;
	private boolean bookedStatus;
	
	public Guest(String guestName, String mbleNum) {
		this.guestId = "G"+(id_generator++);
		this.guestName = guestName;
		this.mbleNum = mbleNum;
	}

	public String getGuestId() {
		return guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getMbleNum() {
		return mbleNum;
	}

	public void setMbleNum(String mbleNum) {
		this.mbleNum = mbleNum;
	}

	public boolean getBookedStatus() {
		return bookedStatus;
	}

	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}
	
		
}
