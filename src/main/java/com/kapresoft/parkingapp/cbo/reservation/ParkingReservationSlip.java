package com.kapresoft.parkingapp.cbo.reservation;

import java.util.Objects;

public class ParkingReservationSlip {
    private String reservationConfirmationNumber;
    private String reservationDateTime;
    private String parkingLotName;
    private String reservedSlotNumber;

    public ParkingReservationSlip() {

    }

    public ParkingReservationSlip(String reservationConfirmationNumber, String reservationDateTime,
                                  String parkingLotName, String reservedSlotNumber) {
        this.reservationConfirmationNumber = reservationConfirmationNumber;
        this.reservationDateTime = reservationDateTime;
        this.parkingLotName = parkingLotName;
        this.reservedSlotNumber = reservedSlotNumber;
    }

    public String getReservationConfirmationNumber() {
        return reservationConfirmationNumber;
    }

    public void setReservationConfirmationNumber(String reservationConfirmationNumber) {
        this.reservationConfirmationNumber = reservationConfirmationNumber;
    }

    public String getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(String reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getReservedSlotNumber() {
        return reservedSlotNumber;
    }

    public void setReservedSlotNumber(String reservedSlotNumber) {
        this.reservedSlotNumber = reservedSlotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingReservationSlip)) return false;
        ParkingReservationSlip that = (ParkingReservationSlip) o;
        return getReservationConfirmationNumber().equals(that.getReservationConfirmationNumber()) &&
                getReservationDateTime().equals(that.getReservationDateTime()) &&
                getParkingLotName().equals(that.getParkingLotName()) &&
                getReservedSlotNumber().equals(that.getReservedSlotNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservationConfirmationNumber(), getReservationDateTime(),
                getParkingLotName(), getReservedSlotNumber());
    }
}
