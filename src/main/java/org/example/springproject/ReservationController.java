package org.example.springproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(
            @PathVariable("id") Long id
    ) {
        log.info("Called getReservation: id=" + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getReservationById(id));
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Called getAllReservation");
        return ResponseEntity.ok(reservationService.findAllReservation());
    }

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation reservationToCreate
    ) {
        log.info("Called createReservation");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("test-header", "123")
                .body(reservationService.createReservation(reservationToCreate));
    }
}
