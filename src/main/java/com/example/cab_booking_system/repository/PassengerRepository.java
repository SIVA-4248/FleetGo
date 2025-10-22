package com.example.cab_booking_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cab_booking_system.entity.Passenger;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{
Optional<Passenger> findByEmailId(String emailId);
Optional<Passenger> findByMobileNumber(long mobileNumber);
List<Passenger> findByFirstNameContaining(String firstName);
List<Passenger> findByLastNameContaining(String lastName);
Optional<Passenger> findByUserId(long userId);

}
