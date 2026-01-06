package org.example.springproject;

import java.time.LocalDate;
import java.time.LocalDateTime;

record Reservation(
        Long id,
        Long userId,
        Long roomId,
        LocalDate startDate,
        LocalDateTime endDate,
        ReervationStatus status
) {
}
