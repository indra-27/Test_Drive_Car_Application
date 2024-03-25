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
            BookingOutputDto booking = this.bookingService.createNewBooking(new BookingInputDto("dhanya@gmail.com","EcoSport",3,LocalDate.of(2024,2,12),LocalDate.of(2024,2,9)));
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

    @Test
    void deleteBookingTest()
    {
        try{
            this.bookingService.deleteBooking(new BookIdDto(653));
        }
        catch (BookingException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullDeleteBookingTestInDeleteBookingByBookId()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.deleteBooking(new BookIdDto(null)));
    }
    @Test
    void nullDeleteBookingTestExceptionMessageInDeleteBookingByBookId()
    {
        try {
            this.bookingService.deleteBooking(new BookIdDto(null));
        } catch (BookingException e) {
            Assertions.assertEquals("Id can't be null",e.getMessage());
        }
    }
    @Test
    void deleteBookingByBookIdNoSuchBookIdExists()
    {
        try {
            this.bookingService.deleteBooking(new BookIdDto(-98));
        } catch (BookingException e) {
            Assertions.assertEquals("No such Book Id exists",e.getMessage());
        }
    }
    @Test
    void getAllUserBookingsByEmailTest()
    {
        try{
            this.bookingService.getAllUserBookingByEmail("indra@gmail.com");
        }
        catch (BookingException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullEmailIdTestInGetAllBookingsByEmail()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.getAllUserBookingByEmail(null));
    }
    @Test
    void nullEmailIdTestExceptionMessageInGetAllBookingsByEmail()
    {
        try {
            this.bookingService.getAllUserBookingByEmail(null);
        } catch (BookingException e) {
            Assertions.assertEquals("Mail Id can't be null",e.getMessage());
        }
    }
    @Test
    void noSuchCustomerExistsTestInGetAllBookingsByEmail()
    {
        try {
            this.bookingService.getAllUserBookingByEmail("abcd@gmail.com");
        } catch (BookingException e) {
            Assertions.assertEquals("No such Customer exists",e.getMessage());
        }
    }

    @Test
    void getAllUserBookingsBySlotNoTest()
    {
        try{
            this.bookingService.getAllUserBookingBySlotNo(4);
        }
        catch (BookingException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullSlotNoTestInGetAllBookingsBySlotNo()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.getAllUserBookingBySlotNo(null));
    }
    @Test
    void nullSlotNoTestExceptionMessageInGetAllBookingsBySlotNo()
    {
        try {
            this.bookingService.getAllUserBookingBySlotNo(null);
        } catch (BookingException e) {
            Assertions.assertEquals("Slot no can't be null",e.getMessage());
        }
    }
    @Test
    void noSuchSlotNoExistsTestInGetAllBookingsBySlotNo()
    {
        try {
            this.bookingService.getAllUserBookingBySlotNo(10);
        } catch (BookingException e) {
            Assertions.assertEquals("Invalid Slot Number",e.getMessage());
        }
    }
    @Test
    void getAllUserBookingsByDateTest()
    {
        try{
            this.bookingService.getAllUserBookingByDate(LocalDate.of(2024,2,3));
        }
        catch (BookingException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
        void nullDateTestInGetAllBookingsByDate()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.getAllUserBookingByDate(null));
    }
    @Test
    void nullDateTestExceptionMessageInGetAllBookingsByDate()
    {
        try {
            this.bookingService.getAllUserBookingByDate(null);
        } catch (BookingException e) {
            Assertions.assertEquals("Date can't be null",e.getMessage());
        }
    }

    @Test
    void getAllUserBookingsByCarModelNameTest()
    {
        try{
            this.bookingService.getAllUserBookingByCarModelName("EcoSport");
        }
        catch (BookingException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullCarModelNameTestInGetAllBookingsByCarModelName()
    {
        Assertions.assertThrows(BookingException.class,()->bookingService.getAllUserBookingByCarModelName(null));
    }
    @Test
    void nullCarModelNameTestExceptionMessageInGetAllBookingsByCarModelName()
    {
        try {
            this.bookingService.getAllUserBookingByCarModelName(null);
        } catch (BookingException e) {
            Assertions.assertEquals("Car model name can't be null",e.getMessage());
        }
    }
    @Test
    void noSuchCarExistsTestInGetAllBookingsByCarModelName()
    {
        try {
            this.bookingService.getAllUserBookingByCarModelName("Chennai");
        } catch (BookingException e) {
            Assertions.assertEquals("No such Car exists",e.getMessage());
        }
    }



}
