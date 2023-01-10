package com.app.parkinglot.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.app.parkinglot.factory.IParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotFactory;
import com.app.parkinglot.factory.ParkingLotType;
import com.app.parkinglot.models.AirportFeeModel;
import com.app.parkinglot.models.MallFeeModel;
import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.StadiumFeeModel;

public class ParkingLotFactoryTest {

	@Test
	public void testCreateSmallParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		int twSpots = 2;
		ParkingLot lot = factory.createParkingLot(twSpots, 0, 0, ParkingLotType.SMALL);
		assertEquals(twSpots, lot.getTwoWheelerSpots());
		assertEquals(MallFeeModel.class, lot.getFeeModel().getClass());
	}
	
	@Test
	public void testCreateMallParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		int twSpots = 100;
		int lmvSpots = 80;
		int hmvSpots = 10;
		ParkingLot lot = factory.createParkingLot(twSpots, lmvSpots, hmvSpots, ParkingLotType.MALL);
		assertEquals(twSpots, lot.getTwoWheelerSpots());
		assertEquals(lmvSpots, lot.getLmvSpots());
		assertEquals(hmvSpots, lot.getHmvSpots());
		assertEquals(MallFeeModel.class, lot.getFeeModel().getClass());
	}
	
	@Test
	public void testCreateStadiumParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		int twSpots = 1000;
		int lmvSpots = 1500;
		ParkingLot lot = factory.createParkingLot(twSpots, lmvSpots, 0, ParkingLotType.STADIUM);
		assertEquals(twSpots, lot.getTwoWheelerSpots());
		assertEquals(lmvSpots, lot.getLmvSpots());
		assertEquals(StadiumFeeModel.class, lot.getFeeModel().getClass());
	}
	
	@Test
	public void testCreateAirportParkingLot() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		int twSpots = 200;
		int lmvSpots = 500;
		int hmvSpots = 100;
		ParkingLot lot = factory.createParkingLot(twSpots, lmvSpots, hmvSpots, ParkingLotType.AIRPORT);
		assertEquals(twSpots, lot.getTwoWheelerSpots());
		assertEquals(lmvSpots, lot.getLmvSpots());
		assertEquals(hmvSpots, lot.getHmvSpots());
		assertEquals(AirportFeeModel.class, lot.getFeeModel().getClass());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateParkingLot_NullType() throws Exception {
		IParkingLotFactory factory = new ParkingLotFactory();
		factory.createParkingLot(0, 0, 0, null);
	}
}
