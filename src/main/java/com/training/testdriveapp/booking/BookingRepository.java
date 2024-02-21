package com.training.testdriveapp.booking;

import com.training.testdriveapp.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
