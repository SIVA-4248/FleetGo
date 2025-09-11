package com.example.cab_booking_system.entity;
import jakarta.persistence.*;
@Entity
@Table(name="Driver")
public class Driver{
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long driverId;
    @Column (nullable = false)
    private String driverName;
    @Column(nullable = false,unique = true)
    private String drlNo;
    @Column(nullable = false)
    private long driverNo;

    public  long getDriverId(){return driverId;}
    public void setDriverId(long driverId){this.driverId=driverId;}

    public String getDriverName(){return driverName;}
    public void setDriverName(String driverName){this.driverName=driverName;}

    public String getDrlNo(){return drlNo;}
    public void setDrlNo(String drlNo){this.drlNo=drlNo;}

    public long getDriverNo(){return driverNo;}
    public void setDriverNo(long driverNo){this.driverNo=driverNo;}
}