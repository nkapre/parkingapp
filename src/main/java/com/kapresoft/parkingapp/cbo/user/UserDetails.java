package com.kapresoft.parkingapp.cbo.user;

import com.kapresoft.parkingapp.cbo.vehicle.Vehicle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDetails {
    @Id
    private int userID;
    private String userName;
    private String contactNumber;
    private String address;
    private Vehicle vehicle;

}
