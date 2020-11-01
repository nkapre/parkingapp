package com.kapresoft.parkingapp.exceptions;

public class NoReservationFoundException extends RuntimeException {
    public NoReservationFoundException() {
    }

    public NoReservationFoundException(String message) {
        super(message);
    }

    public NoReservationFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
