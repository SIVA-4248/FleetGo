package com.example.cab_booking_system.controller;
import com.example.cab_booking_system.entity.Driver;
import com.example.cab_booking_system.service.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a REST controller
@RequestMapping("/drivers") // Base URL for all Driver APIs
public class DriverController {

    @Autowired
    private DriverService driverService; // Injects service layer

    // 1️⃣ Add a new driver
    @PostMapping("/add")
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.registerDriver(driver);
    }

    // 2️⃣ Get driver by ID
    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable long id) {
        return driverService.getDriverById(id);
    }

    // 3️⃣ Get all drivers
    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    // 4️⃣ Delete driver by ID
    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable long id) {
        driverService.deleteDriver(id);
        return "Driver with ID " + id + " deleted successfully!";
    }

    // 5️⃣ Update driver details
    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable long id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }
}
