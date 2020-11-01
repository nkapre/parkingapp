package com.kapresoft.parkingapp.services;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSizeType;
import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot;
import com.kapresoft.parkingapp.cbo.parkinglot.SpecialNeedsType;
import com.kapresoft.parkingapp.exceptions.NoParkingLotFoundException;
import com.kapresoft.parkingapp.exceptions.ParkingLotAddException;
import com.kapresoft.parkingapp.repositories.ParkingLotRepository;
import com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {
    private static final Logger logger = LoggerFactory.getLogger("ParkingLotService.class");

    @Autowired
    ParkingLotRepository parkingLotRepository;
    public void setParkingLotRepository (ParkingLotRepository plr) {
        this.parkingLotRepository = plr;
    }

    public boolean addParkingLot (com.kapresoft.rest.model.ParkingLot parkingLot) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entering addParkingLot");
        }

        List<ParkingSlot> parkingSlots = new ArrayList<>();

        for (com.kapresoft.rest.model.ParkingSlot slot : parkingLot.getParkingSlots()) {
            ParkingSlot ps = new ParkingSlot();
            ps.setSlotNumber(slot.getSlotNumber());
            ps.setSlotSizeType(ParkingSizeType.valueOf(slot.getParkingSizeType().toString()));
            ps.setSpecialNeedsType(SpecialNeedsType.valueOf(slot.getSpecialNeedsType().toString()));

            parkingSlots.add(ps);
        }

        ParkingLot pl =
                new ParkingLot(parkingLot.getParkingLotName(), parkingLot.getAddress(),
                        parkingLot.getOpeningTime(), parkingLot.getClosingTime(), parkingSlots);

        ParkingLot addedPl = null;

        try {
            addedPl = parkingLotRepository.insert(pl);
        }
        catch (Exception ex) {
            logger.error("Exception occurect while trying to add parking lot " + ex);
            throw new ParkingLotAddException("Exception occurect while trying to add parking lot ", ex);
        }
        finally {
            if (logger.isDebugEnabled()) {
                logger.debug("Exiting addParkingLot");
            }
        }

        return true;
    }

    public ParkingLot getParkingLot (final String parkingLotName) throws NoParkingLotFoundException {
        if (logger.isDebugEnabled()) {
            logger.debug("Entering getParkingLot");
        }

        try {
            List<ParkingLot> retList = parkingLotRepository.getParkingLotByNameQuery(parkingLotName);

            if (retList != null && retList.size() > 0) {
                return retList.get(0);
            } else {
                throw new NoParkingLotFoundException("Parking lot with the supplied name could not be found.");
            }
        }
        finally {
            if (logger.isDebugEnabled()) {
                logger.debug("Exiting getParkingLot");
            }
        }
    }
}
