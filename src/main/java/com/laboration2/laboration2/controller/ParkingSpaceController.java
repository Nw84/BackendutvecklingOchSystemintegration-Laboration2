package com.laboration2.laboration2.controller;

import java.net.URI;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laboration2.laboration2.entity.ParkingSpace;
import com.laboration2.laboration2.repository.ParkingSpaceRepository;

@RestController
public class ParkingSpaceController {

    ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceController(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }


    @PostMapping("/parkeringsplatser")
    public ResponseEntity<ParkingSpace> insertOne(@RequestBody ParkingSpace parkingSpace) {

        var newParkingSpace = parkingSpaceRepository.save(parkingSpace);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newParkingSpace.getId())
                .toUri();

        return ResponseEntity.created(location).body(newParkingSpace);

    }

    @GetMapping("/parkeringsplatser")
    public List<ParkingSpace> allPoints() {
        return parkingSpaceRepository.findAll();
    }

    @GetMapping("/parkeringsplatser/{id}")
     public ResponseEntity<ParkingSpace> getOne(@PathVariable("id") Long id) {
        var parking = parkingSpaceRepository.findById(id);

        if (parking.isPresent()) {
            Hibernate.initialize(parking.get().getName());
            return ResponseEntity.ok().body(parking.get());
        }
        return ResponseEntity.notFound().build();
     }
    
}
