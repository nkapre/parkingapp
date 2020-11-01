package com.kapresoft.parkingapp.repositories;

import com.kapresoft.parkingapp.cbo.reservation.ParkingReservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ReservationRepository extends MongoRepository<ParkingReservation, String> {


    public ParkingReservation findReservationByReservationConfirmationNumber (final String confirmationNumber);

    @Query ("{'reservationConfirmationNumber': ?0}")
    public ParkingReservation findReservationByReservationConfirmationNumberQuery (final String confirmationNumber);

}
