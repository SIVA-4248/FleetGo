package com.example.cab_booking_system.service.ServiceImpl;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.repository.CabRepository;
import com.example.cab_booking_system.service.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabServiceImpl implements CabService {
    @Autowired
    private CabRepository cabRepository;

    @Override
    public Cab addCab(Cab cab) {
        return cabRepository.save(cab);
    }

    @Override
    public void updateCab(Long cabId, Cab cabDetails) {
        Optional<Cab> cabOptional = cabRepository.findById(cabId);
        if (cabOptional.isPresent()) {
            Cab cab = cabOptional.get();
            cab.setCabNumber(cabDetails.getCabNumber());
            cab.setCabModel(cabDetails.getCabModel());
            cab.setAvailable(cabDetails.isAvailable());
            cab.setDriver(cabDetails.getDriver());
            cabRepository.save(cab);
        }
    }

    @Override
    public Optional<Cab> getCabById(Long cabId) {
        return cabRepository.findById(cabId);
    }

    @Override
    public void deleteCab(Long cabId) {
        cabRepository.deleteById(cabId);
    }

    @Override
    public List<Cab> getAvailableCabs() {
        return cabRepository.findByAvailableTrue();
    }

    @Override
    public List<Cab> getAllCabs() {
        return cabRepository.findAll();
    }
}



