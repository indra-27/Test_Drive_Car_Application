package com.training.testdriveapp.rating;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //Create Review
    @PostMapping("/rating")
    public Rating createRating(@RequestBody Rating rating) throws RatingException {
        return this.ratingService.createNewRating(rating);
    }

    //Filtering Rating Between given Value
    @GetMapping("rating/{min}/{max}")
    public List<Rating> findAllRatingBetweenRange(@PathVariable Integer min,Integer max) throws RatingException {
        return this.ratingService.getAllRatingsBetweenRange(min,max);
    }

    // Displaying all the Ratings
    @GetMapping("rating/all")
    public List<Rating> findAllRating() throws RatingException {
        return this.ratingService.getAllRating();
    }

    //Getting Review By RatingID
    @GetMapping("rating/{id}")
    public Rating findRatingById(@PathVariable Integer id) throws RatingException {
        return this.ratingService.getRatingById(id);
    }

    // Updating the Reviews
    @PutMapping("/rating/update")
    public Rating updateRatingById(@RequestBody Rating rating) throws RatingException {
        return this.ratingService.updateRatingById(rating);
    }

    @DeleteMapping("/rating/delete/{id}")
    public void deleteRatingById(@PathVariable Integer id) throws RatingException
    {
        this.ratingService.deleteRating(id);

    }

// Deleting the Reviews By Id

// Filtering Based On CarID
// Filtering Based On Ra

}
