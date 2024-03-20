package com.training.testdriveapp.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("booking/new")
    public BookingOutputDto createNewBooking(@RequestBody BookingInputDto newBooking) throws BookingException
    {
        return this.bookingService.createNewBooking(newBooking);
    }
    @DeleteMapping("booking/{bookId}")
    public void deleteBooking(@PathVariable Integer bookId) throws BookingException
    {
        this.bookingService.deleteBooking(bookId);
    }
    @PutMapping("booking")
    public BookingOutputDto updateBooking(@RequestBody BookingInputDto updateBooking) throws BookingException
    {
        return this.bookingService.updateBooking(updateBooking);
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
    public List<BookingOutputDto> getAllBookings() throws BookingException
    {
        return  this.bookingService.getAllBookings();
    }
    @GetMapping("booking/staff/all/{staffEmail}")
    public List<BookingOutputDto> getAllUserBookingsByStaffEmail(@PathVariable String staffEmail)throws BookingException
    {
        return this.bookingService.getAllUserBookingsByStaffEmail(staffEmail);
    }
    @GetMapping("booking/{id}")
    public BookingOutputDto getBookingById(@PathVariable Integer id) throws BookingException
    {
        return this.bookingService.getBookingById(id);
    }
}
