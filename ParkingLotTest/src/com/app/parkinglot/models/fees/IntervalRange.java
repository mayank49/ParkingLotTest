package com.app.parkinglot.models.fees;

public class IntervalRange {

	private final int startInterval;
	private final int endInterval;
	
	public IntervalRange(int startInterval, int endInterval) {
		super();
		this.startInterval = startInterval;
		this.endInterval = endInterval;
	}

	public int getStartInterval() {
		return startInterval;
	}

	public int getEndInterval() {
		return endInterval;
	}
}
