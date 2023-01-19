package com.app.parkinglot.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.app.parkinglot.models.fees.FlatRateVehicleFee;
import com.app.parkinglot.models.fees.InfiniteInterval;
import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.rates.ParkingRate;
import com.app.parkinglot.models.rates.RateByDay;
import com.app.parkinglot.models.rates.RateByHour;
import com.app.parkinglot.models.rates.StaticRate;
import com.app.parkinglot.operations.FlatRateVehicleFeeServices;
import com.app.parkinglot.operations.IntervalVehicleFeeServices;
import com.app.parkinglot.operations.VehicleFeeServices;

public class VehicleFeeServicesTest {

	@Test
	public void testFlatRateVehicleFeeServices() throws Exception {
		ParkingRate pr = new RateByHour(10.00);
		FlatRateVehicleFee vf = new FlatRateVehicleFee(pr);
		VehicleFeeServices op = new FlatRateVehicleFeeServices(vf);
		assertEquals(100.00, op.computeVehicleFee(10), 0.00);
	}
	
	@Test
	public void testIntervalVehicleFeeServices() throws Exception {
		
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new LinkedHashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 1, false), new StaticRate(0));
		twoWheelerFeeIntervalMap.put(new IntervalRange(1, 8, false), new StaticRate(40));
		twoWheelerFeeIntervalMap.put(new IntervalRange(8, 24, false), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new InfiniteInterval(24, true), new RateByDay(80));
		
		IntervalVehicleFee vf = new IntervalVehicleFee(twoWheelerFeeIntervalMap);
		
		VehicleFeeServices op = new IntervalVehicleFeeServices(vf);
		
		assertEquals(0.00, op.computeVehicleFee(1), 0.00);
		assertEquals(160.00, op.computeVehicleFee(36), 0.00);
	}
}
