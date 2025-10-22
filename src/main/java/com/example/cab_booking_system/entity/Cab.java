 package com.example.cab_booking_system.entity;
 import jakarta.persistence.*;
 @Entity
 @Table(name = "cab")
 public class Cab{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long cabId;
     @Column(nullable = false,unique = true)
     private String cabNumber;
     @Column(nullable = false)
     private String cabModel;
     private boolean available;
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "driver_id",referencedColumnName="driverId")
     private Driver driver;

     public long getCabId(){return cabId;}
     public void setCabId(long cabId){this.cabId=cabId;}

     public Driver getDriver(){return driver;}
     public void setDriver(Driver driver){this.driver=driver;}

     public String getCabNumber(){return cabNumber;}
     public void setCabNumber(String cabNumber){this.cabNumber=cabNumber;}

     public String getCabModel(){return cabModel;}
     public void setCabModel(String cabModel){this.cabModel=cabModel;}

     public boolean isAvailable(){return available;}
     public void setAvailable(boolean available){this.available=available;}
  @Override
     public String toString() {
         return "Cab [cabId=" + cabId + ", cabNumber=" + cabNumber +
                 ", cabModel=" + cabModel + ", available=" + available +
                 ", driver=" + (driver != null ? driver.getDriverName() : "No Driver") + "]";
     }
     }
