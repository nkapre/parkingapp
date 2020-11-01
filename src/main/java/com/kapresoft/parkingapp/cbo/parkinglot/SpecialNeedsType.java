package com.kapresoft.parkingapp.cbo.parkinglot;

public enum SpecialNeedsType {
    NONE("NONE", 1), PREGNANT ("PREGNANT", 2),
    ELDERLY ("ELDERLY", 3), PHYSICALLY_CHALLENGED ("PHYSICALLY_CHALLENGED", 4),
    WAR_VETRAN ("WAR_VETERAN", 5);

    private int needsType;
    private String needsTypeString;

    SpecialNeedsType (final String needsTypeString, final int needsType) {
        this.needsTypeString = needsTypeString;
        this.needsType = needsType;
    }

    @Override
    public String toString() {
        return this.needsTypeString;
    }
}
