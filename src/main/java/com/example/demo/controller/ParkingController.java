package com.example.demo.controller;

import java.util.List;

import com.example.demo.parking.IParking;
import com.example.demo.parking.ParkingEntity;
import com.example.demo.to.ParkingSlot;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ParkingController {

    @RequestMapping(value = "/slots", method = RequestMethod.GET)
    public List<ParkingSlot> getAllSlots() {
        IParking parking = new ParkingEntity();
        return parking.getAllAvailableParkingSlot();
    }

}
