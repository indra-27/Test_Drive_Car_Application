package com.training.testdriveapp.booking;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService{
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

        if (carDetails.isEmpty()) {
            throw new BookingException("No such car exists");
        }


       if(newBooking.getSlotNo()<1 && newBooking.getSlotNo()>8)
            throw new BookingException("Invalid Slot Number");
        if(newBooking.getBookingDate().isAfter(newBooking.getDate()))
            throw new BookingException("The Booking date has to be less than Test drive date");

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
        if(mailId == null)
            throw new BookingException("Mail Id can't be null");
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
        if(slotNo==null)
            throw new BookingException("Slot no can't be null");
        if(slotNo<1 || slotNo>8)
            throw new BookingException("Invalid Slot Number");
        List<Booking> bookings = this.bookingRepository.findBySlotNoOrderBySlotNo(slotNo);
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

    @Override
    public List<BookingOutputDto> getAllUserBookingByDate(LocalDate date) throws BookingException {
        if(date == null)
            throw new BookingException("Date can't be null");
        List<Booking> bookings = this.bookingRepository.findByDate(date);
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

    @Override
    public List<BookingOutputDto> getAllUserBookingByCarModelName(String carModelName) throws BookingException{
        if(carModelName==null)
            throw new BookingException("Car model name can't be null");
        List<Car> foundCar = this.carRepository.findBymodelName(carModelName);
        if(foundCar.isEmpty())
            throw new BookingException("No such Car exists");
        List<Booking> bookings = this.bookingRepository.findByTestDriveCar(foundCar.getFirst());
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

    @Override
    public List<BookingOutputDto> getAllBookings() {
        List<Booking> bookings = this.bookingRepository.findAll();
        List<BookingOutputDto> bookingDtos = new ArrayList<>();
        for(int i=0;i<bookings.size();i++)
        {
            bookingDtos.add(new BookingOutputDto(bookings.get(i).getBookId(),bookings.get(i).getCustomer().getCustomerEmail(),bookings.get(i).getTestDriveCar().getModelName(),bookings.get(i).getSlotNo(),bookings.get(i).getDate(),bookings.get(i).getBookingDate(),bookings.get(i).getTestDriveCar().getStaff().getStaffName(),bookings.get(i).getTestDriveCar().getStaff().getPhoneNumber()));
        }
        return bookingDtos;
    }

//    @Override
//    public List<BookingOutputDto> getAllUserBookingByCarId(String carModelName) throws BookingException {
//        return null;
//    }

}
