package com.laboration2.laboration2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboration2.laboration2.entity.ParkingSpace;
import com.laboration2.laboration2.repository.ParkingSpaceRepository;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    
    @Autowired 
    ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public ParkingSpace getParkingSpace(Long id) {
        return parkingSpaceRepository.findById(id).get();
    }

    @Override
    public ParkingSpace saveParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    @Override
    public void deleteParkingSpace(Long id) {
        parkingSpaceRepository.deleteById(id);
    }
    

    @Override
    public List<ParkingSpace> getParkingSpaces() {
        return (List<ParkingSpace>)parkingSpaceRepository.findAll();
    }


}
