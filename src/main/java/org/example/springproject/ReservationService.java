package org.example.springproject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    public String getReservationById() {
        return "reservation-1 is done";
    }
}
