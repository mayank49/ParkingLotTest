package com.app.parkinglot.models;

import com.app.parkinglot.models.fees.FlatRateVehicleFee;
import com.app.parkinglot.models.fees.VehicleFee;
import com.app.parkinglot.models.rates.RateByHour;

public class MallFeeModel extends FeeModel {
	
	public MallFeeModel() {
		super();
		this.twoWheelerFeeModel = new FlatRateVehicleFee(new RateByHour(10));
		this.lmvFeeModel = new FlatRateVehicleFee(new RateByHour(20));
		this.hmvFeeModel = new FlatRateVehicleFee(new RateByHour(50));
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
