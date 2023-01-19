package com.app.parkinglot.models.fees;

public class IntervalRange {

	private final int startInterval;
	private final int endInterval;
	protected final boolean overriding;
	
	public IntervalRange(int startInterval, int endInterval, boolean overriding) {
		super();
		this.startInterval = startInterval;
		this.endInterval = endInterval;
		this.overriding = overriding;
	}

	public int getStartInterval() {
		return startInterval;
	}

	public int getEndInterval() {
		return endInterval;
	}

	public boolean isOverriding() {
		return overriding;
	}
}
