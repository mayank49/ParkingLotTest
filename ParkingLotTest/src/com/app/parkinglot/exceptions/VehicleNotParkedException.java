package com.app.parkinglot.exceptions;

public class VehicleNotParkedException extends Exception {

	private static final long serialVersionUID = 3583332782974762288L;
	
	public VehicleNotParkedException(String message) {
		super(message);
	}

}
