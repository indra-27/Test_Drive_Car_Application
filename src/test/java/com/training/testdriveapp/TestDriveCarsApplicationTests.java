package com.training.testdriveapp;

import com.training.testdriveapp.admin.AdminException;
import com.training.testdriveapp.admin.AdminServices;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.booking.Booking;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.rating.Rating;
import com.training.testdriveapp.staff.Staff;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestDriveCarsApplicationTests {

	@Test
	void contextLoads() {
	}
//	private String DoorNo;
//	private String addressLane;
//	private String City;
//	private String State;
//	private Integer pincode;
//private String staffName;
//	@OneToOne
//	private Address address;
//	private String phoneNumber;
//	private String staffEmail;
	@Autowired
	private AdminServices adminServices;

//	private Integer customerId;
//	private String CustomerName;
//	@OneToOne
//	private Address address;
//	private String mobileNumber;
//	private String customerEmail;
//
//	@OneToMany
//	private List<Rating> customerRatingList = new ArrayList<>();
//	@ManyToMany
//	private List<Car> testDriveCars = new ArrayList<>();
//
//	@OneToMany
//	private List<Booking> customerBookings = new ArrayList<>();
//	@Test
//	void addNewCarTest(){
//		Car car;
//		try{
//			car = this.adminServices.addNewCar(new Car("Ford","Mustang","Red",500000.0,"9500cc","Manual",5,2500.0,8500.0,new Rating(1,5,"Good", new Customer(1,"Dhanya",new Address(1,"T3","2nd Street","Chennai","Tamil Nadu",600080),"9500523578","dhanya@gmail.com",new Rating(1,5,"Good"),new Car("Ford","Mustang","Red",500000.0,"9500cc","Manual",5,2500.0,8500.0))), new Staff(1,"Ram",new Address(4,"TS","2nd Street","Chennai","Tamil Nadu",600080))));
//		}
//	}

}
