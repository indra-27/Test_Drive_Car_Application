package com.training.testdriveapp.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer bookId;
    @ManyToOne
    private Car testDriveCar;
    @NotBlank(message = "SlotNo cant be null, it should be between 1 to 8")
    @Min(value = 1,message = "Minimum value should be 1")
    @Max(value = 8,message = "Maximum value should be 8")
    private Integer slotNo;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bookingDate;
    @NotNull
    private Boolean status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @ManyToOne
    private Customer customer;

    public Booking() {
    }
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
}
