package com.example.demo.parking;

import com.example.demo.datalayer.SlotDetails;
import com.example.demo.to.*;

import java.util.List;


public class ParkingEntity implements IParking{

	@Override
	public List<ParkingSlot> getAllAvailableParkingSlot() {
		SlotDetails slotDetails = new SlotDetails();
		return slotDetails.getAllAvailableParkingSlot();
	}

	@Override
	public ParkingCost getParkingCost(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccessSlot setParkingSlot(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message setExit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message setEntry() {
		// TODO Auto-generated method stub
		return null;
	}

}
