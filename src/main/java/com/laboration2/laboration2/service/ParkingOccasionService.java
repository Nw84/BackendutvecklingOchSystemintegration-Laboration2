package com.laboration2.laboration2.service;

import java.time.LocalDateTime;
import java.util.List;

import com.laboration2.laboration2.entity.ParkingOccasion;

public interface ParkingOccasionService {
    ParkingOccasion getParkingOccasion(Long id);
    ParkingOccasion saveParkingOccasion(LocalDateTime localDateTime, Long carId, Long personId, Long parkingSpaceId);
    ParkingOccasion updateParkingOccasion(LocalDateTime localDateTime, Long parkingOccasionId);
    List<ParkingOccasion> getParkingOccasions();
    List<ParkingOccasion> getByStatus(String status);
}
