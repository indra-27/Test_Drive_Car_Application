package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("admin/car")
    public Car addNewCars(@RequestBody Car newCars)
    {
        return this.adminServices.addNewCars(newCars);
    }
}
