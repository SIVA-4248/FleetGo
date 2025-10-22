package com.example.cab_booking_system.service.Service;
import java.util.*;
import com.example.cab_booking_system.entity.Cab;

public interface CabService {

    Cab addCab(Cab cab);
    void updateCab(Long cabId, Cab cab);
    void deleteCab(Long cabId);
    Optional <Cab> getCabById(Long cabId);
    List<Cab>getAllCabs();
    List<Cab>getAvailableCabs();
}
