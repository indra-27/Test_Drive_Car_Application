package com.training.testdriveapp.customer;


import com.training.testdriveapp.booking.Booking;




import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin( {"http://localhost:4200/","http://localhost:3000/"})
public class CustomerController {
    @Autowired
    public CustomerController(CustomerServices customerServices){
        this.customerServices=customerServices;
    }

    private CustomerServices customerServices;

    @PostMapping("customer")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer addNewCustomer(@Valid @RequestBody CustomerDto customer) throws CustomerException{
        return this.customerServices.addNewCustomer(customer);

    }

    @GetMapping("customer/AllCustomers")
    public List<Customer> getAllCustomers() throws  CustomerException{
        return this.customerServices.getAllCustomers();
    }

    @PutMapping("customer/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) throws CustomerException{
        return this.customerServices.updateCustomer(customer);

    }

    @PatchMapping("customer/updateCustomerMobileNumber/{email}/{mobileNumber}")
    public Customer updateCustomerMobile(@PathVariable String email, @PathVariable String mobileNumber) throws CustomerException {
        return this.customerServices.updateCustomerMobile(email,mobileNumber);
    }

    @PatchMapping("customer/updateCustomerAddress/{id}/{address}")
    public Customer updateCustomerAddress(@PathVariable Integer id, @PathVariable String address) throws CustomerException {
        return this.customerServices.updateCustomerAddress(id,address);
    }

    @PatchMapping("customer/updateCustomerpassword/{email}/{password}")
    public Customer updateCustomerPAssword(@PathVariable String email, @PathVariable String password) throws CustomerException {
        return this.customerServices.updateCustomerPassword(email,password);
    }

    @DeleteMapping("customer/delete/{email}")
    public void deleteCustomerById(@PathVariable String email) throws CustomerException
    {
        this.customerServices.deleteCustomer(email);

    }

    @PostMapping("customer/login")
    public Customer login(@RequestBody LoginDto loginDto) throws CustomerException {
        return this.customerServices.login(loginDto);
    }

    @GetMapping("customer/withaddress/{id}")
    public Customer getCustomerById(@PathVariable Integer id) throws CustomerException{
        return this.customerServices.getCustomerById(id);
    }

   @GetMapping("customer/allCustomers/{email}")
    public  Customer getCustomerByEmail(@PathVariable String email)throws CustomerException{
        return this.customerServices.getCustomerByEmail(email);
   }

   @GetMapping("customer/AllBookings/{email}")
    public List<Booking> getCustomerBookingsByEmail(@PathVariable String email) throws CustomerException {
        return this.customerServices.getCustomerBookingsByEmail(email);

   }
   @GetMapping("car/carouselImages")
   public List<String> getCarouselImages() {

       return this.customerServices.getCarouselImages();
   }

   @PostMapping("customer/forgotPassword/{email}/{password}")
    public Customer forgotPassword(@PathVariable String email,@PathVariable String password)throws CustomerException{
        return this.customerServices.forgotPassword(email,password);
   }




}
