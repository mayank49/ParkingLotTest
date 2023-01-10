package com.app.parkinglot.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;

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

public class ParkingLotOperationsTest {

	@Test
	public void testParkVehicle_OneTypeSpotOnly() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		ParkingLot parkingLot = factory.createParkingLot(2, 0, 0, ParkingLotType.SMALL);
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		ParkingTicket ticket = operations.parkVehicle(VehicleType.TWH);
		assertEquals("001", ticket.getTicketNumber());
		assertEquals(1, ticket.getSpotNumber());
		assertNotNull(ticket.getEntryTime());
	}
	
	@Test
	public void testParkVehicle_MutlipleTypeSpots() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		ParkingLot parkingLot = factory.createParkingLot(2, 1000, 1, ParkingLotType.MALL);
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		ParkingTicket ticket = operations.parkVehicle(VehicleType.LMV);
		assertEquals("0001", ticket.getTicketNumber());
		assertEquals(1, ticket.getSpotNumber());
		assertNotNull(ticket.getEntryTime());
	}
	
	@Test(expected = UnavailableParkingSpotException.class)
	public void testParkVehicle_UnavailableSpot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		ParkingLot parkingLot = factory.createParkingLot(0, 0, 0, ParkingLotType.SMALL);
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		operations.parkVehicle(VehicleType.TWH);
	}
	
	@Test
	public void testUnparkVehicle() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		ParkingLot parkingLot = factory.createParkingLot(2, 0, 0, ParkingLotType.SMALL);
		IParkingLotOperations operations = new ParkingLotOperations(parkingLot);
		
		ParkingTicket ticket = new ParkingTicket("001", 1, LocalDateTime.now().minusSeconds(5), VehicleType.TWH);
		ParkingReceipt receipt = operations.unparkVehicle(ticket, LocalDateTime.now());
		assertEquals("R-001", receipt.getReceiptNumber());
		assertEquals(ticket.getEntryTime(), receipt.getEntryTime());
		assertNotNull(receipt.getExitTime());
		assertEquals(10.00, receipt.getFees(), 0.00);
		
		
		
		ticket = new ParkingTicket("001", 1, LocalDateTime.now().minusHours(10), VehicleType.TWH);
		receipt = operations.unparkVehicle(ticket, LocalDateTime.now());
		assertEquals("R-001", receipt.getReceiptNumber());
		assertEquals(ticket.getEntryTime(), receipt.getEntryTime());
		assertNotNull(receipt.getExitTime());
		assertEquals(100.00, receipt.getFees(), 0.00);
		
		
	}
}
