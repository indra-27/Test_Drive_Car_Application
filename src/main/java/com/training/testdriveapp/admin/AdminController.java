package com.training.testdriveapp.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(value = {"http://localhost:4200/","http://localhost:3000/"})
public class AdminController {

    final AdminServices adminServices;

    @Autowired
    public AdminController(AdminServices adminServices){
        this.adminServices = adminServices;
    }

    @PostMapping("admin/car")
    public Car addNewCar(@Valid @RequestBody CarDto newCar) throws AdminException {
        return adminServices.addNewCar(newCar);
    }
    @GetMapping("admin/car/all")
    public List<Car> getCarDetails()
    {
        return this.adminServices.getCarDetails();
    }
    @GetMapping("admin/car/search/{modelName}")
    public Car getCarDetailsByModelName(@Valid @PathVariable("modelName") String  modelName) throws AdminException
    {
        return adminServices.getCarDetailsByModelName(modelName);
    }

    @PutMapping("admin/car/update")
    public Car updateCarDetails(@Valid @RequestBody CarDto updateCar) throws AdminException
    {
        return adminServices.updateCarDetails(updateCar);
    }
    @GetMapping("admin/car/filter/company/{company}")
    public List<Car> getCarDetailsByCompany(@Valid @PathVariable("company") String company) throws AdminException
    {
        return adminServices.getCarDetailsByCompany(company);
    }
    @GetMapping("admin/car/filter/price/{minprice}/{maxprice}")
    public List<Car> getCarDetailsWithinPriceRange(@Valid @PathVariable("minprice") Double minprice, @PathVariable("maxprice") Double maxprice)
    {
        return adminServices.getCarDetailsWithinPriceRange(minprice,maxprice);
    }
    @DeleteMapping("admin/car/delete/{id}")
    public Car deleteCarById(@Valid @PathVariable("id") Integer carId) throws AdminException {
        return adminServices.deleteCarById(carId);
    }
}