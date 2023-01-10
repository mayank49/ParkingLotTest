package com.app.parkinglot.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.app.parkinglot.models.fees.FlatRateOverridingInterval;
import com.app.parkinglot.models.fees.FlatRateVehicleFee;
import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.rates.ParkingRate;
import com.app.parkinglot.models.rates.RateByDay;
import com.app.parkinglot.models.rates.RateByHour;
import com.app.parkinglot.models.rates.StaticRate;
import com.app.parkinglot.operations.VehicleFeeServices;

public class VehicleFeeServicesTest {

	@Test
	public void testFlatRateVehicleFeeServices() throws Exception {
		VehicleFeeServices op = new VehicleFeeServices();
		ParkingRate pr = new RateByHour(10.00);
		FlatRateVehicleFee vf = new FlatRateVehicleFee(pr);
		assertEquals(100.00, op.computeVehicleFee(vf, 10), 0.00);
	}
	
	@Test
	public void testIntervalVehicleFeeServices() throws Exception {
		VehicleFeeServices op = new VehicleFeeServices();
		
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new HashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 1), new StaticRate(0));
		twoWheelerFeeIntervalMap.put(new IntervalRange(1, 8), new StaticRate(40));
		twoWheelerFeeIntervalMap.put(new IntervalRange(8, 24), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new FlatRateOverridingInterval(24), new RateByDay(80));
		
		IntervalVehicleFee vf = new IntervalVehicleFee(twoWheelerFeeIntervalMap);
		
		assertEquals(0.00, op.computeVehicleFee(vf, 1), 0.00);
		assertEquals(160.00, op.computeVehicleFee(vf, 36), 0.00);
	}
}
