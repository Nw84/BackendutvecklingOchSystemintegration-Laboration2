package com.laboration2.laboration2.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboration2.laboration2.entity.Car;
import com.laboration2.laboration2.entity.ParkingOccasion;
import com.laboration2.laboration2.entity.ParkingSpace;
import com.laboration2.laboration2.entity.Person;
import com.laboration2.laboration2.repository.CarRepository;
import com.laboration2.laboration2.repository.ParkingOccasionRepository;
import com.laboration2.laboration2.repository.ParkingSpaceRepository;
import com.laboration2.laboration2.repository.PersonRepository;

@Service
public class ParkingOccasionServiceImpl implements ParkingOccasionService {


    @Autowired
    ParkingOccasionRepository parkingOccasionRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public ParkingOccasion getParkingOccasion(Long id) {
        return parkingOccasionRepository.findById(id).get();
    }

    @Override
    public ParkingOccasion saveParkingOccasion(LocalDateTime stopTime, Long carId, Long personId, Long parkingSpaceId) {
        Car car = carRepository.findById(carId).get();
        Person person = personRepository.findById(personId).get();
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId).get();
        LocalDateTime localDateTime = LocalDateTime.now();

        ParkingOccasion parkingOccasion = new ParkingOccasion(localDateTime, stopTime, "active", car, person, parkingSpace);



        return parkingOccasionRepository.save(parkingOccasion);
    }

    @Override
    public List<ParkingOccasion> getParkingOccasions() {
        return (List<ParkingOccasion>)parkingOccasionRepository.findAll();
    }
    

    //query string som hämtar where stoptime > currenttime, annars ändrar den status till expired
}