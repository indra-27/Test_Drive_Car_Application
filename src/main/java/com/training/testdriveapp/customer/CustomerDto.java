package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import jakarta.persistence.*;


@Entity
public class CustomerDto {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer addressId;

    public CustomerDto(Integer id, String name, String email, String password, Integer addressId, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressId = addressId;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "Id")
   private Address address;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String email, String password, Integer addressId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressId = addressId;

    }

    public CustomerDto(String name, String email, String password, Integer addressId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressId = addressId;

    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressId=" + addressId +
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

}
