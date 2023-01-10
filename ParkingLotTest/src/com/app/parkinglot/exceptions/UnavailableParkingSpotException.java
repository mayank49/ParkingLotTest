package com.app.parkinglot.exceptions;

public class UnavailableParkingSpotException extends Exception {

	private static final long serialVersionUID = -1172679888382198234L;
	
	public UnavailableParkingSpotException(String message) {
		super(message);
	}

}
