package com.training.testdriveapp.admin;

public class CarDto {
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
    private String image;
    private String description;

    public CarDto(Integer carId, String company, String modelName, String color, Double carPrice, String engineModel, String vehicleType, String fuelType, Integer seater, Double mileage, Double rpm, String image, String description) {
        this.carId = carId;
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
        this.description = description;
    }

    public CarDto(){

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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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
