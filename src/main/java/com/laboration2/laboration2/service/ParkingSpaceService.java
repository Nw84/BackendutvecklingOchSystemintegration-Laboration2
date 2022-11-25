package com.laboration2.laboration2.service;

import java.util.List;

import com.laboration2.laboration2.entity.ParkingSpace;

public interface ParkingSpaceService {
    ParkingSpace getParkingSpace(Long id);
    ParkingSpace saveParkingSpace(ParkingSpace parkingSpace);
    List<ParkingSpace> getParkingSpaces();
}
