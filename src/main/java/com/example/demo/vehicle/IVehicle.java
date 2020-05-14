package com.example.demo.vehicle;

import com.example.demo.to.Vehicle;

import java.util.List;


public interface IVehicle {
	public Vehicle getVehicleDetails(int vehicleId);
	public List<Vehicle> getAllVehicleDetails();
	public Boolean setVehicleDetails();
}
