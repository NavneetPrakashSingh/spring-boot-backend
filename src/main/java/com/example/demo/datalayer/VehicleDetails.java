package com.example.demo.datalayer;

import com.example.demo.to.Vehicle;
import com.example.demo.to.VehicleColor;
import com.example.demo.to.VehicleEnum;

import java.util.ArrayList;
import java.util.List;


public class VehicleDetails {
	public List<Vehicle> getAllVehicleDetails(){
		List<Vehicle> vehicleList = new ArrayList<>();
		Vehicle firstVehicle = new Vehicle();
		firstVehicle.setVehicleId(1);
		firstVehicle.setVehicleModel("Chevy Sonic");
		firstVehicle.setIsElectric(false);
		firstVehicle.setVehicleColor(VehicleColor.GREEN);
		firstVehicle.setVehicleType(VehicleEnum.CAR);
		firstVehicle.setNumberPlate("B 1234 AB");
		
		Vehicle secondVehicle = new Vehicle();
		secondVehicle.setVehicleId(2);
		secondVehicle.setVehicleModel("Ford Fiesta");
		secondVehicle.setIsElectric(false);
		secondVehicle.setVehicleColor(VehicleColor.BLACK);
		secondVehicle.setVehicleType(VehicleEnum.CAR);
		secondVehicle.setNumberPlate("B 1234 AC");
		
		Vehicle thirdVehicle = new Vehicle();
		thirdVehicle.setVehicleId(3);
		thirdVehicle.setVehicleModel("Ford Fusion");
		thirdVehicle.setIsElectric(false);
		thirdVehicle.setVehicleColor(VehicleColor.RED);
		thirdVehicle.setVehicleType(VehicleEnum.CAR);
		thirdVehicle.setNumberPlate("B 1234 AD");
		
		Vehicle fourthVechicle = new Vehicle();
		fourthVechicle.setVehicleId(4);
		fourthVechicle.setVehicleModel("Harley-Davidson");
		fourthVechicle.setIsElectric(false);
		fourthVechicle.setVehicleColor(VehicleColor.WHITE);
		fourthVechicle.setVehicleType(VehicleEnum.BIKE);
		fourthVechicle.setNumberPlate("B 1234 AE");
		
		Vehicle fifthVehicle = new Vehicle();
		fifthVehicle.setVehicleId(5);
		fifthVehicle.setVehicleModel("Nissan Navara");
		fifthVehicle.setIsElectric(false);
		fifthVehicle.setVehicleColor(VehicleColor.PURPLE);
		fifthVehicle.setVehicleType(VehicleEnum.TRUCK);
		fifthVehicle.setNumberPlate("B 1234 AF");
		
		vehicleList.add(firstVehicle);
		vehicleList.add(secondVehicle);
		vehicleList.add(thirdVehicle);
		vehicleList.add(fourthVechicle);
		vehicleList.add(fifthVehicle);
		
		return vehicleList;
		
	}

}
