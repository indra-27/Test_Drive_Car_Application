package com.training.testdriveapp.rating;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public interface RatingService {
    Rating createNewRating(RatingDto newRating) throws RatingException;

    //RatingDto createNewRating(Rating rating) throws RatingException;

    List<Rating> getAllRatingsBetweenRange(Integer min, Integer max)throws RatingException;


    List<Rating> getAllRating();

    Rating updateRating(Rating rating)throws RatingException;

    void deleteRating(Integer id)throws RatingException;

    Map<String,  List<Rating>> displayRatingByCustomerId(String customerId);

    List<Rating> getRatingsOfCustomerByMailId(String customerId);

    List<RatingDto> getRatingDtoOfCustomerByMailId(String customerMail);
}
