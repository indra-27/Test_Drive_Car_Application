package com.training.testdriveapp.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findBymodelName(String name);
}