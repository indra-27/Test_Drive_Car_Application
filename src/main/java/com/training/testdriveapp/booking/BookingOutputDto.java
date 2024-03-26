package com.training.testdriveapp.booking;

import java.time.LocalDate;

public class BookingOutputDto {
    private Integer bookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    private String customerEmailId;
    private String carModelName;
    private Integer slotNo;
    private LocalDate date;
    private LocalDate bookingDate;
    private String staffName;
    private String staffMobileNumber;
    private Boolean status;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffMobileNumber() {
        return staffMobileNumber;
    }

    public void setStaffMobileNumber(String staffMobileNumber) {
        this.staffMobileNumber = staffMobileNumber;
    }

    public BookingOutputDto(Integer bookId, String customerEmailId, String carModelName, Integer slotNo, LocalDate date, LocalDate bookingDate, String staffName, String staffMobileNumber,Boolean status) {
        this.bookId = bookId;
        this.customerEmailId = customerEmailId;
        this.carModelName = carModelName;
        this.slotNo = slotNo;
        this.date = date;
        this.bookingDate = bookingDate;
        this.staffName = staffName;
        this.staffMobileNumber = staffMobileNumber;
        this.status = status;
    }
}
