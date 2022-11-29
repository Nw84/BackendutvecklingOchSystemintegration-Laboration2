package com.laboration2.laboration2.service;

import java.time.LocalDateTime;
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
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");

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
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");

        return (List<ParkingOccasion>)parkingOccasionRepository.findAll();
    }

    @Override
    public ParkingOccasion updateParkingOccasion(LocalDateTime stopTime, Long ParkingOccasionId) {
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");
        ParkingOccasion updateParkingOccasion = parkingOccasionRepository.findById(ParkingOccasionId).get();

        //Det stod att man skulle kunna flytta fram stopptiden, inte flytta bak den så lade till ett extra condition
       if(updateParkingOccasion.getStatus().equalsIgnoreCase("active") && (updateParkingOccasion.getStopTime()).compareTo(stopTime) < 0) {
            updateParkingOccasion.setStopTime(stopTime);
        }

        return parkingOccasionRepository.save(updateParkingOccasion);
    }
    
    @Override
    public List<ParkingOccasion> getAllByStatus(String status) {
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");

        return (List<ParkingOccasion>)parkingOccasionRepository.findByStatus(status);
    }

    @Override
    public List<ParkingOccasion> getOneByStatusAndPersonId(String status, Long id) {
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");

        return (List<ParkingOccasion>)parkingOccasionRepository.findByStatusAndPersonId(status, id);
    }

    @Override
    public List<ParkingOccasion> getOneByStatusAndCarId(String status, Long id) {
        LocalDateTime now = LocalDateTime.now();
        parkingOccasionRepository.updateStatus(now, "expired");

        return (List<ParkingOccasion>)parkingOccasionRepository.findByStatusAndCarId(status, id);
    }

    
    

    

}
