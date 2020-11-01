package com.kapresoft.parkingapp.cbo.parkinglot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(value = "parkinglot")
public class ParkingLot {
    @Id
    private int lotID;
    private String parkingLotName;
    private String address;
    private String openingTime;
    private String closingTime;
    private List<ParkingSlot> parkingSlots;

    public ParkingLot (final String name, final String address, final String openingTime,
                       final String closingTime, final List<ParkingSlot> slots) {
        parkingSlots = new ArrayList<>(slots);
        setupParkingSlots();
        setReservedSlots();
    }

    private ParkingLot() {
    }

    public void setupParkingSlots() {
        for (ParkingSlot ps : getParkingSlots()) {
            ps = new ParkingSlot();
        }
    }

    private void setReservedSlots() {
        //Logic for reserved slots
    }


    public int getLotID() {
        return lotID;
    }

    public void setLotID(int lotID) {
        this.lotID = lotID;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;
        ParkingLot that = (ParkingLot) o;
        return getLotID() == that.getLotID() &&
                getParkingLotName().equals(that.getParkingLotName()) &&
                getAddress().equals(that.getAddress()) &&
                getOpeningTime().equals(that.getOpeningTime()) &&
                getClosingTime().equals(that.getClosingTime()) &&
                getParkingSlots().equals(that.getParkingSlots());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLotID(), getParkingLotName(), getAddress(), getOpeningTime(), getClosingTime(), getParkingSlots());
    }
}
