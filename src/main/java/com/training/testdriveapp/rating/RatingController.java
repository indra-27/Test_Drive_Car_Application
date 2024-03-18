package com.training.testdriveapp.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //1. Create Review
    @PostMapping("/rating/create")
    public Rating createRating(@RequestBody RatingDto rating) throws RatingException {
        return this.ratingService.createNewRating(rating);
    }


    //2. Displaying all the Ratings
    @GetMapping("rating/all")
    public List<Rating> findAllRating() throws RatingException {
        return this.ratingService.getAllRating();
    }


    // 3. Getting the Rating list for particular customer mail
    @GetMapping("rating/{customerMail}")
    public List<Rating> getRatingsOfCustomerByMailId(@PathVariable String customerMail) throws RatingException {
        return ratingService.getRatingsOfCustomerByMailId(customerMail);
    }

    // 4. Getting the Rating List(DTO) for the Customer mailId
    @GetMapping("/rating/DTO/{customerMail}/")
    public List<RatingDto> getRatingsListOfCustomerByMailId(@PathVariable String customerMail) throws RatingException {
        return ratingService.getRatingDtoOfCustomerByMailId(customerMail);
    }


    // 5.Updating the Reviews
    @PutMapping("/rating/update")
    public Rating updateRatingById(@RequestBody RatingDto rating) throws RatingException {
        return this.ratingService.updateRating(rating);
    }
   // 6.Deleting the Reviews By Id
    @DeleteMapping("/rating/delete/{id}")
    public void deleteRatingById(@PathVariable Integer id) throws RatingException
    {
        this.ratingService.deleteRating(id);

    }

    // 7. Filtering Rating Between given Value
    @GetMapping("rating/{min}/{max}")
    public List<Rating> findAllRatingBetweenRange(@PathVariable Integer min, @PathVariable Integer max) throws RatingException {
        return this.ratingService.getAllRatingsBetweenRange(min,max);
    }

    // 8. Listing all the  RatingDto to customer
//    @GetMapping("rating/dto")
//    public List<RatingDto> findAllRatingDto() throws RatingException {
//        return this.ratingService.getAllRatingDto();
//    }


}
