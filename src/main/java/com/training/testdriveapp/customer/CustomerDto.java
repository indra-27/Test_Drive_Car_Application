package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import jakarta.persistence.*;



public class CustomerDto {

    private Integer id;
    private String name;

    private String email;
    private String password;
    private Address address;


    public CustomerDto(Integer id, String name, String email, String password, Integer addressId, Integer ratingId, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

        this.address = address;
    }


    public CustomerDto(Integer id, String name, String email, String password, Integer addressId, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String email, String password, Integer addressId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;


    }

    public CustomerDto(String name, String email, String password, Integer addressId) {
        this.name = name;
        this.email = email;
        this.password = password;


    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

//
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
