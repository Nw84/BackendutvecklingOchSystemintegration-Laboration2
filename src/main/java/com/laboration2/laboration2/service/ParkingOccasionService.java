package com.laboration2.laboration2.service;

import java.util.List;

import com.laboration2.laboration2.entity.ParkingOccasion;

public interface ParkingOccasionService {
    ParkingOccasion getParkingOccasion(Long id);
    ParkingOccasion saveParkingOccasion(ParkingOccasion parkingOccasion);
    List<ParkingOccasion> getParkingOccasions();
}
