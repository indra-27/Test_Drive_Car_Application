package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.staff.Staff;
import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer bookId;
    @OneToOne
    private Car testDriveCar;
    private Integer slotNo;

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    public Booking(Integer bookId, Car testDriveCar, Integer slotNo, Customer customer) {
        this.bookId = bookId;
        this.testDriveCar = testDriveCar;
        this.slotNo = slotNo;
        this.customer = customer;
    }

    @OneToOne
    private Customer customer;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Car getTestDriveCar() {
        return testDriveCar;
    }

    public void setTestDriveCar(Car testDriveCars) {
        this.testDriveCar = testDriveCars;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Booking() {
    }
}
