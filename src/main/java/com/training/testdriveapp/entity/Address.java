package com.training.testdriveapp.entity;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    private String doorNo;
    private String addressLane;
    private String city;
    private String state;
    private String pincode;
//   @OneToOne
//   @JoinColumn(name = "customerId")
//    private Customer customer;

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getAddressLane() {
        return addressLane;
    }

    public void setAddressLane(String addressLane) {
        this.addressLane = addressLane;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Address() {
    }

    public Address(String doorNo, String addressLane, String city, String state, String pincode) {
        this.doorNo = doorNo;
        this.addressLane = addressLane;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
