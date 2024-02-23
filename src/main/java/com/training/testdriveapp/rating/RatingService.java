package com.training.testdriveapp.rating;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface RatingService {
    Rating createNewRating(Rating rating) throws RatingException;

    List<Rating> getAllRatingsBetweenRange(Integer min, Integer max)throws RatingException;

    Rating getRatingById(Integer id)throws RatingException;

    List<Rating> getAllRating();

    Rating updateRating(Rating rating)throws RatingException;

    void deleteRating(Integer id)throws RatingException;

}
