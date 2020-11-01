package com.kapresoft.parkingapp.exceptions;

public class NoFreeSlotAvailableException extends RuntimeException {

    public NoFreeSlotAvailableException() {
    }

    public NoFreeSlotAvailableException(String message) {
        super(message);
    }

    public NoFreeSlotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
