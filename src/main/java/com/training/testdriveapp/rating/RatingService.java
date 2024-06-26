package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public interface RatingService {
    Rating createNewRating(RatingDto newRating) throws RatingException;

    //RatingDto createNewRating(Rating rating) throws RatingException;

    List<Rating> getAllRatingsBetweenRange(Integer min, Integer max)throws RatingException;


    List<Rating> getAllRating();

    Rating updateRating(RatingDto rating)throws RatingException;

    void deleteRating(Integer id)throws RatingException;

    List<Rating> getRatingsOfCustomerByMailId(String customerId) throws RatingException;

    List<RatingDto> getRatingDtoOfCustomerByMailId(String customerMail) throws RatingException;

    List<RatingDto> getRatingDtoOfCustomerByCarName(String carModel) throws RatingException;

//  Rating getRatingsById(Integer id);



    // Get Rating based on CarModelNAme
    List<Car> getCarDetailsByRatingStars(Integer ratingStars) throws RatingException;
}
