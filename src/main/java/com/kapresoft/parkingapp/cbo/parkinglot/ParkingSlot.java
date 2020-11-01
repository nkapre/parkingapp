package com.kapresoft.parkingapp.cbo.parkinglot;

import com.kapresoft.parkingapp.cbo.rates.RateDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ParkingSlot {
    @Id
    private int slotID;
    private String slotNumber;
    private ParkingSizeType slotSizeType;
    private SpecialNeedsType specialNeedsType;
    private boolean available;
    private RateDetails rateDetails;

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSizeType getSlotSizeType() {
        return slotSizeType;
    }

    public void setSlotSizeType(ParkingSizeType slotSizeType) {
        this.slotSizeType = slotSizeType;
    }

    public SpecialNeedsType getSpecialNeedsType() {
        return specialNeedsType;
    }

    public void setSpecialNeedsType(SpecialNeedsType specialNeedsType) {
        this.specialNeedsType = specialNeedsType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public RateDetails getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(RateDetails rateDetails) {
        this.rateDetails = rateDetails;
    }
}
