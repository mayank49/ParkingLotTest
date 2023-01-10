package com.app.parkinglot.models;

import com.app.parkinglot.models.fees.VehicleFee;

public abstract class FeeModel {
	
	protected VehicleFee twoWheelerFeeModel;
	
	protected VehicleFee lmvFeeModel;
	
	protected VehicleFee hmvFeeModel;

	public abstract VehicleFee getTwoWheelerFeeModel();
	
	public abstract VehicleFee getLMVFeeModel();
	
	public abstract VehicleFee getHMVFeeModel();
	
}
