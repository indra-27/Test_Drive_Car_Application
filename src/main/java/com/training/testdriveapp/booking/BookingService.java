package com.training.testdriveapp.booking;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public interface BookingService {

    Booking createNewBooking(BookingDto newBooking) throws BookingException;

    void deleteBooking(BookIdDto bookIdDto)throws BookingException;
}
