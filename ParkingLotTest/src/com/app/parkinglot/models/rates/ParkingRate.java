package com.app.parkinglot.models.rates;

public abstract class ParkingRate {
	
	protected final double rate;

	protected ParkingRate(double rate) {
		super();
		this.rate = rate;
	}
	
	public abstract double computeAppliedFee(int hours);
}
