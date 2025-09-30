package com.example.cab_booking_system.service.ServiceImpl;
import com.example.cab_booking_system.entity.Driver;
import com.example.cab_booking_system.repository.DriverRepository;
import com.example.cab_booking_system.service.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long driverId, Driver driverDetails) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if (driverOptional.isPresent()) {
            Driver driver = driverOptional.get();
            driver.setDriverName(driverDetails.getDriverName());
            driver.setDrlNo(driverDetails.getDrlNo());
            driver.setDriverNo(driverDetails.getDriverNo());
            return driverRepository.save(driver);
        }
        return null;
    }

    @Override
    public Driver getDriverById(Long driverId) {
        return driverRepository.findById(driverId).orElse(null);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void deleteDriver(Long driverId) {
        driverRepository.deleteById(driverId);
    }
}