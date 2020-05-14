package com.example.demo.controller;

import com.example.demo.to.Vehicle;
import com.example.demo.vehicle.IVehicle;
import com.example.demo.vehicle.VehicleEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class VehicleController {

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public Vehicle getVehicleDetails(@PathVariable Integer id) {
        IVehicle vehicle = new VehicleEntity();
        return vehicle.getVehicleDetails(id);
    }

}
