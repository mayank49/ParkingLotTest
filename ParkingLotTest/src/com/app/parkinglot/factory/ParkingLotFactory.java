package com.app.parkinglot.factory;

import com.app.parkinglot.models.AirportFeeModel;
import com.app.parkinglot.models.FeeModel;
import com.app.parkinglot.models.MallFeeModel;
import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.StadiumFeeModel;

public class ParkingLotFactory implements IParkingLotFactory {

	@Override
	public ParkingLot createParkingLot(int twoWheelerSpots, int lmvSpot, int hmvSpots, ParkingLotType parkingLotType) {
		if(parkingLotType == null) {
			throw new IllegalArgumentException("No parkingLotType was given");
		}
		
		FeeModel feeModel = null;
		switch (parkingLotType) {
		case SMALL:
		case MALL:
			feeModel = new MallFeeModel();
			break;
		case STADIUM:
			feeModel = new StadiumFeeModel();
			break;
		case AIRPORT:
			feeModel = new AirportFeeModel();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + parkingLotType);
		}
		return new ParkingLot(twoWheelerSpots, lmvSpot, hmvSpots, feeModel);
	}

}
