package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.cbo.reservation.ParkingReservation;

public interface ReservationServiceInf {
    ParkingReservation addReservation(ParkingReservation reservation, SpecialNeedsType specialNeeds);

    ParkingReservation getReservation (String confirmationNumber);
}
