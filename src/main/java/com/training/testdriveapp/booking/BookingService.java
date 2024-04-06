package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;

import java.time.LocalDate;
import java.util.List;


public interface BookingService {

    BookingOutputDto createNewBooking(BookingInputDto newBooking) throws BookingException;

    void deleteBooking(Integer bookId)throws BookingException;

    List<BookingOutputDto> getAllUserBookingByEmail(String mailId) throws BookingException;

    List<BookingOutputDto> getAllUserBookingBySlotNo(Integer slotNo) throws BookingException;

    List<BookingOutputDto> getAllUserBookingByDate(LocalDate date) throws BookingException;

    List<BookingOutputDto> getAllUserBookingByCarModelName(String carModelName)throws BookingException;

    List<BookingOutputDto> getAllBookings() throws BookingException;


    BookingOutputDto updateBooking(BookingInputDto updateBooking) throws BookingException;

    List<BookingOutputDto> getAllUserBookingsByStaffEmail(String staffEmail) throws BookingException;


    BookingOutputDto getBookingById(Integer id) throws BookingException;
    Booking updateBookingStatus(Integer bookid);
    List<Car> getCarDetailsByDate(LocalDate date) throws BookingException;

