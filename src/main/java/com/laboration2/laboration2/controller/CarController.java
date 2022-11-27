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

import com.laboration2.laboration2.entity.Car;
import com.laboration2.laboration2.service.CarService;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCar(id), HttpStatus.OK);
    }

    @GetMapping("/car")
    public ResponseEntity <List<Car>> getCar() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

     @PostMapping("/car")
     public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.saveCar(car), HttpStatus.CREATED);
     }

     @GetMapping("/car/{personId}/{carId}")
     public ResponseEntity<Car> addOwner(@PathVariable Long personId, @PathVariable Long carId) {
        return new ResponseEntity<>(carService.addOwner(personId, carId), HttpStatus.OK);
     }

     
}
