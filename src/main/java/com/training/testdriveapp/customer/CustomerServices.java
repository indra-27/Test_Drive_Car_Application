package com.training.testdriveapp.customer;

import com.training.testdriveapp.rating.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerServices {
    Customer addNewCustomer(Customer newCustomer) throws CustomerException;

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(Integer id) throws CustomerException;

    Customer login(LoginDto loginDto) throws CustomerException;

    Customer getCustomerById(Integer customerId)throws CustomerException;

    List<Rating> getCustomerRating(Integer id)throws CustomerException;


    Customer  updateCustomerMobile(Integer id, String mobileNumber);
}
