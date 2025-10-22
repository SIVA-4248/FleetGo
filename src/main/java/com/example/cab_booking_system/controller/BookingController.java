package com.example.cab_booking_system.controller;
import com.example.cab_booking_system.entity.Booking;
import com.example.cab_booking_system.service.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ✅ Book a cab
    @PostMapping
    public Booking bookCab(@RequestBody Booking booking) {
        Booking booked = bookingService.bookCab(booking);
        if (booked == null) {
            throw new RuntimeException("No available cabs at the moment.");
        }
        return booked;
    }

    // ✅ Cancel a booking
    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable Long id) {
        Booking canceled = bookingService.cancelBooking(id);
        if (canceled == null) {
            return "Booking not found!";
        }
        return "Booking with ID " + id + " canceled successfully!";
    }

    // ✅ Get booking by ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            throw new RuntimeException("Booking not found with ID " + id);
        }
        return booking;
    }

    // ✅ Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
