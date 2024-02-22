package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("admin/car")
    public Car addNewCar(@RequestBody Car newCar) throws AdminException
    {
        return this.adminServices.addNewCar(newCar);
    }
    @GetMapping("admin/car/search/{modelName}")
    public List<Car> getCarDetailsByModelName(@PathVariable("modelName") String  modelName) throws AdminException
    {
        return this.adminServices.getCarDetailsByModelName(modelName);
    }
    @PutMapping("admin/car/update")
    public Car updateCarDetails(@RequestBody Car updateCar) throws AdminException
    {
        return this.adminServices.updateCarDetails(updateCar);
    }
    @DeleteMapping("admin/car/delete/{id}")
    public Car deleteCarById(@PathVariable("id") Integer carId) throws AdminException
    {
        return this.adminServices.deleteCarById(carId);
    }
}