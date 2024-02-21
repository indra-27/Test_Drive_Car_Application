package com.training.testdriveapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @PostMapping("customer")
    public Customer addNewCustomer(Customer newCustomer)
    {
        return this.customerServices.addNewCustomer(newCustomer);
    }
}
