package com.example.cab_booking_system.service.Service;
import com.example.cab_booking_system.entity.Driver;
import java.util.List;
public interface DriverService {
    Driver registerDriver(Driver driver);
    Driver updateDriver(Long driverId, Driver driverDetails);
    Driver getDriverById(Long driverId);
    List<Driver> getAllDrivers();
    void deleteDriver(Long driverId);
}
