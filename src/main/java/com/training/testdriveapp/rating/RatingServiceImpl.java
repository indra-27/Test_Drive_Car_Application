package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.booking.BookingException;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.CustomerRepository;

import java.util.*;

@Service
@Transactional
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;
    @Override
    public Rating createNewRating(RatingDto newRating) throws RatingException {

     if(newRating.getRatingStars()==null || newRating.getComments()==null)
     {
         throw new RatingException("Rating Cannot be null");
     }
        List<Car> carList=carRepository.findBymodelName(newRating.getCarModelName());
       // List<Customer> customerList1= customerRepository.findByCustomerEmail(newRating.getCustomerEmailId()).stream().toList();
        Optional<Customer> customerDetails = customerRepository.findByCustomerEmail(newRating.getCustomerEmailId());
        Customer foundCustomer;
        if (customerDetails.isEmpty()) {
            throw new RatingException("No such Customer Exists");
        }
        foundCustomer = customerDetails.get();
        if (carList.getFirst().getCarId() == null) {
            throw new RatingException("No such car exists");
        }
        Rating rating = new Rating();
        rating.setRatingId(newRating.getRatingId());
        rating.setRatingStars(newRating.getRatingStars());
        rating.setComments(newRating.getComments());
        rating.setCar(carList.getFirst());
        rating.setCustomer(foundCustomer);
        // Adding into the Map of Rating
        if (ratingRepository.ratingsMap.containsKey(rating.getCustomer().getCustomerEmail())) {
            List<Rating> list = ratingRepository.ratingsMap.get(rating.getCustomer().getCustomerEmail());
            list.add(rating);
        }
        else {
            List<Rating> newList = new ArrayList<>();
            newList.add(rating);
            ratingRepository.ratingsMap.put(rating.getCustomer().getCustomerEmail(), newList);
        }

        // Adding Into Map of RatingDto
        if (ratingRepository.ratingDtoMap.containsKey(newRating.getCustomerEmailId())) {
            List<RatingDto> list = ratingRepository.ratingDtoMap.get(newRating.getCustomerEmailId());
            list.add(newRating);
        }
        else {
            List<RatingDto> newList = new ArrayList<>();
            newList.add(newRating);
            ratingRepository.ratingDtoMap.put(rating.getCustomer().getCustomerEmail(), newList);
        }
        //this.ratingRepository.ratingDtoMap.put(newRating.getCustomerEmailId(),newRating);

        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsBetweenRange(Integer min, Integer max)throws RatingException
    {
        if(min<1 || min >5)
        {
            throw new RatingException("Minimum rating should be in the range of 1-5 ");
        }
        if(max>5 ||max<1)
        {
            throw new RatingException("Maximum rating should be in the range of 1-5 ");
        }
        if(min>max)
        {
            throw new RatingException("Minimum value cannot be greater than maximum value");
        }
        return this.ratingRepository.findByRatingStarsBetween(min,max);
    }



    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.findAll();
    }

    @Override
    public Rating updateRating(Rating rating) throws RatingException{
        if(rating.getRatingStars()==null || rating.getComments()==null)
        {
            throw new RatingException("Rating Cannot be null");
        }
        return this.ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Integer id)throws RatingException {

        Optional<Rating> ratingOpt=this.ratingRepository.findById(id);

            if(!ratingOpt.isPresent())
            {
                throw new RatingException("Rating Id Does not exist");
            }
                else{
                Rating rating = ratingOpt.get();
                ratingRepository.delete(rating);
            }
    }

    @Override
    public Map<String, List<Rating>> displayRatingByCustomerId(String customerId) {
        if (ratingRepository.ratingsMap.containsKey(customerId) )
        {
            return ratingRepository.ratingsMap;
        }
        return null;
    }

    @Override
    public List<Rating> getRatingsOfCustomerByMailId(String customerMailId) {
        if(ratingRepository.ratingsMap.containsKey(customerMailId)) {
            return ratingRepository.ratingsMap.get(customerMailId);
        }

        return null;
    }

    @Override
    public List<RatingDto> getRatingDtoOfCustomerByMailId(String customerMailId) {
        if(ratingRepository.ratingDtoMap.containsKey(customerMailId)) {
            return ratingRepository.ratingDtoMap.get(customerMailId);
        }
        return null;
    }


}
