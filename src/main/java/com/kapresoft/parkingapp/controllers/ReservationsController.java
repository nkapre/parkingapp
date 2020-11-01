package com.kapresoft.parkingapp.controllers;

import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.cbo.reservation.ParkingReservationSlip;
import com.kapresoft.parkingapp.exceptions.NoFreeSlotAvailableException;
import com.kapresoft.parkingapp.exceptions.ReservationException;
import com.kapresoft.parkingapp.services.ParkingSlotService;
import com.kapresoft.parkingapp.services.ReservationService;
import com.kapresoft.rest.model.ParkingReservation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addReservation(@RequestBody ParkingReservation parkingReservation) {

        ParkingReservationSlip slip = null;
        com.kapresoft.parkingapp.cbo.reservation.ParkingReservation ret = null;

        com.kapresoft.parkingapp.cbo.reservation.ParkingReservation reservation =
                new com.kapresoft.parkingapp.cbo.reservation.ParkingReservation();

        reservation.setParkingLotID(parkingReservation.getParkingLotID());
        reservation.setParkingStartDateTime(parkingReservation.getParkingStartDateTime());
        reservation.setRate(parkingReservation.getRateDetails().getRate().floatValue());
        reservation.setParkingSlotNumber(parkingReservation.getParkingSlotNumber());
        reservation.setUserID(parkingReservation.getUserDetails().getUserID());

        try {
            ret = reservationService.addReservation(reservation,
                    SpecialNeedsType.valueOf(parkingReservation.getUserDetails().getSpecialNeedsType().toString()));
            slip = getParkingReservationSlip(ret, false);

            return new ResponseEntity(slip, HttpStatus.OK);
        }
        catch (NoFreeSlotAvailableException nfsae) {
            slip = getParkingReservationSlip(null, true);
            return new ResponseEntity(slip, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reservations/{confirmationNumber}")
    public ResponseEntity<ParkingReservationSlip> getReservation (@PathVariable final String confirmationNumber) {
        com.kapresoft.parkingapp.cbo.reservation.ParkingReservation ret = null;
        ParkingReservationSlip slip = null;

        try {
            ret = reservationService.getReservation(confirmationNumber);

            slip = getParkingReservationSlip(ret, false);

            return new ResponseEntity<ParkingReservationSlip>(slip, HttpStatus.OK);
        }
        catch(ReservationException re) {
            slip = getParkingReservationSlip(null, true);
            slip.setResrvationError("No reservation found with the specified confirmation number");

            return new ResponseEntity<ParkingReservationSlip>(slip, HttpStatus.BAD_REQUEST);
        }
    }

    //@TODO - Needs to be in a Helper and created usign a Factory
    private ParkingReservationSlip getParkingReservationSlip (com.kapresoft.parkingapp.cbo.reservation.ParkingReservation reservation,
                                                              boolean withError) {

        ParkingReservationSlip retSlip = null;
        if (!withError) {
            retSlip = new ParkingReservationSlip(reservation.getReservationConfirmationNumber(),
                    DateTime.now().toString(), reservation.getParkingLotName(), reservation.getParkingSlotNumber());
        }
        else {
            retSlip = new ParkingReservationSlip(null, DateTime.now().toString(), null,
                    null);
            retSlip.setResrvationError("No reservation found with the specified confirmation number");
        }

        return retSlip;
    }

}
