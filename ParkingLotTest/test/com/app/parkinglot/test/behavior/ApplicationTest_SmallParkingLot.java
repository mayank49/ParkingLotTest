package com.app.parkinglot.test.behavior;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.app.parkinglot.exceptions.UnavailableParkingSpotException;
import com.app.parkinglot.factory.IParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotType;
import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.models.tickets.ParkingReceipt;
import com.app.parkinglot.models.tickets.ParkingTicket;
import com.app.parkinglot.operations.IParkingLotOperations;
import com.app.parkinglot.operations.ParkingLotOperations;

public class ApplicationTest_SmallParkingLot {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void test_SmallParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		
		int twSpots = 2;
		int lmvSpots = 0;
		int hmvSpots = 0;
		
		ParkingLot parkingLot = factory.createParkingLot(twSpots, lmvSpots, hmvSpots, ParkingLotType.SMALL);
		
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		
		//Park Motorcycle
		
		ParkingTicket t1 = operations.parkVehicle(VehicleType.TWH);
		
		//Park Scooter
		
		ParkingTicket t2 = operations.parkVehicle(VehicleType.TWH);
		
		//Park another Scooter
		
		exception.expect(UnavailableParkingSpotException.class);
		operations.parkVehicle(VehicleType.TWH);
		
		//Unpark scooter t2
		
		ParkingReceipt r2 = operations.unparkVehicle(t2, LocalDateTime.now());
		assertEquals(10.00, r2.getFees(), 0.00);
		
		//park another motorcycle
		
		ParkingTicket t3 = operations.parkVehicle(VehicleType.TWH);
		
		//Unpark motorcycle t1
		ParkingReceipt r1 = operations.unparkVehicle(t1, t1.getEntryTime().plusHours(4));
		assertEquals(40.00, r1.getFees(), 0.00);
		
	}
}
