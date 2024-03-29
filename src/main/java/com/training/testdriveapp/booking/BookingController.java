package com.training.testdriveapp.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("booking/new")
    public BookingOutputDto createNewBooking(@RequestBody BookingInputDto newBooking) throws BookingException
    {
        return this.bookingService.createNewBooking(newBooking);
    }
    @DeleteMapping("booking/delete")
    public void deleteBooking(@RequestBody BookIdDto bookIdDto) throws BookingException
    {
        this.bookingService.deleteBooking(bookIdDto);
    }
    @GetMapping("booking/user/all/{mailId}")
    public List<BookingOutputDto> getAllUserBookingByEmail(@PathVariable String mailId) throws BookingException {
      return this.bookingService.getAllUserBookingByEmail(mailId);
    }

    @GetMapping("booking/slot/all/{slotNo}")
    public List<BookingOutputDto> getAllUserBookingBySlotNo(@PathVariable Integer slotNo) throws BookingException {
        return this.bookingService.getAllUserBookingBySlotNo(slotNo);
    }

    @GetMapping("booking/date/all/{date}")
    public List<BookingOutputDto> getAllUserBookingByDate(@PathVariable LocalDate date) throws BookingException
    {
        return this.bookingService.getAllUserBookingByDate(date);
    }

    @GetMapping("booking/car/all/{carModelName}")
    public List<BookingOutputDto> getAllUserBookingByCarId(@PathVariable String carModelName) throws BookingException
    {
        return this.bookingService.getAllUserBookingByCarModelName(carModelName);
    }
    @GetMapping("booking/car/all")
    public List<BookingOutputDto> getAllBookings()
    {
        return  this.bookingService.getAllBookings();
    }


}
