package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByRatingStarsBetween(Integer min, Integer max);

    //List<Rating> findByRatingStars(String rating);

    //Rating find(Integer custId);
}
