package com.training.testdriveapp.staff;

public class StaffLoginDto {
    private String staffEmail;
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
