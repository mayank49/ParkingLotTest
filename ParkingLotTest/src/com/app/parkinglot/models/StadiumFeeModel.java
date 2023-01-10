package com.app.parkinglot.models;

import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.utils.DataUtils;

public class StadiumFeeModel extends FeeModel {
	
	public StadiumFeeModel() {
		super();
		this.twoWheelerFeeModel = new IntervalVehicleFee(DataUtils.createNewTwoWheelerStadiumVehicleFeeModel());
		this.lmvFeeModel = new IntervalVehicleFee(DataUtils.createNewLMVStadiumVehicleFeeModel());
	}

	@Override
	public VehicleFee getTwoWheelerFeeModel() {
		return twoWheelerFeeModel;
	}

	@Override
	public VehicleFee getLMVFeeModel() {
		return lmvFeeModel;
	}

	@Override
	public VehicleFee getHMVFeeModel() {
		return hmvFeeModel;
	}

}
