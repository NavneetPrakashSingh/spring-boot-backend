package com.example.demo.vehicle;

import com.example.demo.datalayer.VehicleDetails;
import com.example.demo.to.Vehicle;

import java.util.List;


public class VehicleEntity implements IVehicle{

	@Override
	public Vehicle getVehicleDetails(int vehicleId) {
		VehicleDetails vehicleDetails = new VehicleDetails();
		List<Vehicle> vehicles = vehicleDetails.getAllVehicleDetails();
		return vehicles.get(vehicleId);
	}

	@Override
	public Boolean setVehicleDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> getAllVehicleDetails() {
		VehicleDetails vehicleDetails = new VehicleDetails();
		List<Vehicle> vehicles = vehicleDetails.getAllVehicleDetails();
		return vehicles;
	}

}
