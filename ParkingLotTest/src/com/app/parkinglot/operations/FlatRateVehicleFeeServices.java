package com.app.parkinglot.operations;

import com.app.parkinglot.models.fees.FlatRateVehicleFee;

public class FlatRateVehicleFeeServices implements VehicleFeeServices {

	private final FlatRateVehicleFee vehicleFee;

	public FlatRateVehicleFeeServices(FlatRateVehicleFee vehicleFee) {
		super();
		this.vehicleFee = vehicleFee;
	}
	
	public double computeVehicleFee(int hours) {
		return vehicleFee.getParkingRate().computeAppliedFee(hours);
	}
}
