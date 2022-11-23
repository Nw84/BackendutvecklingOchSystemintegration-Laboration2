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

import com.laboration2.laboration2.entity.ParkeringsPlatser;
import com.laboration2.laboration2.repository.ParkeringsPlatserRepository;

@RestController
public class ParkeringsPlatserController {

    ParkeringsPlatserRepository parkeringsPlatserRepository;

    public ParkeringsPlatserController(ParkeringsPlatserRepository parkeringsPlatserRepository) {
        this.parkeringsPlatserRepository = parkeringsPlatserRepository;
    }


    @PostMapping("/parkeringsplatser")
    public ResponseEntity<ParkeringsPlatser> insertOne(@RequestBody ParkeringsPlatser parkeringsplatser) {

        var nyParkeringsPlats = parkeringsPlatserRepository.save(parkeringsplatser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nyParkeringsPlats.getId())
                .toUri();

        return ResponseEntity.created(location).body(nyParkeringsPlats);

    }

    @GetMapping("/parkeringsplatser")
    public List<ParkeringsPlatser> allPoints() {
        return parkeringsPlatserRepository.findAll();
    }

    @GetMapping("/parkeringsplatser/{id}")
     public ResponseEntity<ParkeringsPlatser> getOne(@PathVariable("id") Long id) {
        var parkering = parkeringsPlatserRepository.findById(id);

        if (parkering.isPresent()) {
            Hibernate.initialize(parkering.get().getName());
            return ResponseEntity.ok().body(parkering.get());
        }
        return ResponseEntity.notFound().build();
     }
    
}
