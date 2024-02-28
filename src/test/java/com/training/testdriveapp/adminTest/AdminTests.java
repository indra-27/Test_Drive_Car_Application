package com.training.testdriveapp.adminTest;

import com.training.testdriveapp.admin.AdminException;
import com.training.testdriveapp.admin.AdminServices;
import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarDto;
import com.training.testdriveapp.booking.BookIdDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminTests {

    @Autowired
    private AdminServices adminServices;

    // 1) ADD CAR:

    @Test
    void addNewCarTest() throws AdminException {
        Car car = null;
        try{
            car = this.adminServices.addNewCar(new CarDto("Ford","Fias","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0));
            Assertions.assertNotNull(car);
        }catch (AdminException e){
            Assertions.fail(e.getMessage());
        }
        finally {
            this.adminServices.deleteCarById(car.getCarId());
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

    @Test
    void carExistExceptionMessageInAddNewCar(){
        try
        {
            adminServices.addNewCar(new CarDto("Ford","Mus","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0));
        }catch (AdminException e) {
            throw new RuntimeException(e);
        }
        try
        {
            adminServices.addNewCar(new CarDto("Ford","Mus","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0));
        }
        catch (AdminException e) {
            Assertions.assertEquals("Car already exist",e.getMessage());
        }
    }

    // 2) GET CAR DETAILS:

    @Test
    void getCarDetailsByModelNameTest(){
        List<Car> car = null;
        try{
            car = this.adminServices.getCarDetailsByModelName("Mustang");
            Assertions.assertNotNull(car);
        }catch (AdminException e)
        {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullModelNameTestInGetCarDetailsByModelName(){
        Assertions.assertThrows(AdminException.class,()->adminServices.getCarDetailsByModelName(null));
    }

    @Test
    void nullModelNameTestExceptionMessageInGetCarDetailsByModelName(){
        try
        {
            adminServices.getCarDetailsByModelName(null);
        }catch (AdminException e)
        {
            Assertions.assertEquals("Model name cannot be null",e.getMessage());
        }
    }

    @Test
    void modelExistExceptionInGetCarDetailsByModelName(){
        List<Car> car = null;
        try
        {
            car = adminServices.getCarDetailsByModelName("Test");
        } catch (AdminException e) {
            Assertions.assertEquals("No such model exists",e.getMessage());
        }
    }

    // 3) UPDATE CAR DETAILS

    @Test
    void nullIdTestMessageInUpdateCarDetailsTest(){
        Car car = null;
        try{
            car = this.adminServices.updateCarDetails(new Car("Ford","Fia","Red",5000.0,"5600cc","Automatic",5,500.0,3555.0,null));
        }catch (AdminException e){
            Assertions.assertEquals("Car ID is mandatory to update the car",e.getMessage());
        }
    }

}
