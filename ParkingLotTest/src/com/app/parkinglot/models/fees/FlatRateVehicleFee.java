package com.app.parkinglot.models.fees;

import com.app.parkinglot.models.rates.ParkingRate;

public class FlatRateVehicleFee implements VehicleFee {
	
	private final ParkingRate parkingRate;

	public FlatRateVehicleFee(ParkingRate parkingRate) {
		super();
		this.parkingRate = parkingRate;
	}

	public ParkingRate getParkingRate() {
		return parkingRate;
	}
}
