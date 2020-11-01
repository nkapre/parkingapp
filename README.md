# Parking Lot Application
Parking lot reservation application demo

## Overview 
The application allows making reservations of parking slots
The application has been built using SpringBoot **REST (Jackson)** and **Java 1.8**. The backend used is Mongo DB. For Unit testing **Mockito** is used.
The endpoints exposed are:

- POST /reservations - Creates a new reservation and allocates it a Confirmation Number
- GET /reservatons/{confirmationNumber} - Gets a reservation with a specified confirmation number
- POST /parkingLot - Creates a parking lot and all the slots in it.
- GET /parkingLot/{parkingLotName} - Gets a Parking Lot with a specified name with all the parking slots inside it.

The ParkingSlot endpoints are not implemented as this feature is not needed as of now.

## Data
The data in the MongoDB repository is supposed to be populated externally as a part of the seed data setup. Parking lot data are not expected to change unless new parking lots are included in the system. Therefore, this consideration of 120 slots with 20% special needs is not implemented as this would be a setup data. Once the parking slot is allocated, it is will not be allocated to any other reservation.

## API Definition & Documentation
The resources folder for this project contains a Swagger file called parkinglot.yml. This file can be referred to to get API details. Swagger CodeGen was used to generate the types, which are essentially friendly towards the data inbound from the API interfaces. To handle application and data persistence needs, certain DTOs are defined in the cbo package.

## Logging
Application logging has been done using SLF4J. Presently, only the services classes contain documentation

## Business Logic
Business logic is implemented in the Services classes that are marked with the **@Services** annotation.

## Testing
In the scope of this work only Unit Testing is covered. Unit Testing is performed using Mockito. PowerMockito need was not felt and hence that depndency has been removed.

## Deployment 
The API jar executed in a Docker image and a docker-compose.yml has been supplied to ensure that the MongoDB and API jar images are all brought up properly for execution.

## Code Quality
The 3 metrics of code quality that I gave special attention to were Cyclomatic Complexity, Affrent Coupling, and Cohesion metrics. All are well in check. This was measured using the code quality metrics in IntelliJ IDEA.

# Notes
Several simplifying assumptions have been made while developing this application.

1. The application will capture the aspects of reservation and not the final pricing. For instance, if a vehicle is meant to be parked for 30 mins, but remained in the parking lot for 2 hours, then the pricing/penlaties may apply. This is not considered. Pricing in general is not a concern here.
2. Vehicle slot size has been considered in modeling, but not in the actual reservation creation. In reality, a user's vehicle must match that of the slot size to be able to be properly parked. But, this is not a concern considered here.
3. When a reservation is made, a parking slot being considered, must be locked for some time to allow a user to complete payment and finalize the reservation. To implement such a scheme, other libraries are needed, and it would have taken a greater time to get it right. Hence, that was dropped for now. Checks are made to ensure that a parking slot is available, before booking it. Highly concurrent conditions may fail in this implementation.
4. Parking slots may have several features such as electric charging slots etc. A feature capability in introduced, but not implemented.

@Todos
- Complete the docker-compose setup so that the Spring Boot app and Mongo run independently
- Complete the Mock tests. For now, only the ParkingLotController tests have been added partially to illustrate that this would be the unit testing strategy.
