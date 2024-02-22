package com.training.testdriveapp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookingController {



    @Autowired
    private BookingService bookingService;
    @PostMapping("newBooking")
    public Booking createNewBooking(@RequestBody BookingDto newBooking) throws BookingException
    {
        return this.bookingService.createNewBooking(newBooking);
    }
    @DeleteMapping("deleteBooking")
    public void deleteBooking(@RequestBody BookIdDto bookIdDto) throws BookingException
    {
        this.bookingService.deleteBooking(bookIdDto);
    }
}
