package com.training.testdriveapp.booking;

import java.util.List;


public interface BookingService {

    BookingOutputDto createNewBooking(BookingInputDto newBooking) throws BookingException;

    void deleteBooking(BookIdDto bookIdDto)throws BookingException;

    List<BookingOutputDto> getAllUserBookingByEmail(String mailId) throws BookingException;

    List<BookingOutputDto> getAllUserBookingBySlotNo(Integer slotNo) throws BookingException;
}
