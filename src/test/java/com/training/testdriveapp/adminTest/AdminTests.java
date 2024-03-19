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
class AdminTests {

    @Autowired
    private AdminServices adminServices;

    // 1) ADD CAR:

    @Test
    void addNewCarTest() throws AdminException {
        Car car = null;
        try{
            car = this.adminServices.addNewCar(new CarDto(79,"Ford","Fiat","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0,"image","Hellooo"));
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
        Assertions.assertThrows(AdminException.class,()->adminServices.addNewCar(new CarDto(null,null,null,null,null,null,null,null,null,null,null,null,null)));
    }

    @Test
    void nullCarTestExceptionMessageInAddNewCar(){
        try{
            adminServices.addNewCar(new CarDto(null,null,null,null,null,null,null,null,null,null,null,null,null));
        }catch (AdminException e){
            Assertions.assertEquals("Car details cannot be null",e.getMessage());
        }
    }

    @Test
    void carExistExceptionMessageInAddNewCar() throws AdminException {
        Car car = new Car();
        try
        {
            car = adminServices.addNewCar(new CarDto(79,"Ford","Fiaitsss","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0,"image","Helloo"));
        }catch (AdminException e) {
            throw new RuntimeException(e);
        }
        try
        {
            adminServices.addNewCar(new CarDto(79,"Ford","Fiaitsss","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0,"image","Helloo"));
        }
        catch (AdminException e) {
            Assertions.assertEquals("Car already exist",e.getMessage());
        }
        adminServices.deleteCarById(car.getCarId());
    }

    // 2) GET CAR DETAILS:

    @Test
    void getCarDetailsByModelNameTest(){
        Car car = null;
        try{
            car = this.adminServices.getCarDetailsByModelName("Virtus");
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
            car = (List<Car>) adminServices.getCarDetailsByModelName("Test");
        } catch (AdminException e) {
            Assertions.assertEquals("No such model exists",e.getMessage());
        }
    }

    // 3) UPDATE CAR DETAILS

    @Test
    void nullUpdateCarTestInUpdateCarDetails(){
        Assertions.assertThrows(AdminException.class,()->adminServices.updateCarDetails(null));
    }

    @Test
    void nullUpdateCarTestExceptionMessageInUpdateCarDetails(){
        try{
            adminServices.updateCarDetails(null);
        }catch (AdminException e){
            Assertions.assertEquals("Null car details cannot be updated",e.getMessage());
        }
    }

    @Test
    void nullIdTestMessageInUpdateCarDetails(){
        Car car = null;
        try{
            car = this.adminServices.updateCarDetails(new CarDto(null,"Ford","Fias","Red",500000.0,"5600cc","Automatic","Petrol",5,3555.0,2500.0,"image","Hellooo"));
        }catch (AdminException e){
            Assertions.assertEquals("Car ID is mandatory to update the car",e.getMessage());
        }
    }

//    @Test
//    void carIdTestMessageInUpdateCarDetails(){
//        try{
//
//        }
//    }

    // 4) DELETE CAR

    @Test
    void deleteCarTest() throws AdminException {
        try{
            Car car = this.adminServices.addNewCar(new CarDto(1000808,"Ford","letotesspss","EDFR",520350.0,"15602cc","Auto","Petrol",5,152.0,782.0,"image","Hellooo"));
            this.adminServices.deleteCarById(car.getCarId());
        }catch (AdminException e){
            Assertions.fail(e.getMessage());
        }
    }

//    @Test
//    void nullTestIndeleteCarTest(){
//        Assertions.assertThrows(AdminException.class,()->adminServices.deleteCarById(null));
//    }

    @Test
    void carNotFoundTestMessageIndeleteCarTest(){
        try{
//            Car car = new Car();
//            car = this.adminServices.addNewCar(new CarDto(69,"Ford","Trizaq","EDFR",520350.0,"15602cc","Auto","Petrol",5,152.0,782.0,"image"));
            this.adminServices.deleteCarById(1008);
        }catch (AdminException e){
            Assertions.assertEquals("Car not found",e.getMessage());
        }
    }
}
