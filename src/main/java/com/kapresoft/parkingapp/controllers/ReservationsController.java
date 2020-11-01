package com.kapresoft.parkingapp.controllers;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.exceptions.NoFreeSlotAvailableException;
import com.kapresoft.parkingapp.services.ParkingSlotService;
import com.kapresoft.parkingapp.services.ReservationService;
import com.kapresoft.rest.model.ParkingReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@RestController
public class ReservationsController {
    @Autowired
    ReservationService reservationService;

    public ReservationsController() {
        this(new ReservationService());
    }
    public ReservationsController (ReservationService service) {
        this.reservationService = service;
    }
    public void setReservationService(ReservationService service) {
        this.reservationService = service;
    }

    @Autowired
    ParkingSlotService parkingService;

    @PostMapping(path = "/reservations")
    public void addReservation(@RequestBody ParkingReservation parkingReservation)
            throws RestClientException {


        com.kapresoft.parkingapp.cbo.reservation.ParkingReservation reservation =
                new com.kapresoft.parkingapp.cbo.reservation.ParkingReservation();

        reservation.setParkingLotID(parkingReservation.getParkingLotID());
        reservation.setParkingStartDateTime(parkingReservation.getParkingStartDateTime());
        reservation.setRate(parkingReservation.getRateDetails().getRate().floatValue());
        reservation.setParkingSlotNumber(parkingReservation.getParkingSlotNumber());
        reservation.setUserID(parkingReservation.getUserDetails().getUserID());

        try {
            reservationService.addReservation(reservation,
                    SpecialNeedsType.valueOf(parkingReservation.getUserDetails().getSpecialNeedsType().toString()));
        }
        catch (NoFreeSlotAvailableException nfsae) {
            //Exception handling rountes or ControlledAdvice or any other exception handling route.
        }
    }

    @GetMapping("/reservations/{confirmationNumber}")
    public com.kapresoft.parkingapp.cbo.reservation.ParkingReservation getReservation (@PathVariable final String confirmationNumber) {
        return reservationService.getReservation(confirmationNumber);
    }
}
