package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("admin/car")
    public Car addNewCar(@RequestBody CarDto newCar) throws AdminException
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
    @GetMapping("admin/car/filter/company/{company}")
    public List<Car> getCarDetailsByCompany(@PathVariable("company") String company) throws AdminException
    {
        return this.adminServices.getCarDetailsByCompany(company);
    }
    @GetMapping("admin/car/filter/price/{minprice}/{maxprice}")
    public List<Car> getCarDetailsWithinPriceRange(@PathVariable("minprice") Double minprice, @PathVariable("maxprice") Double maxprice)
    {
        return this.adminServices.getCarDetailsWithinPriceRange(minprice,maxprice);
    }

    @DeleteMapping("admin/car/delete/{id}")
    public Car deleteCarById(@PathVariable("id") Integer carId) throws AdminException
    {
        return this.adminServices.deleteCarById(carId);
    }

}