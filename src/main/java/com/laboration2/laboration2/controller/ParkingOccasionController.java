package com.laboration2.laboration2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.laboration2.laboration2.entity.ParkingOccasion;
import com.laboration2.laboration2.service.ParkingOccasionService;

@RestController
public class ParkingOccasionController {

    @Autowired
    ParkingOccasionService parkingOccasionService;


    @GetMapping("/parkingoccasion/{id}")
    public ResponseEntity<ParkingOccasion> getParkingOccasion(@PathVariable Long id) {
        return new ResponseEntity<>(parkingOccasionService.getParkingOccasion(id), HttpStatus.OK);
    }

 
    @GetMapping("/parkingoccasion")
    public ResponseEntity<List<ParkingOccasion>> getParkingOccasions() {
        return new ResponseEntity<>(parkingOccasionService.getParkingOccasions(), HttpStatus.OK);
    }



    @PostMapping("/parkingoccasion/{carId}/{personId}/{parkingSpaceId}")
    public ResponseEntity<ParkingOccasion> saveParkingOccasion(@RequestBody LocalDateTime stopTime, @PathVariable Long carId, @PathVariable Long personId, @PathVariable Long parkingSpaceId) {
        return new ResponseEntity<>(parkingOccasionService.saveParkingOccasion(stopTime, carId, personId, parkingSpaceId), HttpStatus.CREATED);
    }
}
