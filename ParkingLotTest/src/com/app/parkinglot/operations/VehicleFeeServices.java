package com.app.parkinglot.operations;

import com.app.parkinglot.models.fees.FlatRateOverridingInterval;
import com.app.parkinglot.models.fees.FlatRateVehicleFee;
import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.fees.IntervalVehicleFee;
import com.app.parkinglot.models.fees.VehicleFee;

public class VehicleFeeServices {
	
	public double computeVehicleFee(VehicleFee vehicleFee, int hours) {
		if(vehicleFee instanceof FlatRateVehicleFee) {
			return computeFlatRateVehicleFee((FlatRateVehicleFee) vehicleFee, hours);
		} else if (vehicleFee instanceof IntervalVehicleFee) {
			return computeIntervalVehicleFee((IntervalVehicleFee) vehicleFee, hours);
		} else {
			throw new IllegalArgumentException("Unknown vehicleFee type");
		}
	}
	
	private double computeFlatRateVehicleFee(FlatRateVehicleFee vehicleFee, int hours) {
		return vehicleFee.getParkingRate().computeAppliedFee(hours);
	}
	
	private double computeIntervalVehicleFee(IntervalVehicleFee vehicleFee, int hours) {
		double fee = 0;
		for(var e : vehicleFee.getIntervalFeeMap().entrySet()) {
			if(isOverridingInterval(e.getKey())) {
				if(isExceedingOverridingIntervalLimit(hours, ((FlatRateOverridingInterval)e.getKey()).getMinimumHours())) {
					 fee = e.getValue().computeAppliedFee(hours);
					 break;
				}
			} else if(e.getKey().getStartInterval() <= hours) {
				int applicableHours = getApplicableHours(e.getKey().getStartInterval(),
						e.getKey().getEndInterval(), hours);
				fee += e.getValue().computeAppliedFee(applicableHours);
			}
		}
		return fee;
	}
	
	private int getApplicableHours(int startInterval, int endInterval, int hours) {
		if(hours >= endInterval && endInterval != -1) {
			return endInterval - startInterval;
		} else {
			return hours - startInterval;
		}
	}
	
	private boolean isOverridingInterval(IntervalRange interval) {
		return interval instanceof FlatRateOverridingInterval;
	}
	
	private boolean isExceedingOverridingIntervalLimit(int hours, int overridingIntervalLimit) {
		return hours > overridingIntervalLimit;
	}
}
