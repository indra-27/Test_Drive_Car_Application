package com.training.testdriveapp.customer;

import com.training.testdriveapp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
