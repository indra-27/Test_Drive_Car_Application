package com.training.testdriveapp.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Integer> {

    Optional<Staff> findBystaffId(Integer staffId);

    Optional<Staff> findBystaffEmail(String staffEmail);

    void deleteBystaffId(Integer staffId);
}
