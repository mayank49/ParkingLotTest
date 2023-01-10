package com.app.parkinglot.models;

public class ParkingLot {

	private final int twoWheelerSpots;
	
	private final int lmvSpots;
	
	private final int hmvSpots;
	
	private final FeeModel feeModel;

	public ParkingLot(int twoWheelerSpots, int lmvSpots, int hmvSpots, FeeModel feeModel) {
		super();
		this.twoWheelerSpots = twoWheelerSpots;
		this.lmvSpots = lmvSpots;
		this.hmvSpots = hmvSpots;
		this.feeModel = feeModel;
	}

	public int getTwoWheelerSpots() {
		return twoWheelerSpots;
	}

	public int getLmvSpots() {
		return lmvSpots;
	}

	public int getHmvSpots() {
		return hmvSpots;
	}

	public FeeModel getFeeModel() {
		return feeModel;
	}
	
	
}
