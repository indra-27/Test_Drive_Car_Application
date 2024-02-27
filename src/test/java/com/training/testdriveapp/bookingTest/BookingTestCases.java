package com.training.testdriveapp.bookingTest;

import com.training.testdriveapp.booking.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
 class TestCasesBooking{
    @Autowired
    private BookingService bookingService;

    //+ve testcase
    @Test
    void createNewBookingTest() throws BookingException {
        Integer bookId=0;
        try {
            BookingOutputDto booking = this.bookingService.createNewBooking(new BookingInputDto("indra@gmail.com","EcoSport",3,LocalDate.of(2024,2,27),LocalDate.of(2024,2,23)));
            bookId=booking.getBookId();
            Assertions.assertNotNull(booking);
        } catch (BookingException e) {
            Assertions.fail(e.getMessage());
        }
        finally {
            BookIdDto bookIdDto = new BookIdDto();
            bookIdDto.setBookId(bookId);
            this.bookingService.deleteBooking(bookIdDto);
        }
    }

    //-ve testcase
    @Test
    void nullBookingTestInCreateNewBookingTest()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.createNewBooking(null));
    }

    @Test
    void nullCreateBookingTestExceptionMessageInNewBookingTest()
    {
        try {
            bookingService.createNewBooking(null);
        } catch (BookingException e) {
            Assertions.assertEquals("Booking Input can't be null",e.getMessage());
        }
    }


    @Test
    void noCustomerTestExceptionMessageInNewBookingTest(){
        try {
            this.bookingService.createNewBooking((new BookingInputDto("abcd@gmail.com","EcoSport",4,LocalDate.of(2024,2,27),LocalDate.of(2024,2,23))));
        } catch (BookingException e) {
            Assertions.assertEquals("No such Customer Exists", e.getMessage());
        }
    }

    @Test
    void noCarTestExceptionMessageInNewBookingTest(){
        try {
            this.bookingService.createNewBooking((new BookingInputDto("indra@gmail.com","Chennai",6,LocalDate.of(2024,2,27),LocalDate.of(2024,2,23))));
        } catch (BookingException e) {
            Assertions.assertEquals("No such car exists", e.getMessage());
        }
    }

    @Test
    void wrongSlotNumberTestExceptionMessageInNewBookingTest(){
        try {
            this.bookingService.createNewBooking((new BookingInputDto("indra@gmail.com","EcoSport",-8,LocalDate.of(2024,2,27),LocalDate.of(2024,2,23))));
        } catch (BookingException e) {
            Assertions.assertEquals("Invalid Slot Number", e.getMessage());
        }
    }

    @Test
    void wrongDateTestExceptionMessageInNewBookingTest(){
        try {
            this.bookingService.createNewBooking((new BookingInputDto("indra@gmail.com","EcoSport",6,LocalDate.of(2024,2,18),LocalDate.of(2024,2,23))));
        } catch (BookingException e) {
            Assertions.assertEquals("The Booking date has to be less than Test drive date", e.getMessage());
        }
    }

    @Test
    void slotAlreadyBookedTestExceptionMessageInNewBookingTest(){
        try {
            this.bookingService.createNewBooking(new BookingInputDto("indra@gmail.com","EcoSport",3,LocalDate.of(2024,2,27),LocalDate.of(2024,2,23)));
        } catch (BookingException e) {
            Assertions.assertEquals("Slot already booked", e.getMessage());
        }
    }





}
