package com.training.testdriveapp.customer;

import com.training.testdriveapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
