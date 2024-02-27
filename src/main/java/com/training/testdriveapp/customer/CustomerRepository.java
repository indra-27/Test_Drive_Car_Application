package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByCustomerEmail(String email);
}
