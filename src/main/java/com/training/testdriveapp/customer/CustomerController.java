package com.training.testdriveapp.customer;


import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class CustomerController {
    @Autowired
    public CustomerController(CustomerServices customerServices){
        this.customerServices=customerServices;
    }

    private CustomerServices customerServices;

    @PostMapping("customer")
    public Customer addNewCustomer(@RequestBody Customer customer) throws CustomerException{
        return this.customerServices.addNewCustomer(customer);

    }

    @GetMapping("customer/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return this.customerServices.getAllCustomers();

    }

    @PutMapping("customer/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) throws CustomerException{
        return this.customerServices.updateCustomer(customer);

    }

    @PatchMapping("customer/updateCustomerMobileNumber/{id}/{mobileNumber}")
    public Customer updateCustomerMobile(@PathVariable Integer id, @PathVariable String mobileNumber){
        return this.customerServices.updateCustomerMobile(id,mobileNumber);
    }

    @PatchMapping("customer/updateCustomerAddress/{id}/{address}")
    public Customer updateCustomerAddress(@PathVariable Integer id, @PathVariable Address address) throws CustomerException {
        return this.customerServices.updateCustomerAddress(id,address);
    }

    @PatchMapping("customer/updateCustomerpassword/{email}/{password}")
    public Customer updateCustomerPAssword(@PathVariable String email, @PathVariable String password) throws CustomerException {
        return this.customerServices.updateCustomerPassword(email,password);
    }

    @DeleteMapping("customer/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) throws CustomerException
    {
        this.customerServices.deleteCustomer(id);

    }

    @PostMapping("customer/login")
    public Customer login(@RequestBody LoginDto loginDto) throws CustomerException {
        return this.customerServices.login(loginDto);
    }

    @GetMapping("customer/withaddress/{id}")
    public Customer getCustomerById(@PathVariable Integer id) throws CustomerException{
        return this.customerServices.getCustomerById(id);
    }

//    @PostMapping("customer/getCustomersRatings")
//    public Customer getCustomerRating(@RequestBody CustomerDto customerDto) throws CustomerException{
//        return this.customerServices.getCustomerRating(customerDto);
//    }


}
