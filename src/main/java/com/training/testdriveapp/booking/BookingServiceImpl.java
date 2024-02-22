package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    private Map<Integer,Boolean> slotAvailability = new HashMap<>();
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Booking createNewBooking(BookingDto newBooking) throws BookingException {
        if (newBooking == null) {
            throw new BookingException("Booking Input can't be null");
        }
        List<Car> carDetails = carRepository.findBymodelName(newBooking.getCarModelName());
        Optional<Customer> customerDetails = customerRepository.findByCustomerEmail(newBooking.getCustomerEmailId());
        Customer foundCustomer = null;
        if (customerDetails.isEmpty()) {
            throw new BookingException("No such Customer Exists");
        }
        foundCustomer = customerDetails.get();

        if (carDetails.getFirst().getCarId() == null) {
            throw new BookingException("No such car exists");
        }
        Booking newBookingProcess = new Booking();
        newBookingProcess.setTestDriveCar(carDetails.getFirst());
        newBookingProcess.setCustomer(foundCustomer);
        newBookingProcess.setDate(newBooking.getDate());
        newBookingProcess.setSlotNo(newBooking.getSlotNo());
        if (Boolean.TRUE.equals(this.slotAvailability.get(newBooking.getSlotNo())))
            throw new BookingException("Slot already booked");
        this.slotAvailability.put(newBooking.getSlotNo(), true);
        return this.bookingRepository.save(newBookingProcess);
    }
    @Override
    public void deleteBooking(BookIdDto bookIdDto) throws BookingException {
        if(bookIdDto.getBookId()==null)
            throw new BookingException("Id can't be null");
        Booking foundBooking = this.bookingRepository.getReferenceById(bookIdDto.getBookId());
        if(foundBooking==null)
            throw new BookingException("No such Book Id exists");
        this.bookingRepository.deleteById(bookIdDto.getBookId());
    }



}
