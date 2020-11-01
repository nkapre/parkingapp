package com.kapresoft.parkingapp.cbo.user;

import com.kapresoft.parkingapp.cbo.vehicle.Vehicle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class UserDetails {
    @Id
    private int userID;
    private String userName;
    private String contactNumber;
    private String address;
    private Vehicle vehicle;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetails)) return false;
        UserDetails that = (UserDetails) o;
        return getUserID() == that.getUserID() &&
                getUserName().equals(that.getUserName()) &&
                getContactNumber().equals(that.getContactNumber()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                getVehicle().equals(that.getVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getContactNumber(), getAddress(), getVehicle());
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
