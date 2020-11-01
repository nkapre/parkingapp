package com.kapresoft.parkingapp.cbo.vehicle;

import com.kapresoft.parkingapp.cbo.parkinglot.ParkingSizeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Vehicle {
    @Id
    private int vehicleID;
    private String vehicleRegistration;
    private ParkingSizeType size;

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public ParkingSizeType getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getVehicleID() == vehicle.getVehicleID() &&
                getVehicleRegistration().equals(vehicle.getVehicleRegistration()) &&
                getSize() == vehicle.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleID(), getVehicleRegistration(), getSize());
    }

    public void setSize(ParkingSizeType size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", vehicleRegistration='" + vehicleRegistration + '\'' +
                ", size=" + size +
                '}';
    }
}
