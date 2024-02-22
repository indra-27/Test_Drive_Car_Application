package com.training.testdriveapp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking createNewBooking(BookingDto newBooking) {
        return this.bookingRepository.save(new Booking());
    }
}
