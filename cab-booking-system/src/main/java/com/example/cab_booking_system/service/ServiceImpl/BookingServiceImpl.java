package com.example.cab_booking_system.service.ServiceImpl;
import com.example.cab_booking_system.entity.Booking;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.repository.BookingRepository;
import com.example.cab_booking_system.service.Service.BookingService;
import com.example.cab_booking_system.service.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CabService cabService;

    @Override
    public Booking bookCab(Booking booking) {
// Step 1: get list of available cabs
        List<Cab> availableCabs = cabService.getAvailableCabs();
        if (availableCabs.isEmpty()) {
            return null; // No cab available
        }


// Step 2: assign first available cab
        Cab assignedCab = availableCabs.get(0);
        booking.setCab(assignedCab);
        booking.setDriver(assignedCab.getDriver());


// Step 3: mark cab as unavailable
        assignedCab.setAvailable(false);
        cabService.updateCab(assignedCab.getCabId(), assignedCab);


// Step 4: save booking
        return bookingRepository.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
// free the cab
            Cab cab = booking.getCab();
            cab.setAvailable(true);
            cabService.updateCab(cab.getCabId(), cab);
// delete the booking
            bookingRepository.deleteById(bookingId);
        }
        return booking;
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}