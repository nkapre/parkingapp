package com.kapresoft.parkingapp.exceptions;

public class NoParkingLotFoundException extends RuntimeException{
    public NoParkingLotFoundException() {
    }

    public NoParkingLotFoundException(String message) {
        super(message);
    }

    public NoParkingLotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
