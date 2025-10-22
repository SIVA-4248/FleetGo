package com.example.cab_booking_system.repository;
import com.example.cab_booking_system.entity.Booking;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.entity.Passenger;
import com.example.cab_booking_system.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
public interface BookingRepository extends JpaRepository <Booking,Long>{
    List<Booking> findByDriver(Driver driver);
    List<Booking> findByCab(Cab cab);
    List<Booking> findByPassenger(Passenger passenger);
    List<Booking> findByBookingStatus(String bookingStatus);
    List<Booking> findByBookingTimeBetween(LocalDateTime start,LocalDateTime end);
    List<Booking> findByPickupLocation(String pickupLocation);
    List<Booking> findByDropLocation(String dropLocation);


}
