package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import jakarta.persistence.*;



public class CustomerDto {


    private String name;
private String mobileNumber;

    private String email;
    private String password;
    private String address;


    public CustomerDto(String mobileNumber,String name, String email, String password, Integer addressId, Integer ratingId, String address) {
       this.mobileNumber=mobileNumber;
        this.name = name;
        this.email = email;
        this.password = password;

        this.address = address;
    }

    public CustomerDto(int i, String karthi, String chennai, String number, String mail, String s) {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerDto() {
    }





    @Override
    public String toString() {
        return "CustomerDto{" +
                "mobile"+mobileNumber+
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

//
                '}';
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
