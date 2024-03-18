package com.training.testdriveapp.admin;

import com.training.testdriveapp.rating.Rating;
import com.training.testdriveapp.staff.Staff;
import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Integer carId;
    private String company;
    private String modelName;
    private String color;
    private Double carPrice;
    private String engineModel;
    private String vehicleType;
    private String fuelType;
    private Integer seater;
    private Double mileage;
    private Double rpm;

    @Column(nullable = true, length = 64)
    private String image;

    @OneToOne
    private Staff staff;

    @OneToMany
    private List<Rating> ratings = new ArrayList<>();

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, String fuelType, Integer seater, Double mileage, Double rpm, Staff staff, List<Rating> ratings) {
        this.company = company;
        this.modelName = modelName;
        this.color = color;
        this.carPrice = carPrice;
        this.engineModel = engineModel;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.seater = seater;
        this.mileage = mileage;
        this.rpm = rpm;
        this.staff = staff;
        this.ratings = ratings;
    }

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, String fuelType, Integer seater, Double mileage, Double rpm, String image, Staff staff, List<Rating> ratings) {
        this.company = company;
        this.modelName = modelName;
        this.color = color;
        this.carPrice = carPrice;
        this.engineModel = engineModel;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.seater = seater;
        this.mileage = mileage;
        this.rpm = rpm;
        this.image = image;
        this.staff = staff;
        this.ratings = ratings;
    }

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, Integer seater, Double mileage, Double rpm, Staff staff, List<Rating> ratings) {
        this.company = company;
        this.modelName = modelName;
        this.color = color;
        this.carPrice = carPrice;
        this.engineModel = engineModel;
        this.vehicleType = vehicleType;
        this.seater = seater;
        this.mileage = mileage;
        this.rpm = rpm;
        this.staff = staff;
        this.ratings = ratings;
    }

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, Integer seater, Double mileage, Double rpm, Car testDriveCars, List<Rating> rating) {
        this.company = company;
        this.modelName = modelName;
        this.color = color;
        this.carPrice = carPrice;
        this.engineModel = engineModel;
        this.vehicleType = vehicleType;
        this.seater = seater;
        this.mileage = mileage;
        this.rpm = rpm;
        this.ratings = rating;
    }

    public Car() {
    }

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, Integer seater, Double mileage, Double rpm, List<Rating> rating) {
        this.company = company;
        this.modelName = modelName;
        this.color = color;
        this.carPrice = carPrice;
        this.engineModel = engineModel;
        this.vehicleType = vehicleType;
        this.seater = seater;
        this.mileage = mileage;
        this.rpm = rpm;
        this.ratings = rating;
    }

    @Transient
    public String getPhotosImagePath(){
        if(image == null) return null;
        return "/car-image/"+ carId + "/" + image;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getSeater() {
        return seater;
    }

    public void setSeater(Integer seater) {
        this.seater = seater;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getRpm() {
        return rpm;
    }

    public void setRpm(Double rpm) {
        this.rpm = rpm;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> rating) {
        this.ratings = rating;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}