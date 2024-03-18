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
    //1. To check if the Create Rating
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

    // 2. -ve testcase
    @Test
    void nullRatingTestInCreateCreateRatingTest()
    {
        Assertions.assertThrows(RatingException.class,()->ratingService.createNewRating(null));
    }

    //3. To check if the Crt Exception is thrown Create Rating
    @Test
    void nullCreateRatingTestExceptionMessageInCreateRatingTest()
    {
        try {
            ratingService.createNewRating(null);
        } catch (RatingException e) {
            Assertions.assertEquals("Rating Cannot Be NULL",e.getMessage());
        }
    }

    //4. To check if customer Exist Create Rating
    @Test
    void noCustomerExistInCreateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rgtsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }

    //5. To check if the CustomerExist Throws Correct Exception / MessageTo check if exception thrown is same Create Rating
    @Test
    void noCustomerExceptionMessageInCreateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rgtsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such Customer Exists", e.getMessage());
        }
    }

    // 6.To Check if the Car Exist Create Rating
    @Test
    void noCarInCreateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rsd8267@gmail.com",null,2,"good","Joy" )));
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }

    // 7.To check if the CarExist Throws Correct Exception / Message in Create Rating
    @Test
    void noCarExceptionMessageInCreateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.createNewRating((new RatingDto("rsd8267@gmail.com",ratingId,2,"good","i20" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such car exists", e.getMessage());
        }
    }

    //8. To check if the Update Rating
    @Test
    void updateNewRatingTest() throws RatingException {
        Integer ratingId=0;
        try {
            Rating ratings = this.ratingService.updateRating(new RatingDto("rsd8267@gmail.com",ratingId,2,"good","Figo" ));
            ratingId=ratings.getRatingId();
            Assertions.assertNotNull(ratings);
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }

    // 9. -ve testcase
    @Test
    void nullRatingTestInUpdateCreateRatingTest()
    {
        Assertions.assertThrows(RatingException.class,()->ratingService.updateRating(null));
    }

    //10. To check if the Crt Exception is thrown in UpdateRating
    @Test
    void nullUpdateRatingTestExceptionMessage()
    {
        try {
            ratingService.updateRating(null);
        } catch (RatingException e) {
            Assertions.assertEquals("Rating Cannot Be NULL",e.getMessage());
        }
    }
    //11. To check if customer Exist in UpdateRating
    @Test
    void noCustomerExistInUpdateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.updateRating((new RatingDto("rgtsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }

    //12. To check if the CustomerExist Throws Correct Exception in UpdateRating
    @Test
    void noCustomerExceptionMessageInUpdateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.updateRating((new RatingDto("rgtsd8267@gmail.com",ratingId,2,"good","Figo" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such Customer Exists", e.getMessage());
        }
    }

    // 13.To Check if the Car Exist in UpdateRating
    @Test
    void noCarInUpdateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.updateRating((new RatingDto("rsd8267@gmail.com",ratingId,2,"good","i20" )));
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }

    // 14.To check if the CarExist Throws Correct Exception in UpdateRating
    @Test
    void noCarExceptionMessageInUpdateRatingTest(){
        try {
            Integer ratingId=8;
            this.ratingService.updateRating((new RatingDto("rsd8267@gmail.com",ratingId,2,"good","i20" )));
        } catch (RatingException e) {
            Assertions.assertEquals("No such Car Exists", e.getMessage());
        }
    }

    // 15. To Delete a Rating
    @Test
    void deleteRatingByIdTest()
    {
        try
        {
            Integer ratingId=7;
            this.ratingService.createNewRating(new RatingDto("rsd8267@gmail.com",ratingId,5,"good","Figo"));
            this.ratingService.deleteRating(ratingId);
        }
        catch (RatingException e) {
        Assertions.fail(e.getMessage());
        }
    }

    // 16. To check if it throws correct exception in DeleteRating
    @Test
    void noCarIdExceptionMessageInDeleteRatingTest()
    {
        try
        {
            Integer ratingId=1002;
            this.ratingService.deleteRating(ratingId);
        }
        catch(RatingException e)
        {
            Assertions.assertEquals("Rating Id Does not exist",e.getMessage());
        }
    }

    // 17. To check Get all Ratings ByEmail
    @Test
    void getAllRatingsByEmailId() {
        try {
            Integer ratingId=1001;
            String emailId = "rsd8267@gmail.com";
            this.ratingService.createNewRating(new RatingDto("rsd8267@gmail.com",ratingId,5,"good","Figo"));
            this.ratingService.getRatingDtoOfCustomerByMailId(emailId);
        } catch (RatingException e) {
            Assertions.fail(e.getMessage());
        }
    }
    //18. To Check if the Exception thrown is Same For GetRatingsByEmail
    @Test
    void noEmailExceptionGetAllRating()
    {
        try {
            String emailId = "unknown@gmail.com";
            this.ratingService.getRatingDtoOfCustomerByMailId(emailId);
        } catch (RatingException e) {
            Assertions.assertEquals("The Mail Id does not exist",e.getMessage());
        }
    }

    

}
