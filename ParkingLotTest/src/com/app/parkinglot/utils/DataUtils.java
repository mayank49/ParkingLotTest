package com.app.parkinglot.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.app.parkinglot.models.fees.InfiniteInterval;
import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.rates.ParkingRate;
import com.app.parkinglot.models.rates.RateByDay;
import com.app.parkinglot.models.rates.RateByHour;
import com.app.parkinglot.models.rates.StaticRate;

public class DataUtils {

	public static Map<IntervalRange, ParkingRate> createNewTwoWheelerStadiumVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new LinkedHashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 4, false), new StaticRate(30));
		twoWheelerFeeIntervalMap.put(new IntervalRange(4, 12, false), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new InfiniteInterval(12, false), new RateByHour(100));
		
		return twoWheelerFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewLMVStadiumVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> lmvFeeIntervalMap = new LinkedHashMap<>();
		lmvFeeIntervalMap.put(new IntervalRange(0, 4, false), new StaticRate(60));
		lmvFeeIntervalMap.put(new IntervalRange(4, 12, false), new StaticRate(120));
		lmvFeeIntervalMap.put(new InfiniteInterval(12, false), new RateByHour(200));
		
		return lmvFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewTwoWheelerAirportVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> twoWheelerFeeIntervalMap = new LinkedHashMap<>();
		twoWheelerFeeIntervalMap.put(new IntervalRange(0, 1, false), new StaticRate(0));
		twoWheelerFeeIntervalMap.put(new IntervalRange(1, 8, false), new StaticRate(40));
		twoWheelerFeeIntervalMap.put(new IntervalRange(8, 24, false), new StaticRate(60));
		twoWheelerFeeIntervalMap.put(new InfiniteInterval(24, true), new RateByDay(80));
		
		return twoWheelerFeeIntervalMap;
	}
	
	public static Map<IntervalRange, ParkingRate> createNewLMVAirportVehicleFeeModel() {
		Map<IntervalRange, ParkingRate> lmvFeeIntervalMap = new LinkedHashMap<>();
		lmvFeeIntervalMap.put(new IntervalRange(0, 12, false), new StaticRate(60));
		lmvFeeIntervalMap.put(new IntervalRange(12, 24, false), new StaticRate(80));
		lmvFeeIntervalMap.put(new InfiniteInterval(24, true), new RateByDay(100));
		
		return lmvFeeIntervalMap;
	}
}
