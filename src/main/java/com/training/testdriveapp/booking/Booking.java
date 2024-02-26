package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.staff.Staff;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer bookId;
    @ManyToOne
    private Car testDriveCar;
    private Integer slotNo;
    private LocalDate bookingDate;
    private Boolean status;

    public Booking(Integer bookId, Car testDriveCar, Integer slotNo, LocalDate bookingDate, Boolean status, LocalDate date, Customer customer) {
        this.bookId = bookId;
        this.testDriveCar = testDriveCar;
        this.slotNo = slotNo;
        this.bookingDate = bookingDate;
        this.status = status;
        this.date = date;
        this.customer = customer;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private LocalDate date;

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Booking(Car testDriveCar, Integer slotNo, LocalDate date, Customer customer) {
        this.testDriveCar = testDriveCar;
        this.slotNo = slotNo;
        this.date = date;
        this.customer = customer;
    }

    @ManyToOne
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
