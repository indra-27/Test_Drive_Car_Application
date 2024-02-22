package com.training.testdriveapp.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByRatingStarsBetween(Integer min, Integer max);

    //Rating find(Integer custId);
}
