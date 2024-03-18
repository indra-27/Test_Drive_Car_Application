package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("admin/car")
    public Car addNewCar(@RequestBody Car newCar) throws AdminException {
//        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        newCar.setImage(filename);
//        Car saveCar = this.adminServices.addNewCar(newCar);
//        String uploadDir = "car-image/"+saveCar.getCarId();
//        FileUploadFile.saveFile(uploadDir,filename,multipartFile);
        return this.adminServices.addNewCar(newCar);
    }
    @GetMapping("admin/car/all")
    public List<Car> getCarDetails() throws AdminException
    {
        return this.adminServices.getCarDetails();
    }
    @GetMapping("admin/car/search/{modelName}")
    public Car getCarDetailsByModelName(@PathVariable("modelName") String  modelName) throws AdminException
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
    public Car deleteCarById(@PathVariable("id") Integer carId) throws AdminException {
        return this.adminServices.deleteCarById(carId);
    }
}