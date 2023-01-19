package com.app.parkinglot.factory;

import com.app.parkinglot.models.fees.FlatRateVehicleFee;
import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.operations.FlatRateVehicleFeeServices;
import com.app.parkinglot.operations.IntervalVehicleFeeServices;
import com.app.parkinglot.operations.VehicleFeeServices;

public class VehicleFeeServicesFactory implements IVehicleFeeServicesFactory {

	@Override
	public VehicleFeeServices createVehicleFeeServices(VehicleFee vehicleFee) {
		if(vehicleFee instanceof FlatRateVehicleFee) {
			return new FlatRateVehicleFeeServices((FlatRateVehicleFee) vehicleFee);
		} else if (vehicleFee instanceof IntervalVehicleFee) {
			return new IntervalVehicleFeeServices((IntervalVehicleFee) vehicleFee);
		} else {
			throw new IllegalArgumentException("Unknown vehicleFee type");
		}
	}
}
