package com.kapresoft.parkingapp.cbo.parkinglot;

public enum ParkingSizeType {
    MINI ("MINI", 1), HATCHBACK ("HATCHBACK", 2),
    SEDAN ("SEDAN", 3), SUV ("SUV", 4);

    private static final String[] parkingSizes = {"MINI", "HATCHBACK", "SEDAN", "SUV"};
    private int parkingSizeType;
    private String parkingSizeTypeString;

    ParkingSizeType (final String parkingSizeTypeString, final int parkingSizeType) {
        this.parkingSizeTypeString = parkingSizeTypeString;
        this.parkingSizeType = parkingSizeType;
    }

    public final ParkingSizeType getParkingSizeType(final String parkingSizeType) {
        int ordinal = 0;
        for (final String s : parkingSizes) {
            if (!s.equals(parkingSizeType)) {
                ordinal++;
            }
        }

        return ParkingSizeType.values()[ordinal];
    }

    public int getValue() {
        return this.parkingSizeType;
    }
}
