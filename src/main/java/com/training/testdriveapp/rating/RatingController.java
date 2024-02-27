package com.training.testdriveapp.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public List<Rating> getRatingsOfCustomerByMailId(@PathVariable String customerMail)
    {
        return ratingService.getRatingsOfCustomerByMailId(customerMail);
    }

    // 4. Getting the Rating List(DTO) for the Cutomer mailid
    @GetMapping("/rating/DTO/{customerMail}/")
    public List<RatingDto> getRatingsListOfCustomerByMailId(@PathVariable String customerMail)
    {
        return ratingService.getRatingDtoOfCustomerByMailId(customerMail);
    }

    //Getting Review By RatingID
    //@GetMapping("rating/{id}")
   // public Rating findRatingById(@PathVariable Integer id) throws RatingException {
     //   return this.ratingService.getRatingById(id);}

    // Updating the Reviews
    @PutMapping("/rating/update")
    public Rating updateRatingById(@RequestBody Rating rating) throws RatingException {
        return this.ratingService.updateRating(rating);
    }
// Deleting the Reviews By Id
    @DeleteMapping("/rating/delete/{id}")
    public void deleteRatingById(@PathVariable Integer id) throws RatingException
    {
        this.ratingService.deleteRating(id);

    }

    //Filtering Rating Between given Value
    @GetMapping("rating/{min}/{max}")
    public List<Rating> findAllRatingBetweenRange(@PathVariable Integer min,Integer max) throws RatingException {
        return this.ratingService.getAllRatingsBetweenRange(min,max);
    }


// Filtering Based On CarID
// Filtering Based on CustomerId

}
