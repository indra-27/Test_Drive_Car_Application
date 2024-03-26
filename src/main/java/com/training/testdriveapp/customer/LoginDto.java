package com.training.testdriveapp.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LoginDto {
    @NotBlank(message = "UserName can't be null")
    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String userName;
    @NotBlank(message = "Password can't be null")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&%$_]).{8,}",message = "Password must contain atleast 1 uppercase,1 lowercase,1 digit and 1 special character and minimum of length 8.")
    private String password;

    public LoginDto() {
    }

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
