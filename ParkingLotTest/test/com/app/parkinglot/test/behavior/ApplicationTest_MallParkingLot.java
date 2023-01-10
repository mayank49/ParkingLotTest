package com.app.parkinglot.test.behavior;

import static org.junit.Assert.assertEquals;

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

public class ApplicationTest_MallParkingLot {

	@Test
	public void test_MallParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		
		int twSpots = 100;
		int lmvSpots = 80;
		int hmvSpots = 10;
		
		ParkingLot parkingLot = factory.createParkingLot(twSpots, lmvSpots, hmvSpots, ParkingLotType.MALL);
		
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		
		//Park Motorcycle for 3 hours and 30 minutes
		
		ParkingTicket t1 = operations.parkVehicle(VehicleType.TWH);
		ParkingReceipt r1 = operations.unparkVehicle(t1, t1.getEntryTime().plusHours(3).plusMinutes(30));
		assertEquals(40.00, r1.getFees(), 0.00);
		
		//Park Car for 6 hours and 1 minute
		
		ParkingTicket t2 = operations.parkVehicle(VehicleType.LMV);
		ParkingReceipt r2 = operations.unparkVehicle(t2, t2.getEntryTime().plusHours(6).plusMinutes(1));
		assertEquals(140.00, r2.getFees(), 0.00);
		
		//Park Truck for 1 hour 59 minutes
		
		ParkingTicket t3 = operations.parkVehicle(VehicleType.HMV);
		ParkingReceipt r3 = operations.unparkVehicle(t3, t3.getEntryTime().plusHours(1).plusMinutes(59));
		assertEquals(100.00, r3.getFees(), 0.00);
	}
}
