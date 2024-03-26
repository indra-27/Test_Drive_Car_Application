package com.training.testdriveapp.admin;

import com.training.testdriveapp.rating.Rating;
import com.training.testdriveapp.staff.Staff;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Integer carId;
    @NotBlank(message = "Company name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Company Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String company;
    @NotBlank(message = "Model name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,16}", message = "Model Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String modelName;
    @NotBlank(message = "Color name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Color should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String color;
    @NotBlank(message = "Car price can't be null")
    private Double carPrice;
    @NotBlank(message = "Engine model can't be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,10}", message = "Engine model should contain min 3 & max 16 chars and no special chars allowed.")
    private String engineModel;
    @NotBlank(message = "Vehicle Type can't be null")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Vehicle type should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String vehicleType;
    @NotBlank(message = "Fuel Type can't be null")
    @Pattern(regexp = "[a-zA-Z ]{3,16}", message = "Fuel type should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String fuelType;
    @NotBlank(message = "Seater can't be null")
    @Min(value = 2,message = "Minimum will be 2")
    @Max(value = 9,message = "Maximum will be 9")
    private Integer seater;
    @NotBlank(message = "Mileage can't be null")
    @Pattern(regexp = "[0-9]{3,10}")
    private Double mileage;
    @NotBlank(message = "RPM can't be null")
    @Pattern(regexp = "[0-9]{3,10}")
    private Double rpm;
    @NotBlank(message = "Description can't be null")
    private String description;
    @NotBlank(message = "Image can't be null")
    @Column(nullable = true)
    private String image;

    @OneToOne
    private Staff staff;

    @OneToMany
    private List<Rating> ratings = new ArrayList<>();

    public Car(String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, String fuelType, Integer seater, Double mileage, Double rpm, String description, String image, Staff staff, List<Rating> ratings) {
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
        this.description = description;
        this.image = image;
        this.staff = staff;
        this.ratings = ratings;
    }

    public Car() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}