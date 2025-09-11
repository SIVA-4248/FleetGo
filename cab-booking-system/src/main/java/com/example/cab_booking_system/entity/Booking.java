package com.example.cab_booking_system.entity;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long bookingId;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "userId")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name="driver_id",referencedColumnName = "driverId")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name ="cab_id",referencedColumnName = "cabId")
    private Cab cab;

    @Column(nullable = false)
    private String pickupLocation;
    @Column(nullable = false)
    private String dropLocation;
    @Column(nullable = false)
    private LocalDateTime bookingTime;
    @Column(nullable = false)
    private String bookingStatus;
    public long getBookingId() {return bookingId;}
    public void setBookingId(long bookingId) {this.bookingId = bookingId;}
    public Passenger getPassenger() {return passenger;}
    public void setPassenger(Passenger passenger) {this.passenger = passenger;}
    public Driver getDriver() {return driver;}
    public void setDriver(Driver driver) {this.driver = driver;}
    public Cab getCab(){return cab;}
    public void setCab(Cab cab){this.cab=cab;}
    public String getPickupLocation() {return pickupLocation;}
    public void setPickupLocation(String pickupLocation) {this.pickupLocation = pickupLocation;}
    public String getDropLocation() {return dropLocation;}
    public void setDropLocation(String dropLocation){this.dropLocation=dropLocation;}
    public LocalDateTime getBookingTime(){return bookingTime;}
    public void setBookingTime(LocalDateTime bookingTime){this.bookingTime=bookingTime;}
    public String getBookingStatus(){return bookingStatus;}
    public void setBookingStatus(String bookingStatus){this.bookingStatus=bookingStatus;}
}