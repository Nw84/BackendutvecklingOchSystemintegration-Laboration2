package com.laboration2.laboration2.service;

import java.time.LocalDateTime;
import java.util.List;

import com.laboration2.laboration2.entity.ParkingOccasion;

public interface ParkingOccasionService {
    ParkingOccasion getParkingOccasion(Long id);
    ParkingOccasion saveParkingOccasion(LocalDateTime localDateTime, Long carId, Long personId, Long parkingSpaceId);
    ParkingOccasion updateParkingOccasion(LocalDateTime localDateTime, Long parkingOccasionId);
    void deleteParkingOccasion(Long id);
    List<ParkingOccasion> getParkingOccasions();
    List<ParkingOccasion> getOneByStatusAndPersonId(String status, Long id);
    List<ParkingOccasion> getOneByStatusAndCarId(String status, Long id);
    List<ParkingOccasion> getAllByStatus(String status);
}
