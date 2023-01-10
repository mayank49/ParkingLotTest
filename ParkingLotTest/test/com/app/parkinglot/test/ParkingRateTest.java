package com.app.parkinglot.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.app.parkinglot.models.rates.ParkingRate;
import com.app.parkinglot.models.rates.RateByDay;
import com.app.parkinglot.models.rates.RateByHour;
import com.app.parkinglot.models.rates.StaticRate;

public class ParkingRateTest {

	@Test
	public void testStaticRate() throws Exception {
		ParkingRate pr = new StaticRate(10.00);
		assertEquals(0.00, pr.computeAppliedFee(0), 0.00);
		assertEquals(10.00, pr.computeAppliedFee(1), 0.00);
	}
	
	@Test
	public void testRateByHour() throws Exception {
		ParkingRate pr = new RateByHour(10.00);
		assertEquals(0.00, pr.computeAppliedFee(0), 0.00);
		assertEquals(10.00, pr.computeAppliedFee(1), 0.00);
		assertEquals(100.00, pr.computeAppliedFee(10), 0.00);
	}
	
	@Test
	public void testRateByDay() throws Exception {
		ParkingRate pr = new RateByDay(10.00);
		assertEquals(0.00, pr.computeAppliedFee(0), 0.00);
		assertEquals(10.00, pr.computeAppliedFee(1), 0.00);
		assertEquals(100.00, pr.computeAppliedFee(240), 0.00);
	}
}
