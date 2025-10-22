package com.example.cab_booking_system.controller;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.service.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabs")
public class CabController {

    @Autowired
    private CabService cabService;

    // Create a new cab
    @PostMapping
    public Cab addCab(@RequestBody Cab cab) {
        return cabService.addCab(cab);
    }

    // Get all cabs
    @GetMapping
    public List<Cab> getAllCabs() {
        return cabService.getAllCabs();
    }

    // Get cab by ID
    @GetMapping("/{id}")
    public Cab getCabById(@PathVariable Long cabId) {
        Optional<Cab> cab = cabService.getCabById(cabId);
        if (cab.isPresent()) {
            return cab.get();
        } else {
            throw new RuntimeException("Cab not found with ID " + cabId);
        }
    }

    // Update cab by ID
    @PutMapping("/{id}")
    public String updateCab(@PathVariable Long cabId, @RequestBody Cab cabDetails) {
        Optional<Cab> cabOptional = cabService.getCabById(cabId);
        if (cabOptional.isPresent()) {
            Cab cab = cabOptional.get();
            cab.setCabNumber(cabDetails.getCabNumber());
            cab.setCabModel(cabDetails.getCabModel());
            cab.setAvailable(cabDetails.isAvailable());
            cab.setDriver(cabDetails.getDriver());
            cabService.updateCab(cabId,cab);
            return "Cab updated succesfully";
        } else {
            return "Cab not Found "; // or throw exception
        }
    }

    // Delete cab by ID
    @DeleteMapping("/{id}")
    public String deleteCab(@PathVariable Long cabId) {
        try {
            cabService.deleteCab(cabId);
            return "Cab deleted successfully!";
        } catch (RuntimeException e) {
            return "Cab not found!";
        }
    }

}

