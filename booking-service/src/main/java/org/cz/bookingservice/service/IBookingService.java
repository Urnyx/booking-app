package org.cz.bookingservice.service;
import org.cz.bookingservice.models.dtos.BookingDto;
import org.cz.bookingservice.models.dtos.BookingSaveDto;

import java.util.List;

public interface IBookingService {
    BookingDto createBooking(BookingSaveDto booking);
    List<BookingDto> getBookings();
    BookingDto getBooking(Long id);
    void deleteBooking(Long id);
    BookingDto updateBooking(Long id, BookingSaveDto booking);
}
