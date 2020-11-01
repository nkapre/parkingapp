package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.cbo.reservation.ParkingReservation;
import com.kapresoft.parkingapp.exceptions.NoFreeSlotAvailableException;
import com.kapresoft.parkingapp.exceptions.NoReservationFoundException;
import com.kapresoft.parkingapp.exceptions.ReservationException;
import com.kapresoft.parkingapp.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component
@Service
public class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger("ReservationService.class");

    @Autowired
    ReservationRepository repository;
    public void setReservationRepository (ReservationRepository repo) {
        this.repository = repo;
    }
    @Autowired
    ParkingSlotService parkingSlotService;
    public void setParkingSlotService (ParkingSlotService pss) {
        this.parkingSlotService = pss;
    }

    public ParkingReservation addReservation(final ParkingReservation reservation, final SpecialNeedsType specialNeeds) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entering addReservation");
        }

        //Get next free parking slot and rates
        ParkingSlot userSlot = null;
        ParkingReservation addedReservation = null;

        try {
            userSlot = parkingSlotService.getAvailableParkingSlotForBooking(specialNeeds);
            reservation.setParkingSlotNumber(userSlot.getSlotNumber());
            reservation.setReservationConfirmationNumber("bcde");

            addedReservation = repository.insert(reservation);
        }
        catch (NoFreeSlotAvailableException nfsae) {
            throw new ReservationException(nfsae);
        }
        finally {
            if (logger.isDebugEnabled()) {
                logger.debug("Exiting addReservation");
            }
        }

        return addedReservation;
    }

    public ParkingReservation getReservation (final String confirmationNumber) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entering getReservation");
        }

        ParkingReservation res = null;

        try {
            res = repository.findReservationByReservationConfirmationNumber(confirmationNumber);
        }
        catch (Exception ex) {
            throw new NoReservationFoundException("No reservation could be found with the supplied confirmation number");
        }
        finally {
            if (logger.isDebugEnabled()) {
                logger.debug("Exiting getReservation");
            }

            return res;
        }
    }

}
