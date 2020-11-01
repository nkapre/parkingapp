package com.kapresoft.parkingapp.controllers;

import com.kapresoft.parkingapp.services.ParkingLotService;
import com.kapresoft.rest.model.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class ParkingLotControllerTest {
    @Mock
    ParkingLot parkingLot;

    @Test
    void setParkingLotService() {
    }

    @Test
    void getParkingLot() {
    }

    @Test
    void addParkingLotSuccessfulAdd() {
        ParkingLotController controller = Mockito.mock(ParkingLotController.class);
        ParkingLotService service = Mockito.mock(ParkingLotService.class);
        controller.setParkingLotService(service);

        ParkingLot pl = Mockito.mock(ParkingLot.class);

        when(service.addParkingLot(pl)).thenReturn(true);
        ResponseEntity ret = controller.addParkingLot(pl);
        Assertions.assertNotNull(ret);
        Assertions.assertEquals(ret.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void addParkingLotAddFailure() {
        ParkingLotController controller = Mockito.mock(ParkingLotController.class);
        ParkingLotService service = Mockito.mock(ParkingLotService.class);
        Mockito.when(controller.getParkingLotService()).thenReturn(service);
        //controller.setParkingLotService(service);

        ParkingLot pl = Mockito.mock(ParkingLot.class);

        Mockito.when(service.addParkingLot(pl)).thenReturn(false);
        ResponseEntity ret = controller.addParkingLot(pl);

        Assertions.assertNotNull(ret);
        Assertions.assertEquals(ret.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}