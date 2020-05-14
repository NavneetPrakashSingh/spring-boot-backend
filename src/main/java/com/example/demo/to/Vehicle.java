package com.example.demo.to;

public class Vehicle {
	
	Integer vehicleId;
	VehicleEnum vehicleType;
	Boolean isElectric;
	String numberPlate;
	String vehicleModel;
	VehicleColor vehicleColor;
	
	
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public VehicleEnum getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleEnum vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Boolean getIsElectric() {
		return isElectric;
	}
	public void setIsElectric(Boolean isElectric) {
		this.isElectric = isElectric;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public VehicleColor getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(VehicleColor vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

}
