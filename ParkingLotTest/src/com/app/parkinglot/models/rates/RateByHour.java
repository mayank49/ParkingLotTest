package com.app.parkinglot.models.rates;

public class RateByHour extends ParkingRate {

	public RateByHour(double rate) {
		super(rate);
	}

	@Override
	public double computeAppliedFee(int hours) {
		return this.rate * hours;
	}
}
