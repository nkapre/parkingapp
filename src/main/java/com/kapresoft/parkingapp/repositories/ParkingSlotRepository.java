package com.kapresoft.parkingapp.repositories;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ParkingSlotRepository extends MongoRepository<ParkingSlot, String> {
    @Query("{'available': ?true, 'specialNeedsType': {$gt: ?0}}")
    public List<ParkingSlot> getFreeParkingSlotForSpecialNeedsQuery (SpecialNeedsType specialNeeds);

    @Query("{'available': ?true, 'specialNeedsType': ?0}")
    public List<ParkingSlot> getFreeParkingSlotForNoSpecialNeedsQuery (SpecialNeedsType specialNeeds);

}
