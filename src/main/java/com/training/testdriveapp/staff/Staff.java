package com.training.testdriveapp.staff;

import com.training.testdriveapp.admin.Car;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;
    private String staffName;

    private String phoneNumber;
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
