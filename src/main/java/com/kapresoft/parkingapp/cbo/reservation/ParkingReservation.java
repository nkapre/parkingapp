package com.kapresoft.parkingapp.cbo.reservation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(value = "parkingreservation")
public class ParkingReservation {
    @Id
    private int reservationID;
    private int parkingLotID;
    private String parkingLotName;
    private int userID;
    private String parkingSlotNumber;
    private String parkingStartDateTime;
    private String parkingEndDateTime;
    private float rate;
    private String reservationConfirmationNumber;

    public ParkingReservation() {
    }

    public ParkingReservation(int parkingLotID, String parkingLotName, int userID, String parkingSlotNumber, String parkingStartDateTime,
                              String parkingEndDateTime, float rate) {
        this.parkingLotID = parkingLotID;
        this.parkingLotName = parkingLotName;
        this.userID = userID;
        this.parkingSlotNumber = parkingSlotNumber;
        this.parkingStartDateTime = parkingStartDateTime;
        this.parkingEndDateTime = parkingEndDateTime;
        this.rate = rate;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getParkingStartDateTime() {
        return parkingStartDateTime;
    }

    public void setParkingStartDateTime(String parkingStartDateTime) {
        this.parkingStartDateTime = parkingStartDateTime;
    }

    public String getParkingEndDateTime() {
        return parkingEndDateTime;
    }

    public void setParkingEndDateTime(String parkingEndDateTime) {
        this.parkingEndDateTime = parkingEndDateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(String parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public String getReservationConfirmationNumber() {
        return reservationConfirmationNumber;
    }

    public void setReservationConfirmationNumber(String reservationConfirmationNumber) {
        this.reservationConfirmationNumber = reservationConfirmationNumber;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingReservation)) return false;
        ParkingReservation that = (ParkingReservation) o;
        return getReservationID() == that.getReservationID() &&
                getParkingLotID() == that.getParkingLotID() &&
                getUserID() == that.getUserID() &&
                Float.compare(that.getRate(), getRate()) == 0 &&
                getParkingLotName().equals(that.getParkingLotName()) &&
                getParkingSlotNumber().equals(that.getParkingSlotNumber()) &&
                getParkingStartDateTime().equals(that.getParkingStartDateTime()) &&
                Objects.equals(getParkingEndDateTime(), that.getParkingEndDateTime()) &&
                getReservationConfirmationNumber().equals(that.getReservationConfirmationNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservationID(), getParkingLotID(), getParkingLotName(), getUserID(), getParkingSlotNumber(), getParkingStartDateTime(), getParkingEndDateTime(), getRate(), getReservationConfirmationNumber());
    }

    @Override
    public String toString() {
        return "ParkingReservation{" +
                "reservationID=" + reservationID +
                ", parkingLotID=" + parkingLotID +
                ", parkingLotName='" + parkingLotName + '\'' +
                ", userID=" + userID +
                ", parkingSlotNumber='" + parkingSlotNumber + '\'' +
                ", parkingStartDateTime='" + parkingStartDateTime + '\'' +
                ", parkingEndDateTime='" + parkingEndDateTime + '\'' +
                ", rate=" + rate +
                ", reservationConfirmationNumber='" + reservationConfirmationNumber + '\'' +
                '}';
    }
}
