package com.kapresoft.parkingapp.cbo.vehicle;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSizeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {
    @Id
    private int vehicleID;
    private String vehicleRegistration;
    private ParkingSizeType size;

}
