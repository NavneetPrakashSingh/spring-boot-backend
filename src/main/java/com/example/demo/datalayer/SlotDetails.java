package com.example.demo.datalayer;

import com.example.demo.to.ParkingSlot;

import java.util.LinkedList;
import java.util.List;



public class SlotDetails {
	public List<ParkingSlot> getAllAvailableParkingSlot(){
		List<ParkingSlot> slotList = new LinkedList<>();
		
		ParkingSlot slotOne = new ParkingSlot();
		slotOne.setSlotNumber(1);
		slotOne.setAvailablity(true);
		slotList.add(slotOne);
		
		ParkingSlot slotTwo = new ParkingSlot();
		slotTwo.setSlotNumber(2);
		slotTwo.setAvailablity(false);
		slotList.add(slotTwo);
		
		ParkingSlot slotThree = new ParkingSlot();
		slotThree.setSlotNumber(3);
		slotThree.setAvailablity(true);
		slotList.add(slotThree);
		
		ParkingSlot slotFour = new ParkingSlot();
		slotFour.setSlotNumber(4);
		slotFour.setAvailablity(false);
		slotList.add(slotFour);
		
		ParkingSlot slotFive = new ParkingSlot();
		slotFive.setSlotNumber(5);
		slotFive.setAvailablity(true);
		slotList.add(slotFive);
		
		ParkingSlot slotSix = new ParkingSlot();
		slotSix.setSlotNumber(6);
		slotSix.setAvailablity(false);
		slotList.add(slotSix);
		
		ParkingSlot slotSeven = new ParkingSlot();
		slotSeven.setSlotNumber(7);
		slotSeven.setAvailablity(true);
		slotList.add(slotSeven);
		
		return slotList;
	}

}
