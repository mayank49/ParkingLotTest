package com.app.parkinglot.factory;

import com.app.parkinglot.models.ParkingLot;

public interface IParkingLotFactory {

	ParkingLot createParkingLot(int twoWheelerSpots, int lmvSpot, int hmvSpots, ParkingLotType parkingLotType);
}
