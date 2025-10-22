package com.example.cab_booking_system.service.ServiceImpl;
import com.example.cab_booking_system.entity.Passenger;
import com.example.cab_booking_system.repository.PassengerRepository;
import com.example.cab_booking_system.service.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;


    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }


    @Override
    public Passenger updatePassenger(Long userId, Passenger passengerDetails) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(userId);
        if (passengerOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            passenger.setFirstName(passengerDetails.getFirstName());
            passenger.setLastName(passengerDetails.getLastName());
            passenger.setEmailId(passengerDetails.getEmailId());
            passenger.setPass(passengerDetails.getPass());
            passenger.setMobileNumber(passengerDetails.getMobileNumber());
            return passengerRepository.save(passenger);
        }
        return null;
    }


    @Override
    public Optional<Passenger> getPassengerById(Long userId) {
        return passengerRepository.findById(userId);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }


    @Override
    public void deletePassenger(Long userId) {
        passengerRepository.deleteById(userId);
    }
}