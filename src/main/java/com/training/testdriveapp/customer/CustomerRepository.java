package com.training.testdriveapp.customer;

import com.training.testdriveapp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByCustomerEmail(String emailId);
}
