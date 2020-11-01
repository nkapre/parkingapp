package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot;
import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.exceptions.NoFreeSlotAvailableException;
import com.kapresoft.parkingapp.repositories.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@Service
public class ParkingSlotService {
    private static final Logger logger = LoggerFactory.getLogger("ParkingSlotService.class");

    @Autowired
    ParkingSlotRepository repository;

    public ParkingSlot getAvailableParkingSlotForBooking(SpecialNeedsType specialNeeds) throws NoFreeSlotAvailableException {
        if (logger.isDebugEnabled()) {
            logger.debug("Exiting getAvailableParkingSlotForBooking");
        }
        //The below logic is not good enough for concurrent needs, but then this is just a first come first serve demo.
        List<ParkingSlot> freeSlots = null;

        if (specialNeeds.ordinal() > 0) {
            freeSlots = repository.getFreeParkingSlotForSpecialNeedsQuery(specialNeeds);
        }
        else {
            freeSlots = repository.getFreeParkingSlotForNoSpecialNeedsQuery(specialNeeds);
        }

        ParkingSlot savedSlot = null;

        if (freeSlots != null && freeSlots.size() > 0) {
            ParkingSlot slotToUse = freeSlots.get(0);
            slotToUse.setAvailable(false);
            savedSlot = repository.save(slotToUse);
        }
        else {
            if (logger.isDebugEnabled()) {
                logger.debug("No free slots are available.");
            }

            throw new NoFreeSlotAvailableException("No free slot is available for your needs");
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Exiting getAvailableParkingSlotForBooking");
        }

        return savedSlot;
    }

    public ParkingSlot addParkingSlot (final ParkingLot parkingLot, final ParkingSlot parkingSlot) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entering addParkingSlot");
        }

        try {
            return repository.insert(parkingSlot);
        }
        finally {
            if (logger.isDebugEnabled()) {
                logger.debug("Exiting addParkingSlot");
            }
        }

    }
}
