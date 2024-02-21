package com.training.testdriveapp.customer;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import com.training.testdriveapp.customer.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addNewCustomer(Customer newCustomer) {
        return this.customerRepository.save(newCustomer);
    }
}
