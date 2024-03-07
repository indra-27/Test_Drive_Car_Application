package com.training.testdriveapp.staff;

import com.training.testdriveapp.entity.Address;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private Integer staffId;
    private String staffName;
    @OneToOne
    private Address address;
    private String phoneNumber;
    private String staffEmail;


    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public Staff() {
    }

    public Staff(String staffName, Address address, String phoneNumber, String staffEmail) {
        this.staffName = staffName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.staffEmail = staffEmail;
    }

}
