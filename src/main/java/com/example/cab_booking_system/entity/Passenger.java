package com.example.cab_booking_system.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Passenger")
public class Passenger{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;

    @Column(nullable=false)
    private String firstName;
    @Column(nullable=false)
    private String lastName;
    @Column(nullable=false,unique = true)
    private String emailId;
    @Column(nullable=false)
    private String pass;
    @Column(nullable=false,unique = true)
    private long mobileNumber;

    public long getUser_id(){
        return userId;
    }
    public void setUser_id(long userId){this.userId=userId;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getEmailId(){
        return emailId;
    }
    public void setEmailId(String emailId){
        this.emailId=emailId;
    }
    public String getPass(){
    return pass;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public long getMobileNumber(){
        return mobileNumber;
    }
    public void setMobileNumber(long mobileNumber){
        this.mobileNumber=mobileNumber;
    }

    @Override
    public String toString() {
        return "Cab [Userid=" + userId + ", FirstName=" + firstName + ", LastName=" + lastName + " , EmailId=" +emailId  + "]";
    }
}