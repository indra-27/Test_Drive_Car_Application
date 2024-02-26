package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.CustomerRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> customerList= customerRepository.findByCustomerEmail(newRating.getCustomerEmailId());
        Customer cust=customerList.get();
        Rating rating = new Rating();
        rating.setRatingId(newRating.getRatingId());
        rating.setRatingStars(newRating.getRatingStars());
        rating.setComments(newRating.getComments());
        rating.setCar(carList.getFirst());
        rating.setCustomer(cust);
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
    public Rating getRatingById(Integer id) throws RatingException
    {
        Optional<Rating> accountOpt=this.ratingRepository.findById(id);
        if(accountOpt.isEmpty())
            throw new RatingException("Rating not exists");
        return this.ratingRepository.findById(id).get();
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




}
