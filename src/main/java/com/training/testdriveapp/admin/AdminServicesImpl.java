package com.training.testdriveapp.admin;

import com.training.testdriveapp.admin.AdminServices;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    private CarRepository carsRepository;
    @Override
    public Car addNewCars(Car newCars) {
        return this.carsRepository.save(newCars);
    }
}
