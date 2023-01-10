package com.app.parkinglot.factory;

import java.time.LocalDateTime;

import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.models.tickets.ParkingTicket;

public class TicketFactory {

	public ParkingTicket createNewParkingTicket(int assignedSpot, int totalSpots, VehicleType vehicleType) {
		String ticketNumber = createTicketNumber(assignedSpot, totalSpots);
		LocalDateTime entryTime = LocalDateTime.now();
		return new ParkingTicket(ticketNumber, assignedSpot, entryTime, vehicleType);
	}
	
	private String createTicketNumber(int assignedSpot, int totalSpots) {
		int zerosToAdd = String.valueOf(totalSpots).length() - String.valueOf(assignedSpot).length();
		if(totalSpots < 100) {
			if(zerosToAdd < 1) {
				zerosToAdd = 2;
			} else {
				zerosToAdd = 1;
			}
		}
		StringBuilder builder = new StringBuilder();
		while(zerosToAdd > 0) {
			builder.append("0");
			zerosToAdd--;
		}
		builder.append(assignedSpot);
		return builder.toString();
	}
}
