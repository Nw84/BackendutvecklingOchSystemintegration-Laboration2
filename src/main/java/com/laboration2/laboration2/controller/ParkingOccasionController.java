package com.laboration2.laboration2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.laboration2.laboration2.entity.ParkingOccasion;
import com.laboration2.laboration2.service.DateAndTimeService;
import com.laboration2.laboration2.service.ParkingOccasionService;

@RestController
public class ParkingOccasionController {

    @Autowired
    ParkingOccasionService parkingOccasionService;

    @Autowired 
    DateAndTimeService dateAndTimeService;


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
        if(dateAndTimeService.isInFuture(stopTime)) {
        return new ResponseEntity<>(parkingOccasionService.saveParkingOccasion(stopTime, carId, personId, parkingSpaceId), HttpStatus.CREATED);
        } 
        return ResponseEntity.notFound().build();
    }

    @PutMapping("parkingoccasion/update/{parkingOccasionId}")
    public ResponseEntity<ParkingOccasion> updateParkingOccasion(@RequestBody LocalDateTime stopTime, @PathVariable Long parkingOccasionId) {
        if(dateAndTimeService.isInFuture(stopTime)) {
        return new ResponseEntity<>(parkingOccasionService.updateParkingOccasion(stopTime, parkingOccasionId), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    } 

    @GetMapping("/parkingoccasion/active")
    public ResponseEntity<List<ParkingOccasion>> getActiveParkingOccasions() {
        return new ResponseEntity<>(parkingOccasionService.getAllByStatus("active"), HttpStatus.OK);
    }

    @GetMapping("/parkingoccasion/expired")
    public ResponseEntity<List<ParkingOccasion>> getExpiredParkingOccasions() {
        return new ResponseEntity<>(parkingOccasionService.getAllByStatus("expired"), HttpStatus.OK);
    }

    @GetMapping("/parkingoccasion/expired/person/{id}")
    public ResponseEntity<List<ParkingOccasion>> getExpiredParkingOccasionsForPerson(@PathVariable Long id) {
        return new ResponseEntity<>(parkingOccasionService.getOneByStatusAndPersonId("expired", id), HttpStatus.OK);
    }

    @GetMapping("/parkingoccasion/active/person/{id}")
    public ResponseEntity<List<ParkingOccasion>> getActiveParkingOccasionsForPerson(@PathVariable Long id) {
        return new ResponseEntity<>(parkingOccasionService.getOneByStatusAndPersonId("active", id), HttpStatus.OK);
    }

    @GetMapping("/parkingoccasion/expired/car/{id}")
    public ResponseEntity<List<ParkingOccasion>> getExpiredParkingOccasionsForCar(@PathVariable Long id) {
        return new ResponseEntity<>(parkingOccasionService.getOneByStatusAndCarId("expired", id), HttpStatus.OK);
    }

    @GetMapping("/parkingoccasion/active/car/{id}")
    public ResponseEntity<List<ParkingOccasion>> getActiveParkingOccasionsForCar(@PathVariable Long id) {
        return new ResponseEntity<>(parkingOccasionService.getOneByStatusAndCarId("active", id), HttpStatus.OK);
    }

}
