package com.training.testdriveapp.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerDto {

    @NotBlank(message = "Name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String customerName;

    @Pattern(regexp = "\\d{10}",message = "Tel no should contain only 10 digits")
    private String mobileNumber;

    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
//    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="Please provide valid email. e.g name@ford.com" )
    private String customerEmail;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&%$_]).{8,}",message = "Password must contain atleast 1 uppercase,1 lowercase,1 digit and 1 special character and minimum of length 8.")

    private String password;

    @NotBlank(message = "Address cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Address should contain min 3 & max 16 chars , no digits and special chars allowed.")
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
