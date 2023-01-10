package com.app.parkinglot.models.tickets;

import java.time.LocalDateTime;

public class ParkingReceipt {

	private final String receiptNumber;
	
	private final LocalDateTime entryTime;
	
	private final LocalDateTime exitTime;
	
	private final double fees;

	public ParkingReceipt(String receiptNumber, LocalDateTime entryTime, LocalDateTime exitTime, double fees) {
		super();
		this.receiptNumber = receiptNumber;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.fees = fees;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public double getFees() {
		return fees;
	}
}
