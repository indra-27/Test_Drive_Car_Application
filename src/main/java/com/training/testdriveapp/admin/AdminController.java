package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AdminController {

    final AdminServices adminServices;

    @Autowired
    public AdminController(AdminServices adminServices){
        this.adminServices = adminServices;
    }

    @PostMapping("admin/car")
    public Car addNewCar(@RequestBody CarDto newCar) throws AdminException {
        return adminServices.addNewCar(newCar);
    }
    @GetMapping("admin/car/all")
    public List<Car> getCarDetails()
    {
        return this.adminServices.getCarDetails();
    }
    @GetMapping("admin/car/search/{modelName}")
    public Car getCarDetailsByModelName(@PathVariable("modelName") String  modelName) throws AdminException
    {
        return adminServices.getCarDetailsByModelName(modelName);
    }

    @PutMapping("admin/car/update")
    public Car updateCarDetails(@RequestBody CarDto updateCar) throws AdminException
    {
        return adminServices.updateCarDetails(updateCar);
    }
    @GetMapping("admin/car/filter/company/{company}")
    public List<Car> getCarDetailsByCompany(@PathVariable("company") String company) throws AdminException
    {
        return adminServices.getCarDetailsByCompany(company);
    }
    @GetMapping("admin/car/filter/price/{minprice}/{maxprice}")
    public List<Car> getCarDetailsWithinPriceRange(@PathVariable("minprice") Double minprice, @PathVariable("maxprice") Double maxprice)
    {
        return adminServices.getCarDetailsWithinPriceRange(minprice,maxprice);
    }
    @DeleteMapping("admin/car/delete/{id}")
    public Car deleteCarById(@PathVariable("id") Integer carId) throws AdminException {
        return adminServices.deleteCarById(carId);
    }
}