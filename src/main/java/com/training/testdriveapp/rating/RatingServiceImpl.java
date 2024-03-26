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

/************************************************************************************
 *          @author          Reenu Sivadarshini M
 *          Description      It is a service class that provides the services for adding a new ratings,
updating ratings ,deleting ratings and viewing all the review of the customer based on the emailId.
 *         Version             1.0
 *         Created Date    27-FEB-2024
 ************************************************************************************/
@Service
@Transactional
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;
    //1. Create Rating
    @Override
    public Rating createNewRating(RatingDto newRating) throws RatingException {
        if(newRating==null)
            throw new RatingException("Rating Cannot Be NULL");

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
    // 2. Display all the ratings
    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.findAll();
    }
    // 3. Updating Rating
    @Override
    public Rating updateRating(RatingDto updateRating) throws RatingException{
        if(updateRating==null)
            throw new RatingException("Rating Cannot Be NULL");
        if(updateRating.getRatingStars()==null || updateRating.getComments()==null)
        {
            throw new RatingException("Rating Cannot be null");
        }
        List<Car> carList=carRepository.findBymodelName(updateRating.getCarModelName());
        // List<Customer> customerList1= customerRepository.findByCustomerEmail(newRating.getCustomerEmailId()).stream().toList();
        Optional<Customer> customerDetails = customerRepository.findByCustomerEmail(updateRating.getCustomerEmailId());
        Customer foundCustomer;
        if (customerDetails.isEmpty()) {
            throw new RatingException("No such Customer Exists");
        }
        foundCustomer = customerDetails.get();
        if (carList.getFirst().getCarId() == null) {
            throw new RatingException("No such car exists");
        }
        Rating rating = new Rating();
        rating.setRatingId(updateRating.getRatingId());
        rating.setRatingStars(updateRating.getRatingStars());
        rating.setComments(updateRating.getComments());
        rating.setCar(carList.getFirst());
        rating.setCustomer(foundCustomer);
        return this.ratingRepository.save(rating);
    }

    //4. Updating Rating with new Rating
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

    // 5. Getting Ratings of the Particular Customer by mailId (Returns List of Rating )
    @Override
    public List<Rating> getRatingsOfCustomerByMailId(String customerMailId) throws RatingException {

        if(ratingRepository.ratingsMap.containsKey(customerMailId)) {
            return ratingRepository.ratingsMap.get(customerMailId);
        }
        else {
            throw new RatingException("The Mail Id does not exist");

        }
    }

    // 6. Getting Ratings of the Particular Customer by mailId (Returns List of RatingDto )
    @Override
    public List<RatingDto> getRatingDtoOfCustomerByMailId(String customerMailId) throws RatingException {
        Optional<Customer> customer = this.customerRepository.findByCustomerEmail(customerMailId);
        Customer foundCustomer = null;
        if (customer.isPresent())
            foundCustomer = customer.get();
        if (foundCustomer == null)
            throw new RatingException("The Mail Id does not exist");
        List<Rating> rating = this.ratingRepository.findByCustomer(foundCustomer);
        List<RatingDto> ratingDto=new ArrayList<>();
        for(int i=0;i<rating.size();i++)
        {
            RatingDto dummy = new RatingDto(rating.get(i).getCustomer().getCustomerEmail(),rating.get(i).getRatingId(),rating.get(i).getRatingStars(),rating.get(i).getComments(),rating.get(i).getCar().getModelName());
            ratingDto.add(i,dummy);
        }
        return ratingDto;
    }

    @Override
    public List<RatingDto> getRatingDtoOfCustomerByCarName(String carModel) throws RatingException {
        List<Car> car = this.carRepository.findBymodelName(carModel);
        Car foundCar=null;
        Optional<Car> cars = car.stream().findFirst();

        if(cars.isPresent())
           foundCar=cars.get();
        if (foundCar == null)
            throw new RatingException("The Car Model does not exist");
        List<Rating> ratings= this.ratingRepository.findByCar(foundCar);
        List<RatingDto> ratingDtos=new ArrayList<>();
        for(int i=0;i<ratings.size();i++)
        {
            RatingDto dummy = new RatingDto(ratings.get(i).getCustomer().getCustomerEmail(),ratings.get(i).getRatingId(),ratings.get(i).getRatingStars(),ratings.get(i).getComments(),ratings.get(i).getCar().getModelName());
            ratingDtos.add(i,dummy);
        }
        return ratingDtos;
    }

//    @Override
//    public Rating getRatingsById(Integer id) {
//        return this.ratingRepository.findByRatingId(id);
//    }


    // 7. Getting the rating within the given limit.
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

//      @Override
//        public List<RatingDto> getAllRatingDto() {
//
//             return this.ratingRepository.findCustomerEmailAndCarModelNameAndRatingIdAndRatingStarsAndCommentsAndCar_ModelName();
//        }

}
