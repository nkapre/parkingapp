package com.kapresoft.parkingapp.exceptions;

public class ParkingLotAddException extends RuntimeException{
    public ParkingLotAddException() {
    }

    public ParkingLotAddException(String message) {
        super(message);
    }

    public ParkingLotAddException(String message, Throwable cause) {
        super(message, cause);
    }
}
