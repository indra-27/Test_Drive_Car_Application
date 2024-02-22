package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;
    @Override
    public Booking createNewBooking(BookingDto newBooking) {
        List<Car> carDetails = carRepository.findBymodelName(newBooking.getCarModelName());
        Integer carId = carDetails.getFirst().getCarId();
        this.bookingRepository.save(new Booking());
        return null;
    }
}
