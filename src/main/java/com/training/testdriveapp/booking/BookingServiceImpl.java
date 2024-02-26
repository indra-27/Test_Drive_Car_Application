package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public BookingOutputDto createNewBooking(BookingInputDto newBooking) throws BookingException {
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
        Booking foundBooking = this.bookingRepository.findByTestDriveCarAndDateAndSlotNo(carDetails.getFirst(),newBooking.getDate(), newBooking.getSlotNo());

        if(foundBooking!=null && foundBooking.getStatus().equals(false))
            throw new BookingException("Slot already booked");
        
        Booking newBookingProcess = new Booking();
        newBookingProcess.setTestDriveCar(carDetails.getFirst());
        newBookingProcess.setCustomer(foundCustomer);
        newBookingProcess.setDate(newBooking.getDate());
        newBookingProcess.setSlotNo(newBooking.getSlotNo());
        newBookingProcess.setBookingDate(newBooking.getBookingDate());
        newBookingProcess.setStatus(false);

        this.slotAvailability.put(newBooking.getSlotNo(), true);
        this.bookingRepository.save(newBookingProcess);
        return new BookingOutputDto(newBookingProcess.getBookId(), newBookingProcess.getCustomer().getCustomerEmail(), newBookingProcess.getTestDriveCar().getModelName(), newBookingProcess.getSlotNo(),newBookingProcess.getDate(),newBookingProcess.getBookingDate(),newBookingProcess.getTestDriveCar().getStaff().getStaffName(),newBookingProcess.getTestDriveCar().getStaff().getPhoneNumber());
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

    @Override
    public List<BookingOutputDto> getAllUserBookingByEmail(String mailId) throws BookingException{
        Optional<Customer> foundCustomer = this.customerRepository.findByCustomerEmail(mailId);
        if(foundCustomer.isEmpty())
            throw new BookingException("No such Customer exists");
        List<Booking> bookings = this.bookingRepository.findByCustomer(foundCustomer.get());
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

    @Override
    public List<BookingOutputDto> getAllUserBookingBySlotNo(Integer slotNo) throws BookingException{
        List<Booking> bookings = this.bookingRepository.findBySlotNoOrderBySlotNo(slotNo);
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

}
