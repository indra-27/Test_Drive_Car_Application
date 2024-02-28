package com.training.testdriveapp.customerTests;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerException;
import com.training.testdriveapp.customer.CustomerRepository;
import com.training.testdriveapp.customer.CustomerServicesImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class CustomerServiceImplTests {

    @Autowired
    private CustomerServicesImpl customerServices;

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    @DisplayName(value = "adding a new Customer ")
    public void addNewCustomer() throws CustomerException {
        try{
            Customer customer=new Customer(20,"Karthi","9988776655","karthi@gmail.com","String@1234556");
            customer=this.customerServices.addNewCustomer(customer);
            Assertions.assertNotNull(customer);

        }
        catch (Exception e){
            Assertions.fail(e.getMessage());
        }


    }

    @Test
    public void testAddCustomerForNull(){

        Assertions.assertThrows(CustomerException.class,()->customerServices.addNewCustomer(null));
    }

    @Test
    public void testAddNewCustomerForException(){

        try {
            customerServices.addNewCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("New customer cannot be null", e.getMessage());
        }


    }

    @Test
    void addCustomerShouldThrowAnExceptionIfAlreadyExists() {
        try {
            this.customerServices.addNewCustomer(new Customer(10,"Abi","8877665544","Str@gmail.com","str12345"));
        } catch (CustomerException e) {

            e.printStackTrace();
        }
        try {
            this.customerServices.addNewCustomer(new Customer(10,"Abi","8877665544","Str@gmail.com","str12345"));
        } catch (CustomerException e) {
            Assertions.assertEquals("Customer already exists", e.getMessage());
        }

    }

    @Test
    @DisplayName(value = "Updating the customer")
    public void updateCustomer() throws CustomerException {

        Assertions.assertNotNull(new Customer(202, "Keerthi", "9955332211", "karthi1@gmail.com", "Subhae46@@"));


    }

    @Test
    public void nullTestForUpdateCustomer(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.updateCustomer(null));
    }
    @Test

    public void NullTestupdateCustomerForException(){

        try {
            customerServices.updateCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Customer cannot be null", e.getMessage());
        }


    }

    @Test
    public void customerAlreadyNotExistsForUpdateCustomer(){
        try {
            customerServices.updateCustomer(new Customer(200,"Kavin","0088775443","Sv@gmail.com","ght12"));

        }
        catch (CustomerException e){
            System.out.println("Customer not exists with id "+e.getMessage());
        }
    }




    @Test
    @DisplayName(value = "Deleting a customer")
    public void deleteCustomer() throws CustomerException {

        this.customerRepository.deleteById(202);


    }

    @Test
    void nullCustomerTestInDeleteProductById()
    {
        Assertions.assertThrows(CustomerException.class,()->customerServices.deleteCustomer(null));
    }
    @Test
    void nullCustomerTestExceptionMessageInDeleteCustomerByID()
    {
        try {
            this.customerServices.deleteCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Id cannot be null",e.getMessage());
        }
    }
    @Test
    public void getCustomerByIdTestIfCustomerIdIsNull(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.getCustomerById(null));
    }

    @Test
    public void getCustomerByIdTestIfCustomerIdIsNullException(){
        try{
            this.customerServices.getCustomerById(202);
        }
        catch (CustomerException e){
            Assertions.assertEquals("Customer doesn't exists",e.getMessage());
        }
    }


    @Test
    public void getCustomerByIdTestIfCustomerNotExists(){
        try{
            this.customerServices.getCustomerById(202);
        }
        catch (CustomerException e){
            Assertions.assertEquals("Customer doesn't exists",e.getMessage());
        }
    }

    @Test
    public void getAllCustomersTestIfNoCustomerExists(){
        try{
            this.customerServices.getAllCustomers();
        }
        catch (CustomerException e){
            Assertions.assertEquals("No customer exists",e.getMessage());
        }
    }







}
