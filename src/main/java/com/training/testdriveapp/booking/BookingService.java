package com.training.testdriveapp.booking;

import org.springframework.stereotype.Service;


public interface BookingService {
    Booking createNewBooking(BookingDto newBooking);

    void deleteBooking(BookIdDto bookIdDto);
}
