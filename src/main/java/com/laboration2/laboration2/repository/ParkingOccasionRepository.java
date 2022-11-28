package com.laboration2.laboration2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.laboration2.laboration2.entity.ParkingOccasion;

import jakarta.transaction.Transactional;

public interface ParkingOccasionRepository extends ListCrudRepository <ParkingOccasion, Long> {


    @Query("""  
            SELECT p FROM ParkingOccasion p WHERE p.status = :status
                    """)
    List<ParkingOccasion> findByStatus(@Param("status") String status);

    @Transactional
    @Modifying
    @Query("UPDATE ParkingOccasion p " +
        "SET p.status = :status " +
        "WHERE p.stopTime < :timeNow ")
    void updateStatus(@Param("timeNow") LocalDateTime timeNow, String status);


    
}
