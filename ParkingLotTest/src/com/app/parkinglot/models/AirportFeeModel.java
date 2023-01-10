package com.app.parkinglot.models;

import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.utils.DataUtils;

public class AirportFeeModel extends FeeModel {

	public AirportFeeModel() {
		super();
		this.twoWheelerFeeModel = new IntervalVehicleFee(DataUtils.createNewTwoWheelerAirportVehicleFeeModel());
		this.lmvFeeModel = new IntervalVehicleFee(DataUtils.createNewLMVAirportVehicleFeeModel());
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
