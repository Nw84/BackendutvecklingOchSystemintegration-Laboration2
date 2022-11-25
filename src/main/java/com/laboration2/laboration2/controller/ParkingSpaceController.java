package com.laboration2.laboration2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laboration2.laboration2.entity.ParkingSpace;
import com.laboration2.laboration2.service.ParkingSpaceService;

@RestController
public class ParkingSpaceController {

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @GetMapping("/parkingspace/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpace(@PathVariable Long id) {
        return new ResponseEntity<>(parkingSpaceService.getParkingSpace(id), HttpStatus.OK);
    }

    @GetMapping("/parkingspace")
    public ResponseEntity <List<ParkingSpace>> getParkingSpace() {
        return new ResponseEntity<>(parkingSpaceService.getParkingSpaces(), HttpStatus.OK);
    }

     @PostMapping("/parkingspace")
     public ResponseEntity<ParkingSpace> saveParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        return new ResponseEntity<>(parkingSpaceService.saveParkingSpace(parkingSpace), HttpStatus.CREATED);
     }
    
}
