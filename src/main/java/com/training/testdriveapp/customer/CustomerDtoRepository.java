package com.training.testdriveapp.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDtoRepository extends JpaRepository<CustomerDto,Integer> {
    CustomerDto findCustomerDtoByEmail(String email);
}
