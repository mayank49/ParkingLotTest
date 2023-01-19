package com.app.parkinglot.operations;

import com.app.parkinglot.models.fees.IntervalRange;
import com.app.parkinglot.models.fees.IntervalVehicleFee;

public class IntervalVehicleFeeServices implements VehicleFeeServices {

	private final IntervalVehicleFee vehicleFee;

	public IntervalVehicleFeeServices(IntervalVehicleFee vehicleFee) {
		super();
		this.vehicleFee = vehicleFee;
	}
	
	public double computeVehicleFee(int hours) {
		double fee = 0;
		
		for(var e : vehicleFee.getIntervalFeeMap().entrySet()) {
			 
			if(e.getKey().getStartInterval() <= hours) {
				int applicableHours = getApplicableHours(e.getKey(), hours);
				
				if(isOverridingInterval(e.getKey())) {
					fee = 0.0;
				}
				
				fee += e.getValue().computeAppliedFee(applicableHours);
			}
		}
		return fee;
	}
	
	private int getApplicableHours(IntervalRange interval, int hours) {
		
		int startInterval = interval.getStartInterval();
		int endInterval = interval.getEndInterval();
		
		if(hours >= endInterval && endInterval != -1) {
			return isOverridingInterval(interval) ? hours - endInterval : endInterval - startInterval;
		} else {
			return isOverridingInterval(interval) ? hours : hours - startInterval;
		}
	}
	
	private boolean isOverridingInterval(IntervalRange interval) {
		return interval.isOverriding();
	}
}
