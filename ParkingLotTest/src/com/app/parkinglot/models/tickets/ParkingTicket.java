package com.app.parkinglot.models.tickets;

import java.time.LocalDateTime;

import com.app.parkinglot.models.VehicleType;

public class ParkingTicket {

	private final String ticketNumber;
	
	private final int spotNumber;
	
	private final LocalDateTime entryTime;
	
	private final VehicleType vehicleType;

	public ParkingTicket(String ticketNumber, int spotNumber, LocalDateTime entryTime, VehicleType vehicleType) {
		super();
		this.ticketNumber = ticketNumber;
		this.spotNumber = spotNumber;
		this.entryTime = entryTime;
		this.vehicleType = vehicleType;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
