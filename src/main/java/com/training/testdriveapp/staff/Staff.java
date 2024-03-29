package com.training.testdriveapp.staff;


import com.training.testdriveapp.admin.Car;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;
    @NotBlank(message = "Name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String staffName;
    @NotBlank(message = "Phone number can't be null")
    @Pattern(regexp = "\\d{10}",message = "Tel no should contain only 10 digits")
    private String phoneNumber;
    @NotBlank(message = "Email can't be null")
    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String staffEmail;
//    @OneToOne
//    private Car car;
    private String modelName;

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }



    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    public String getModelName() {
        return modelName;

    }


    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public Staff() {
    }

    public Staff(String staffName, String phoneNumber, String staffEmail) {
        this.staffName = staffName;

        this.phoneNumber = phoneNumber;
        this.staffEmail = staffEmail;
    }

}
