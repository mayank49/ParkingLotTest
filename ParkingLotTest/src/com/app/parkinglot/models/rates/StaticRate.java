package com.app.parkinglot.models.rates;

public class StaticRate extends ParkingRate {

	public StaticRate(double rate) {
		super(rate);
	}

	@Override
	public double computeAppliedFee(int hours) {
		if(hours < 1) {
			return 0;
		}
		return this.rate;
	}
}
