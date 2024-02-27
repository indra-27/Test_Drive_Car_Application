package com.training.testdriveapp.adminTest;

import com.training.testdriveapp.admin.AdminException;
import com.training.testdriveapp.admin.AdminServices;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTests {

    @Autowired
    private AdminServices adminServices;

    @Test
    void addNewCarTest() throws AdminException {
        Car car = null;
        try{
            car = this.adminServices.addNewCar(new CarDto("Ford","Mustang","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0));
            Assertions.assertNotNull(car);
        }catch (AdminException e){
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullCarTestInAddNewCar(){
        Assertions.assertThrows(AdminException.class,()->adminServices.addNewCar(null));
    }

    @Test
    void nullCarTestExceptionMessageInAddNewCar(){
        try{
            adminServices.addNewCar(null);
        }catch (AdminException e){
            Assertions.assertEquals("Car details cannot be null",e.getMessage());
        }
    }

//    @Test
//    void carExistExceptionMessageInAddNewCar(){
//        try
//        {
//            adminServices.addNewCar(new CarDto("Ford","Mustang","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0));
//        } catch (AdminException e) {
//            Assertions.assertEquals("Car already exist",e.getMessage());
//        }
//    }

}
