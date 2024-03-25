package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByRatingStarsBetween(Integer min, Integer max);

    Map<String,List<Rating>> ratingsMap = new HashMap<>();
    Map<String,List<RatingDto>> ratingDtoMap = new HashMap<>();

    Rating findByRatingId(Integer id);

    List<Rating> findByCustomer(Customer customer);
    List<Rating> findByCar(Car car);


}
