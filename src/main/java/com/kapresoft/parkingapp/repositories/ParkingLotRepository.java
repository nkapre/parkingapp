package com.kapresoft.parkingapp.repositories;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot;
import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends MongoRepository <ParkingLot, String> {
    @Query("{'parkingLotName': ?parkingLotName}")
    public List<ParkingLot> getParkingLotByNameQuery (final String parkingLotName);
}
