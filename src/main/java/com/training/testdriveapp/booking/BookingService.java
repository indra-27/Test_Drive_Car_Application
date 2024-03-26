package com.training.testdriveapp.booking;

import java.time.LocalDate;
import java.util.List;


public interface BookingService {

    BookingOutputDto createNewBooking(BookingInputDto newBooking) throws BookingException;

    void deleteBooking(BookIdDto bookIdDto)throws BookingException;

    List<BookingOutputDto> getAllUserBookingByEmail(String mailId) throws BookingException;

    List<BookingOutputDto> getAllUserBookingBySlotNo(Integer slotNo) throws BookingException;

    List<BookingOutputDto> getAllUserBookingByDate(LocalDate date) throws BookingException;

    List<BookingOutputDto> getAllUserBookingByCarModelName(String carModelName)throws BookingException;

    List<BookingOutputDto> getAllBookings();
    //List<BookingOutputDto> getAllUserBookingByCarId(String carModelName)throws BookingException;
}
