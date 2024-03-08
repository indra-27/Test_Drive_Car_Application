package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.booking.Booking;
import com.training.testdriveapp.rating.Rating;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {


    @Id
    @GeneratedValue
    private Integer customerId;
    private String customerName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")

    private Address address;

    
    private String mobileNumber;
    private String customerEmail;
    private String password;


    @OneToMany
    private List<Rating> ratings = new ArrayList<>();


    @OneToMany
    private List<Booking> customerBookings = new ArrayList<>();

    public Customer() {

    }

    public Customer(Integer customerId, String customerName, String mobileNumber, String customerEmail, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.customerEmail = customerEmail;
        this.password = password;
    }

    public List<Booking> getCustomerBookings() {
        return customerBookings;
    }

    public Customer(String customerName, String mobileNumber, String customerEmail, String password) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.customerEmail = customerEmail;
        this.password = password;
    }

    public Customer(Integer customerId, String customerName, Address address, String mobileNumber, String customerEmail, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.customerEmail = customerEmail;
        this.password = password;
    }



    public Customer(Integer customerId, String customerName, Address address,String mobileNumber, String customerEmail, String password, List<Rating> ratings,  List<Booking> customerBookings) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.customerEmail = customerEmail;
        this.password = password;
        this.ratings = ratings;

        this.customerBookings = customerBookings;
    }



    public void setCustomerBookings(List<Booking> customerBooking) {
        this.customerBookings = customerBooking;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getCustomerRatingList() {
        return ratings;
    }

    public void setCustomerRatingList(List<Rating> customerRatingList) {
        this.ratings = customerRatingList;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public void setMobileNumber (String  mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }






}
