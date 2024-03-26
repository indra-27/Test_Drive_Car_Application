package com.training.testdriveapp.customer;




public class CustomerDto {


    private String customerName;
    private String mobileNumber;

    private String customerEmail;

    private String password;
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(String mobileNumber,String name, String email, String password,  String address) {
        super();
        this.mobileNumber=mobileNumber;

        this.customerName = name;
        this.customerEmail = email;
        this.password = password;

        this.address = address;
    }

    public CustomerDto(int i, String karthi, String chennai, String number, String mail, String s) {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }






    @Override
    public String toString() {
        return "CustomerDto{" +
                "mobile"+mobileNumber+
                ", name='" + customerName + '\'' +
                ", email='" + customerEmail + '\'' +
                ", password='" + password + '\'' +

//
                '}';
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
