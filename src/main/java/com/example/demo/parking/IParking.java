package com.example.demo.parking;

import com.example.demo.to.*;

import java.util.List;


public interface IParking {
	public List<ParkingSlot> getAllAvailableParkingSlot();
	public ParkingCost getParkingCost(Vehicle vehicle);
	public SuccessSlot setParkingSlot(Vehicle vehicle);
	public Message setExit();
	public Message setEntry();
}
