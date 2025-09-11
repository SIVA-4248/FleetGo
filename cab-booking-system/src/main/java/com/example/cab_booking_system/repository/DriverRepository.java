package com.example.cab_booking_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cab_booking_system.entity.Driver;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByDriverNo(long driverNo);
    Optional<Driver> findByDriverName(String driverName);
    List<Driver> findByDriverNameContaining(String name);
}
