package com.laboration2.laboration2.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laboration2.laboration2.entity.ParkingOccasion;
import com.laboration2.laboration2.repository.ParkingOccasionRepository;

@RestController
public class ParkingOccasionController {

    ParkingOccasionRepository parkingOccasionRepository;

    public ParkingOccasionController(ParkingOccasionRepository parkingOccasionRepository) {
        this.parkingOccasionRepository = parkingOccasionRepository;
    }


    @PostMapping("/parkingoccasion")
    public ResponseEntity<ParkingOccasion> insertOne(@RequestBody ParkingOccasion parkingOccasion) {

        var newParking = parkingOccasionRepository.save(parkingOccasion);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newParking.getId())
                .toUri();

        return ResponseEntity.created(location).body(newParking);

    }


    @GetMapping("/parkingoccasion")
    public List<ParkingOccasion> allPoints() {
        return parkingOccasionRepository.findAll();
    }
    
}
