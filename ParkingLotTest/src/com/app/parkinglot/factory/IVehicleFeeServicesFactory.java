package com.app.parkinglot.factory;

import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.operations.VehicleFeeServices;

public interface IVehicleFeeServicesFactory {

	public VehicleFeeServices createVehicleFeeServices(VehicleFee vehicleFee);
}
