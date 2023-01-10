package com.app.parkinglot.factory;

import java.time.LocalDateTime;

import com.app.parkinglot.models.tickets.ParkingReceipt;

public class RecieptFactory {
	
	public ParkingReceipt createNewParkingReceipt(String ticketNumber, LocalDateTime entryTime, LocalDateTime exitTime, double fee) {
		return new ParkingReceipt(createReceiptNumber(ticketNumber), entryTime, exitTime, fee);
	}

	private String createReceiptNumber(String ticketNumber) {
		return "R-" + ticketNumber;
	}
}
