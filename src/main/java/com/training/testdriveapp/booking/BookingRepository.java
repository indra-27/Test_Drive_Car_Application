package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;

import com.training.testdriveapp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByCustomer(Customer customer);
    List<Booking> findBySlotNoOrderBySlotNo(Integer slotNo);
    List<Booking> findByDate(LocalDate date);
    List<Booking> findByTestDriveCar(Car car);
    Booking findByTestDriveCarAndDateAndSlotNo(Car car,LocalDate date,Integer slotNo);
//    List<Booking> findBy
}
