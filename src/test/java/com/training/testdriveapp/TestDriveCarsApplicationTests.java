package com.training.testdriveapp;

import com.training.testdriveapp.staff.Staff;
import com.training.testdriveapp.staff.StaffException;
import com.training.testdriveapp.staff.StaffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TestDriveCarsApplicationTests {

	@Autowired
	private StaffService staffService;
	@Test
	public void addNewStaff(){

		try {
			Assertions.assertNotNull(this.staffService.addNewStaff(new Staff("Name",null,"8765987654","abc@gmail.com")));
		} catch (StaffException e) {
			Assertions.fail(e.getMessage());
		}

	}
	@Test
	public void getProductByIdTest(){

	}
	@Test
	public void updateProductTest(){

	}
	@Test
	public void deleteProductByIdTest(){

	}
	@Test
	public void getAllProductsTest(){

	}



}
