package com.app.parkinglot.operations;

import java.time.LocalDateTime;

import com.app.parkinglot.exceptions.UnavailableParkingSpotException;
import com.app.parkinglot.exceptions.VehicleNotParkedException;
import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.models.tickets.ParkingReceipt;
import com.app.parkinglot.models.tickets.ParkingTicket;

public interface IParkingLotOperations {

	public ParkingTicket parkVehicle(VehicleType vehicleType) throws UnavailableParkingSpotException;
	
	public ParkingReceipt unparkVehicle(ParkingTicket ticket, LocalDateTime exitTime);
}
