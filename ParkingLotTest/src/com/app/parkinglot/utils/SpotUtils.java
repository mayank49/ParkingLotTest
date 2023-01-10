package com.app.parkinglot.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.app.parkinglot.models.VehicleType;

public class SpotUtils {

	private final Map<VehicleType, Set<Integer>> assignedSpotsMap;
	
	private final Map<VehicleType, Integer> maxSpotsMap;

	public SpotUtils(int twhSpots, int lmvSpots, int hmvSpots) {
		super();
		this.assignedSpotsMap = new HashMap<>();
		this.assignedSpotsMap.put(VehicleType.TWH, new HashSet<>());
		this.assignedSpotsMap.put(VehicleType.LMV, new HashSet<>());
		this.assignedSpotsMap.put(VehicleType.HMV, new HashSet<>());
		
		this.maxSpotsMap = new HashMap<>();
		this.maxSpotsMap.put(VehicleType.TWH, twhSpots);
		this.maxSpotsMap.put(VehicleType.LMV, lmvSpots);
		this.maxSpotsMap.put(VehicleType.HMV, hmvSpots);
	}
	
	public int getAssignedSpots(VehicleType vehicleType) {
		if(!assignedSpotsMap.containsKey(vehicleType)) {
			throw new IllegalArgumentException("Invalid value : " + vehicleType);
		}
		return assignedSpotsMap.get(vehicleType).size();
	}
	
	public int getMaxSpots(VehicleType vehicleType) {
		if(!maxSpotsMap.containsKey(vehicleType)) {
			throw new IllegalArgumentException("Invalid value : " + vehicleType);
		}
		return maxSpotsMap.get(vehicleType);
	}
	
	public int getAvailableSpot(VehicleType vehicleType) {
		if(!assignedSpotsMap.containsKey(vehicleType) || !maxSpotsMap.containsKey(vehicleType)) {
			throw new IllegalArgumentException("Invalid value : " + vehicleType);
		}
		Set<Integer> assignedSpots = assignedSpotsMap.get(vehicleType);
		for(int i = 1; i < maxSpotsMap.get(vehicleType); i++) {
			if(!assignedSpots.contains(i)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addToAssignedSpots(VehicleType vehicleType, int spot) {
		assignedSpotsMap.get(vehicleType).add(spot);
	}
	
	public void removeFromAssignedSpots(VehicleType vehicleType, int spot) {
		assignedSpotsMap.get(vehicleType).remove(spot);
	}
}
