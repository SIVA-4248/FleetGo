package com.example.cab_booking_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cab_booking_system.entity.Cab;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface CabRepository  extends JpaRepository<Cab,Long> {
    List<Cab> findCabByCabModelContaining(String model);
    List<Cab> findCAbByCabNumberContaining(String cabNumber);
    List<Cab> findCabByDriverDriverNameContaining(String driverName);
    List<Cab>  findCabByDriverDriverNameContainingAndCabNumberContaining(String driverName, String cabNumber);
    List<Cab> findByAvailable(boolean available);


}

