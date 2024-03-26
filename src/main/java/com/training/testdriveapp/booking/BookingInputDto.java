package com.training.testdriveapp.booking;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BookingInputDto {
    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String customerEmailId;
    @NotBlank(message = "Car ModelName cant be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,16}", message = "Car ModelName should contain min 3 & max 16 chars.")
    private String carModelName;
    @NotBlank(message = "SlotNo cant be null, it should be between 1 to 8")
    @Min(value = 1,message = "Minimum value should be 1")
    @Max(value = 8,message = "Maximum value should be 8")
    private Integer slotNo;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
