package com.kapresoft.parkingapp.controllers;

import com.kapresoft.parkingapp.exceptions.NoParkingLotFoundException;
import com.kapresoft.parkingapp.services.ParkingLotService;
import com.kapresoft.rest.model.ParkingLot;
import com.kapresoft.rest.model.ParkingSlot;
import com.kapresoft.rest.model.RateDetails;
import com.kapresoft.rest.model.SpecialNeedsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    public void setParkingLotService (ParkingLotService service) {
        this.parkingLotService = service;
    }

    @GetMapping("/parkingLot/{parkingLotName}")
    public ResponseEntity<ParkingLot> getParkingLot(@RequestParam String parkingLotName) {
        com.kapresoft.parkingapp.cbo.parkinglot.ParkingLot pl = null;
        try {
            pl = getParkingLotService().getParkingLot(parkingLotName);
        }
        catch (final NoParkingLotFoundException nplfe) {
            return new ResponseEntity ("Unable to retrieve Parking lot with the specified name", HttpStatus.BAD_REQUEST);
        }

        ParkingLot ret = new ParkingLot();
        ret.setLotID(pl.getLotID());
        ret.setParkingLotName(pl.getParkingLotName());
        ret.setAddress(pl.getAddress());
        ret.setOpeningTime(pl.getOpeningTime());
        ret.setClosingTime(pl.getClosingTime());

        List<ParkingSlot> slots = new ArrayList<>();
        for (com.kapresoft.parkingapp.cbo.parkinglot.ParkingSlot ps : pl.getParkingSlots()) {
            ParkingSlot addPs = new ParkingSlot();
            addPs.setSlotID(ps.getSlotID());

            RateDetails rd = new RateDetails();
            rd.setRateDetailID(ps.getRateDetails().getRateDetailID());
            rd.setRate(new BigDecimal(ps.getRateDetails().getRate()));
            rd.setTimeUnit(ps.getRateDetails().getTimeUnit().ordinal());
            rd.setRateCurrency(ps.getRateDetails().getCurrency().ordinal());

            addPs.setRateDetail(rd);
            addPs.setParkingSizeType(ParkingSlot.ParkingSizeTypeEnum.valueOf(ps.getSlotSizeType().toString()));
            addPs.setAvailable(ps.isAvailable());
            addPs.setSpecialNeedsType(SpecialNeedsType.fromValue(ps.getSpecialNeedsType().toString()));
            addPs.setSlotNumber(ps.getSlotNumber());
        }

        ret.setParkingSlots(slots);

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(path = "/parkinglot")
    public ResponseEntity<String> addParkingLot (@RequestBody final com.kapresoft.rest.model.ParkingLot parkingLot) {
        boolean ret = getParkingLotService().addParkingLot(parkingLot);

        if (ret) {
            return new ResponseEntity<>("Successfully added Parking Lot", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Error adding Parking Lot", HttpStatus.BAD_REQUEST);
        }
    }

    public ParkingLotService getParkingLotService() {
        return parkingLotService;
    }
}
