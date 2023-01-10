package com.app.parkinglot.models.rates;

public class RateByDay extends ParkingRate {

	public RateByDay(double rate) {
		super(rate);
	}

	@Override
	public double computeAppliedFee(int hours) {
		if(hours < 1) {
			return 0;
		}
		if(hours < 24) {
			return this.rate;
		} else {
			int days = Math.ceilDiv(hours, 24);
			return this.rate * days;
		}
	}
}
