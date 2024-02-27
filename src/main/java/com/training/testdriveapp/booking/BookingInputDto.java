package com.training.testdriveapp.booking;

import java.time.LocalDate;

public class BookingInputDto {
    private String customerEmailId;
    private String carModelName;
    private Integer slotNo;
    private LocalDate date;
    private LocalDate bookingDate;

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingInputDto(String customerEmailId, String carModelName, Integer slotNo, LocalDate date, LocalDate bookingDate) {
        this.customerEmailId = customerEmailId;
        this.carModelName = carModelName;
        this.slotNo = slotNo;
        this.date = date;
        this.bookingDate = bookingDate;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
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

    public BookingInputDto(String customerName, String carModelName, Integer slotNo, LocalDate date) {
        this.customerEmailId = customerName;
        this.carModelName = carModelName;
        this.slotNo = slotNo;
        this.date = date;
    }

    public BookingInputDto() {
    }
}
