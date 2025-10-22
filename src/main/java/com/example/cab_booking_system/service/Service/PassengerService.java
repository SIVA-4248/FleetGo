package com.example.cab_booking_system.service.Service;
import java.util.List;
import java.util.Optional;
import com.example.cab_booking_system.entity.Passenger;
public interface PassengerService {
        Passenger registerPassenger(Passenger passenger);
        Passenger updatePassenger(Long userId, Passenger passenger);
        Optional<Passenger> getPassengerById(Long userId);
        List<Passenger> getAllPassengers();
        void deletePassenger(Long userId);
    }
