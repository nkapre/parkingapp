package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot;
import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.exceptions.NoFreeSlotAvailableException;

public interface ParkingSlotServiceInf {
    ParkingSlot getAvailableParkingSlotForBooking(SpecialNeedsType specialNeeds) throws NoFreeSlotAvailableException;

    ParkingSlot addParkingSlot (ParkingLot parkingLot, ParkingSlot parkingSlot);
}
