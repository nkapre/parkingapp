package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot;
import com.kapresoft.parkingapp.exceptions.NoParkingLotFoundException;

public interface ParkingLotServiceInf {
    boolean addParkingLot(com.kapresoft.rest.model.ParkingLot parkingLot);

    ParkingLot getParkingLot (String parkingLotName) throws NoParkingLotFoundException;
}
