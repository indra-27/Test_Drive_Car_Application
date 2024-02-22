package com.training.testdriveapp.booking;

import java.time.LocalDate;

public class BookingDto {
    private String customerName;
    private String carModelName;
    private Integer slotNo;
    private LocalDate date;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
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

    public BookingDto(String customerName, String carModelName, Integer slotNo, LocalDate date) {
        this.customerName = customerName;
        this.carModelName = carModelName;
        this.slotNo = slotNo;
        this.date = date;
    }
}
