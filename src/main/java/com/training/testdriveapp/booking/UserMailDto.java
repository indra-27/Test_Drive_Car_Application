package com.training.testdriveapp.booking;

public class UserMailDto {
    private String customerEmail;

    public UserMailDto(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public UserMailDto() {
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
