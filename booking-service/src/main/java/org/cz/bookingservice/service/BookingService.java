package org.cz.bookingservice.service;

import org.cz.bookingservice.models.Booking;
import org.cz.bookingservice.models.dtos.BookingDto;
import org.cz.bookingservice.models.dtos.BookingSaveDto;
import org.cz.bookingservice.repository.IBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    private final IBookingRepository bookingRepository;

    public BookingService(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDto createBooking(BookingSaveDto booking) {
        return bookingToBookingDto(bookingRepository.save(bookingSaveDtoToBooking(booking)));
    }

    @Override
    public List<BookingDto> getBookings() {
        return bookingRepository.findAll().stream().map(this::bookingToBookingDto).toList();
    }

    @Override
    public BookingDto getBooking(Long id) {
        return bookingToBookingDto(bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("no such booking")));
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDto updateBooking(Long id, BookingSaveDto booking) {
        BookingDto bookingFind = getBooking(id);
        if (bookingFind != null){
            Booking bookingToUpdate = bookingSaveDtoToBooking(booking);
            bookingToUpdate.setId(id);
            return bookingToBookingDto(bookingRepository.save(bookingToUpdate));
        }else{
            throw new RuntimeException("booking not found");
        }
    }

    private BookingDto bookingToBookingDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getPassangerName(),
                booking.getFlightNumber());
    }

    private Booking bookingSaveDtoToBooking(BookingSaveDto booking) {
        return new Booking(null, booking.passangerName(),booking.flightNumber());
    }
}
