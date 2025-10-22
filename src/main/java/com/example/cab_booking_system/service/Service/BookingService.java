package com.example.cab_booking_system.service.Service;
import com.example.cab_booking_system.entity.Booking;
import java.util.List;
public interface BookingService {
        Booking bookCab(Booking booking);
        Booking cancelBooking(Long bookingId);
        Booking getBookingById(Long bookingId);
        List<Booking> getAllBookings();
    }

