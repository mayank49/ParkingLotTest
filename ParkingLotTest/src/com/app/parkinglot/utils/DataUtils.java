package com.app.parkinglot.utils;

import java.util.HashMap;
import java.util.Map;

import com.app.parkinglot.models.fees.FlatRateOverridingInterval;
import com.app.parkinglot.models.fees.InfiniteInterval;
import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.rates.ParkingRate;
import com.app.parkinglot.models.rates.RateByDay;
import com.app.parkinglot.models.rates.RateByHour;
import com.app.parkinglot.models.rates.StaticRate;

public class DataUtils {

	public static Map<IntervalRange, ParkingRate> createNewTwoWheelerStadiumVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new HashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 4), new StaticRate(30));
		twoWheelerFeeIntervalMap.put(new IntervalRange(4, 12), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new InfiniteInterval(12), new RateByHour(100));
		
		return twoWheelerFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewLMVStadiumVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> lmvFeeIntervalMap = new HashMap<>();
		lmvFeeIntervalMap.put(new IntervalRange(0, 4), new StaticRate(60));
		lmvFeeIntervalMap.put(new IntervalRange(4, 12), new StaticRate(120));
		lmvFeeIntervalMap.put(new InfiniteInterval(12), new RateByHour(200));
		
		return lmvFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewTwoWheelerAirportVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new HashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 1), new StaticRate(0));
		twoWheelerFeeIntervalMap.put(new IntervalRange(1, 8), new StaticRate(40));
		twoWheelerFeeIntervalMap.put(new IntervalRange(8, 24), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new FlatRateOverridingInterval(24), new RateByDay(80));
		
		return twoWheelerFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewLMVAirportVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> lmvFeeIntervalMap = new HashMap<>();
		lmvFeeIntervalMap.put(new IntervalRange(0, 12), new StaticRate(60));
		lmvFeeIntervalMap.put(new IntervalRange(12, 24), new StaticRate(80));
		lmvFeeIntervalMap.put(new FlatRateOverridingInterval(24), new RateByDay(100));
		
		return lmvFeeIntervalMap;
	}
}
