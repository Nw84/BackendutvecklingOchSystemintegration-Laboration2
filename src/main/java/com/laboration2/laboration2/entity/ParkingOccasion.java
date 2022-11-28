package com.laboration2.laboration2.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ParkingOccasion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime startTime; 

    private LocalDateTime stopTime;

    private String status; 

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;


    @ManyToOne
    @JoinColumn(name = "parkingspace_id", referencedColumnName = "id")
    private ParkingSpace parkingSpace;


    public ParkingOccasion(LocalDateTime startTime, LocalDateTime stopTime, String status, Car car,
            Person person, ParkingSpace parkingSpace) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.status = status;
        this.car = car;
        this.person = person;
        this.parkingSpace = parkingSpace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    } 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }


}
