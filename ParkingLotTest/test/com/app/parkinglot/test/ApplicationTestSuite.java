package com.app.parkinglot.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.app.parkinglot.test.behavior.ApplicationTest_AirportParkingLot;
import com.app.parkinglot.test.behavior.ApplicationTest_MallParkingLot;
import com.app.parkinglot.test.behavior.ApplicationTest_SmallParkingLot;
import com.app.parkinglot.test.behavior.ApplicationTest_StadiumParkingLot;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ApplicationTest_SmallParkingLot.class,
	ApplicationTest_MallParkingLot.class,
	ApplicationTest_StadiumParkingLot.class,
	ApplicationTest_AirportParkingLot.class,
	ParkingLotFactoryTest.class,
	ParkingRateTest.class,
	VehicleFeeServicesTest.class,
	ParkingLotOperationsTest.class
})
public class ApplicationTestSuite {

}
