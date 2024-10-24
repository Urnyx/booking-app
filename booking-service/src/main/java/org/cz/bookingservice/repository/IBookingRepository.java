package org.cz.bookingservice.repository;

import org.cz.bookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
