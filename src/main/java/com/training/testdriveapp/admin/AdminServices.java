package com.training.testdriveapp.admin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminServices {
    Car addNewCar(CarDto newCars) throws AdminException;

    List<Car> getCarDetailsByModelName(String modelName) throws AdminException;

    Car updateCarDetails(Car updateCar) throws AdminException;

    Car deleteCarById(Integer carId) throws AdminException;
}