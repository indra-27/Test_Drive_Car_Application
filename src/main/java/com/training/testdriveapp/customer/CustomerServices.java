package com.training.testdriveapp.customer;

import com.training.testdriveapp.booking.Booking;


import java.util.List;

public interface CustomerServices {
    Customer addNewCustomer(CustomerDto newCustomer) throws CustomerException;



    Customer updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(String email) throws CustomerException;

    Customer login(LoginDto loginDto) throws CustomerException;

    Customer getCustomerById(Integer customerId)throws CustomerException;

   // Customer giveCustomerRating(Integer id)throws CustomerException;


    Customer  updateCustomerMobile(String email, String mobileNumber) throws CustomerException;

    Customer updateCustomerAddress(Integer id, String address) throws CustomerException;

    Customer updateCustomerPassword(String email, String password) throws CustomerException;

    List<Customer> getAllCustomers() throws CustomerException;


    Customer getCustomerByEmail(String email) throws CustomerException;

    List<Booking> getCustomerBookingsByEmail(String email);
}
