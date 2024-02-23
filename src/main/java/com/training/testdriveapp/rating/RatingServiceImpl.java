package com.training.testdriveapp.rating;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Rating createNewRating(Rating rating) {

        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsBetweenRange(Integer min, Integer max)
    {
        return this.ratingRepository.findByRatingStarsBetween(min,max);
    }

    @Override
    public Rating getRatingById(Integer id)
    {
        return this.ratingRepository.findById(id).get();
    }

    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.findAll();
    }

    @Override
    public Rating updateRatingById(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Integer id) {
        Optional<Rating> ratingOpt=this.ratingRepository.findById(id);

            if(ratingOpt.isPresent()) {
                Rating rating = ratingOpt.get();
                ratingRepository.delete(rating);
            }
    }






}
