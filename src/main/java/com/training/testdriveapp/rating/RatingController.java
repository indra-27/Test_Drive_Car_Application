package com.training.testdriveapp.rating;

import jakarta.validation.Valid;
import com.training.testdriveapp.admin.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //1. Create Review
    @PostMapping("/rating/create")
    public Rating createRating(@Valid @RequestBody RatingDto rating) throws RatingException {
        return this.ratingService.createNewRating(rating);
    }


    //2. Displaying all the Ratings
    @GetMapping("rating/all")
    public List<Rating> findAllRating() throws RatingException {
        return this.ratingService.getAllRating();
    }


    // 3. Getting the Rating list for particular customer mail
    @GetMapping("rating/{customerMail}")
    public List<Rating> getRatingsOfCustomerByMailId(@Valid @PathVariable String customerMail) throws RatingException {
        return ratingService.getRatingsOfCustomerByMailId(customerMail);
    }

    // 4. Getting the Rating List(DTO) for the Customer mailId
    @GetMapping("/rating/DTO/{customerMail}")
    public List<RatingDto> getRatingsListOfCustomerByMailId(@Valid @PathVariable String customerMail) throws RatingException {
        return ratingService.getRatingDtoOfCustomerByMailId(customerMail);
    }


    // 5.Updating the Reviews
    @PutMapping("/rating/update")
    public Rating updateRatingById(@Valid @RequestBody RatingDto rating) throws RatingException {
        return this.ratingService.updateRating(rating);
    }
   // 6.Deleting the Reviews By Id
    @DeleteMapping("/rating/delete/{id}")
    public void deleteRatingById(@Valid @PathVariable Integer id) throws RatingException
    {
        this.ratingService.deleteRating(id);

    }

    // 7. Filtering Rating Between given Value
    @GetMapping("rating/{min}/{max}")
    public List<Rating> findAllRatingBetweenRange(@Valid @PathVariable Integer min,@Valid@PathVariable Integer max) throws RatingException {
        return this.ratingService.getAllRatingsBetweenRange(min,max);
    }

    // 8. Getting the Rating List(DTO) for the Car Model Name
    @GetMapping("/rating/DTOCarName/{carModel}")
    public List<RatingDto> getRatingsListOfCustomerByCarName(@Valid @PathVariable String carModel) throws RatingException {
        return ratingService.getRatingDtoOfCustomerByCarName(carModel);
    }
//
//    // 3. Getting the Rating list for particular customer mail
//    @GetMapping("rating/{id}")
//    public Rating getRatingsById(@PathVariable Integer id) throws RatingException {
//        return ratingService.getRatingsById(id);
//    }

    // 8. Listing all the  RatingDto to customer
//    @GetMapping("rating/dto")
//    public List<RatingDto> findAllRatingDto() throws RatingException {
//        return this.ratingService.getAllRatingDto();
//    }
    @GetMapping("admin/car/rating/{ratingStars}")
    public List<Car> getCarDetailsByRatingStars(@PathVariable Integer ratingStars) throws RatingException{
        return this.ratingService.getCarDetailsByRatingStars(ratingStars);
    }


}
