package com.training.testdriveapp.ratingTest;

import com.training.testdriveapp.booking.BookingException;
import com.training.testdriveapp.booking.BookingInputDto;
import com.training.testdriveapp.rating.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class RatingTestCases {
    @Qualifier("ratingServiceImpl")
    @Autowired
private RatingService ratingService;
    @Test
    void createNewRatingTest() throws RatingException {
        Integer ratingId=0;
        try {
            Rating ratings = this.ratingService.createNewRating(new RatingDto("rsd8267@gmail.com",ratingId,2,"good","Figo" ));
            ratingId=ratings.getRatingId();
            Assertions.assertNotNull(ratings);
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }
    //-ve testcase
    @Test
    void nullRatingTestInCreateNewRatingTest()
    {
        Assertions.assertThrows(RatingException.class,()->ratingService.createNewRating(null));
    }
    // To check if the Crt Exception is thrown
    @Test
    void nullCreateBookingTestExceptionMessageInNewBookingTest()
    {
        try {
            ratingService.createNewRating(null);
        } catch (RatingException e) {
            Assertions.assertEquals("Rating Cannot be null",e.getMessage());
        }
    }

    // To check if customer Exisit
    @Test
    void noCustomerTestExceptionMessageInNewRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such Customer Exists", e.getMessage());
        }
    }


    @Test
    void noCarTestExceptionMessageInNewRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such car exists", e.getMessage());
        }
    }
}
