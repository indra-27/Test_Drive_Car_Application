package com.training.testdriveapp.admin;

import com.training.testdriveapp.staff.Staff;
import com.training.testdriveapp.staff.StaffException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminServices {
    Car addNewCar(CarDto newCars) throws AdminException;

    List<Car> getCarDetailsByModelName(String modelName) throws AdminException;

    Car updateCarDetails(Car updateCar) throws AdminException;

    Car deleteCarById(Integer carId) throws AdminException;

    List<Car> getCarDetailsByCompany(String company) throws AdminException;

    List<Car> getCarDetailsWithinPriceRange(Double minprice, Double maxprice);
    List<Car> getAllCars();
}