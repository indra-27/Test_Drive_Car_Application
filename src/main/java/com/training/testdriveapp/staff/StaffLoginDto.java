package com.training.testdriveapp.staff;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StaffLoginDto {
    @NotBlank(message = "Email can't be null")
    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String staffEmail;
    @NotBlank(message = "Phone number can't be null")
    @Pattern(regexp = "\\d{10}",message = "Tel no should contain only 10 digits")
    private String phoneNumber;

    public StaffLoginDto(String staffEmail, String phoneNumber) {
        this.staffEmail = staffEmail;
        this.phoneNumber = phoneNumber;
    }

    public StaffLoginDto() {
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "StaffLoginDto{" +
                "staffEmail='" + staffEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
