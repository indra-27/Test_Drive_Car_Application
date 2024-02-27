package com.training.testdriveapp.customer;

import com.training.testdriveapp.booking.Booking;
import com.training.testdriveapp.entity.Address;

import java.util.List;

public interface CustomerServices {
    Customer addNewCustomer(Customer newCustomer) throws CustomerException;

    List<Customer> getAllCustomers() throws CustomerException;

    Customer updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(Integer id) throws CustomerException;

    Customer login(LoginDto loginDto) throws CustomerException;

    Customer getCustomerById(Integer customerId)throws CustomerException;

   // Customer giveCustomerRating(Integer id)throws CustomerException;


    Customer  updateCustomerMobile(String email, String mobileNumber) throws CustomerException;

    Customer updateCustomerAddress(Integer id, Address address) throws CustomerException;

    Customer updateCustomerPassword(String email, String password) throws CustomerException;

  //  Customer getCustomerBookings(String email);


}
