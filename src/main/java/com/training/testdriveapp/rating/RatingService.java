package com.training.testdriveapp.rating;

import com.training.testdriveapp.customer.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface RatingService {
    Rating createNewRating(Rating rating);

    List<Rating> getAllRatingsBetweenRange(Integer min, Integer max);

    Rating getRatingById(Integer id);

    List<Rating> getAllRating();

    Rating updateRatingById(Rating rating);

    void deleteRating(Integer id);

}
