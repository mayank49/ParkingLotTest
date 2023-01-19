package com.app.parkinglot.models.fees;

public class InfiniteInterval extends IntervalRange {

	public InfiniteInterval(int startInterval, boolean overriding) {
		super(startInterval, -1, overriding);
	}

}
