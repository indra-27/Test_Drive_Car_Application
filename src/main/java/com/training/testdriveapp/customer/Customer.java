package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.booking.Booking;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.rating.Rating;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {


    @Id
    @GeneratedValue
    private Integer customerId;
    private String CustomerName;
    @OneToOne
    private Address address;
    private String mobileNumber;
    private String customerEmail;

    @OneToMany
    private List<Rating> customerRatingList = new ArrayList<>();
    @ManyToMany
    private List<Car> testDriveCars = new ArrayList<>();

    @OneToMany
    private List<Booking> customerBookings = new ArrayList<>();

    public List<Booking> getCustomerBookings() {
        return customerBookings;
    }


    public Customer() {
    }

    public Customer(Integer customerId, String customerName, Address address, String mobileNumber, String customerEmail, List<Rating> customerRatingList, List<Car> testDriveCars, List<Booking> customerBookings) {
        this.customerId = customerId;
        CustomerName = customerName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.customerEmail = customerEmail;
        this.customerRatingList = customerRatingList;
        this.testDriveCars = testDriveCars;
        this.customerBookings = customerBookings;
    }


    public void setCustomerBookings(List<Booking> customerBooking) {
        this.customerBookings = customerBooking;
    }

    public List<Car> getTestDriveCars() {
        return testDriveCars;
    }

    public void setTestDriveCars(List<Car> testDriveCars) {
        this.testDriveCars = testDriveCars;
    }





    public List<Rating> getCustomerRatingList() {
        return customerRatingList;
    }

    public void setCustomerRatingList(List<Rating> customerRatingList) {
        this.customerRatingList = customerRatingList;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }





}
