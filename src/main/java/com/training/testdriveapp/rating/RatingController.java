package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //Create Review
    @PostMapping("/rating/create")
    public Rating createRating(@RequestBody Rating rating) throws RatingException {
        return this.ratingService.createNewRating(rating);
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
    // Filtering Based On Rating
    @GetMapping("rating/search/{rating}")
    public List<Rating> getCarDetailsByModelName(@PathVariable("rating") Integer rating) throws AdminException
    {
        return null;//this.ratingService.getRatingByRatingStars(rating);
    }
// Filtering Based On CarID
// Filtering Based on CustomerId

}
