package com.app.parkinglot.models.fees;

public class FlatRateOverridingInterval extends IntervalRange {

	private final int minimumHours;
	
	public FlatRateOverridingInterval(int minimumHours) {
		super(-1, -1);
		this.minimumHours = minimumHours;
	}

	public int getMinimumHours() {
		return minimumHours;
	}
}
