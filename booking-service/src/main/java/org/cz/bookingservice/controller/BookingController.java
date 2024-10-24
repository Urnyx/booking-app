package org.cz.bookingservice.controller;

import org.cz.bookingservice.models.dtos.BookingDto;
import org.cz.bookingservice.models.dtos.BookingSaveDto;
import org.cz.bookingservice.service.IBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookings = bookingService.getBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") Long id) {
        BookingDto booking = bookingService.getBooking(id);
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingSaveDto booking) {
        BookingDto newBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(newBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable("id") Long id, @RequestBody BookingSaveDto booking) {
        BookingDto updatedBooking = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
