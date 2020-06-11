package com.example.demo.PresentationLayer.controller;

import com.example.demo.businessLayer.to.NotificationTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @RequestMapping(value = "/postNotification", method = RequestMethod.POST)
    public ResponseEntity<?> storeNotification(@RequestBody List<NotificationTO> listOfNotifications){
        return ResponseEntity.ok(listOfNotifications);
    }
}
