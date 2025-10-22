package com.example.cab_booking_system.controller;
import com.example.cab_booking_system.entity.Passenger;
import com.example.cab_booking_system.service.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers") // base URL for passengers
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    // Add a new Passenger
    @PostMapping("/add")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.registerPassenger(passenger);
    }

    // Get all Passengers
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // Get Passenger by ID

    @GetMapping("/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable Long userId) {
        return passengerService.getPassengerById(userId);
    }


    // Update Passenger by ID
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") long userId, @RequestBody Passenger passengerDetails) {
        return passengerService.updatePassenger(userId, passengerDetails);
    }

    // Delete Passenger by ID
    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable("id") long userId) {
        passengerService.deletePassenger(userId);
        return "Passenger with ID " + userId + " deleted successfully!";
    }
}
