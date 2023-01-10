package com.app.parkinglot.models.fees;

import java.util.Map;

import com.app.parkinglot.models.rates.ParkingRate;

public class IntervalVehicleFee implements VehicleFee {

	private final Map<IntervalRange, ParkingRate> intervalFeeMap;

	public IntervalVehicleFee(Map<IntervalRange, ParkingRate> intervalFeeMap) {
		super();
		this.intervalFeeMap = intervalFeeMap;
	}

	public Map<IntervalRange, ParkingRate> getIntervalFeeMap() {
		return intervalFeeMap;
	}
}
