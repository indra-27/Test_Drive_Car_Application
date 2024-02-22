package com.training.testdriveapp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("newBooking")
    public Booking createNewBooking(@RequestBody BookingDto newBooking)
    {
        return this.bookingService.createNewBooking(newBooking);
    }
    @DeleteMapping("deleteBooking")
    public void deleteBooking(@RequestBody BookIdDto bookIdDto)
    {
        this.bookingService.deleteBooking(bookIdDto);
    }
}
