package com.app.parkinglot.operations;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.app.parkinglot.exceptions.UnavailableParkingSpotException;
import com.app.parkinglot.exceptions.VehicleNotParkedException;
import com.app.parkinglot.factory.RecieptFactory;
import com.app.parkinglot.factory.TicketFactory;
import com.app.parkinglot.models.FeeModel;
import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.models.tickets.ParkingReceipt;
import com.app.parkinglot.models.tickets.ParkingTicket;
import com.app.parkinglot.utils.SpotUtils;

public class ParkingLotOperations implements IParkingLotOperations {
	
	private final ParkingLot parkingLot;
	private final TicketFactory ticketFactory;
	private final RecieptFactory recieptFactory;
	
	private final SpotUtils spotUtils;

	public ParkingLotOperations(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
		this.ticketFactory = new TicketFactory();
		this.recieptFactory = new RecieptFactory();
		this.spotUtils = new SpotUtils(parkingLot.getTwoWheelerSpots(), parkingLot.getLmvSpots(), parkingLot.getHmvSpots());
	}

	@Override
	public ParkingTicket parkVehicle(VehicleType vehicleType) throws UnavailableParkingSpotException {
		
		int maxSpots = spotUtils.getMaxSpots(vehicleType);
		int assignedSpots = spotUtils.getAssignedSpots(vehicleType);
		
		if(!hasAvailableSpot(assignedSpots, maxSpots)) {
			throw new UnavailableParkingSpotException("No parking spot available for " + vehicleType);
		}
		
		int assignedSpot = spotUtils.getAvailableSpot(vehicleType);
		ParkingTicket ticket = ticketFactory.createNewParkingTicket(assignedSpot, maxSpots, vehicleType);
		spotUtils.addToAssignedSpots(vehicleType, assignedSpot);
		return ticket;
	}

	@Override
	public ParkingReceipt unparkVehicle(ParkingTicket ticket, LocalDateTime exitTime) {
		LocalDateTime entryTime = ticket.getEntryTime();
		
		int hours = ChronoUnit.SECONDS.between(entryTime, exitTime) % 3600 == 0 
				?  (int) ChronoUnit.HOURS.between(entryTime, exitTime) : (int) ChronoUnit.HOURS.between(entryTime, exitTime) + 1;
		
		VehicleFeeServices feeServices = new VehicleFeeServices();
		double fee = feeServices.computeVehicleFee(getVehicleFee(ticket.getVehicleType()), hours);
		
		spotUtils.removeFromAssignedSpots(ticket.getVehicleType(), ticket.getSpotNumber());
		
		return recieptFactory.createNewParkingReceipt(ticket.getTicketNumber(), entryTime, exitTime, fee);
	}
	
	private boolean hasAvailableSpot(int assignedSpots, int maxSpots) {
		return assignedSpots < maxSpots;
	}
	
	private VehicleFee getVehicleFee(VehicleType vehicleType) {
		FeeModel feeModel = parkingLot.getFeeModel();
		switch (vehicleType) {
		case TWH:
			return feeModel.getTwoWheelerFeeModel();
		case LMV:
			return feeModel.getLMVFeeModel();
		case HMV:
			return feeModel.getHMVFeeModel();
		default:
			throw new IllegalArgumentException("Unexpected value: " + vehicleType);
		}
	}
}
