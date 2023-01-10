package com.app.parkinglot.test.behavior;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import com.app.parkinglot.factory.IParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotType;
import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.models.tickets.ParkingReceipt;
import com.app.parkinglot.models.tickets.ParkingTicket;
import com.app.parkinglot.operations.IParkingLotOperations;
import com.app.parkinglot.operations.ParkingLotOperations;

public class ApplicationTest_AirportParkingLot {

	@Test
	public void test_AirportParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		
		int twSpots = 100;
		int lmvSpots = 80;
		int hmvSpots = 10;
		
		ParkingLot parkingLot = factory.createParkingLot(twSpots, lmvSpots, hmvSpots, ParkingLotType.AIRPORT);
		
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		
		//Park Motorcycle for 55 minutes
		
		ParkingTicket t1 = operations.parkVehicle(VehicleType.TWH);
		ParkingReceipt r1 = operations.unparkVehicle(t1, t1.getEntryTime().plusMinutes(55));
		assertEquals(0.00, r1.getFees(), 0.00);
		
		//Park Motorcycle for 1 day and 12 hours
		
		ParkingTicket t2 = operations.parkVehicle(VehicleType.TWH);
		ParkingReceipt r2 = operations.unparkVehicle(t2, t2.getEntryTime().plusDays(1).plusHours(12));
		assertEquals(160.00, r2.getFees(), 0.00);
		
		
		//Park Car for 3 days and 1 hour
		
		ParkingTicket t3 = operations.parkVehicle(VehicleType.LMV);
		ParkingReceipt r3 = operations.unparkVehicle(t3, t3.getEntryTime().plusDays(3).plusHours(1));
		assertEquals(400.00, r3.getFees(), 0.00);
	}
}
