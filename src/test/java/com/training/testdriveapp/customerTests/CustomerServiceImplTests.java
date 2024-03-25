package com.training.testdriveapp.customerTests;

import com.training.testdriveapp.customer.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
 class CustomerServiceImplTests {

    @Autowired
    private CustomerServicesImpl customerServices;

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    @DisplayName(value = "adding a new Customer ")
    void addNewCustomer() throws CustomerException {
        try{
            CustomerDto customer=new CustomerDto(20,"Karthi","Chennai","9988776655","karthi@gmail.com","String@1234556");

            Assertions.assertNotNull(customer);

        }
        catch (Exception e){
            e.getMessage();
        }


    }

    @Test
    @DisplayName(value = "testing null for adding a new Customer ")
     void testAddCustomerForNull(){

        Assertions.assertThrows(CustomerException.class,()->customerServices.addNewCustomer(null));
    }

    @Test
    @DisplayName(value = "testing Exception for adding a new Customer ")
    void testAddNewCustomerForException(){

        try {
            customerServices.addNewCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("New customer cannot be null", e.getMessage());
        }


    }

    @Test
    @DisplayName(value = " adding a  Customer should throws exception if already exists")
    void addCustomerShouldThrowAnExceptionIfAlreadyExists() {
        try {
            this.customerServices.addNewCustomer(new CustomerDto(10,"Abi","Salem","8877665544","Str@gmail.com","str12345"));
        } catch (CustomerException e) {

            e.printStackTrace();
        }
        try {
            this.customerServices.addNewCustomer(new CustomerDto(10,"Abi","Salem","8877665544","Str@gmail.com","str12345"));
        } catch (CustomerException e) {
            Assertions.assertEquals("Customer already exists", e.getMessage());
        }

    }

    @Test
    @DisplayName(value = "Updating the customer")
     void updateCustomer() throws CustomerException {
        try{
    Assertions.assertNotNull(customerServices.updateCustomer(new Customer(202, "Keerthi", "Madurai","9955332211", "karthi1@gmail.com", "Subhae46@@")));
        }
    catch (CustomerException e){
    e.printStackTrace();
    }


    }

    @Test
    @DisplayName(value = "testing null for updating a  Customer ")
    void nullTestForUpdateCustomer(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.updateCustomer(null));
    }
    @Test
    @DisplayName(value = "testing exception for updating a Customer ")
     void NullTestupdateCustomerForException(){

        try {
            customerServices.updateCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Customer cannot be null", e.getMessage());
        }


    }

    @Test
    @DisplayName(value = " updating a  Customer should throws exception if already not exists")
     void customerAlreadyNotExistsForUpdateCustomer(){
        try {
            customerServices.updateCustomer(new Customer(200,"Kavin","Salem","0088775443","Sv@gmail.com","ght12"));

        }
        catch (CustomerException e){
//            System.out.println("Customer not exists with id "+e.getMessage());
            Assertions.assertEquals("Customer not exists with id ",e.getMessage());
        }
    }




    @Test
    @DisplayName(value = "Deleting a customer")
     void deleteCustomer() throws CustomerException {
        this.customerRepository.deleteById(202);


    }

    @Test
    @DisplayName(value = " testing null for deleting a customer")
    void nullCustomerTestInDeleteProductById()
    {
        Assertions.assertThrows(CustomerException.class,()->customerServices.deleteCustomer(null));
    }
    @Test
    @DisplayName(value = " testing exception for deleting a customer")
    void nullCustomerTestExceptionMessageInDeleteCustomerByID()
    {
        try {
            this.customerServices.deleteCustomer(null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Id cannot be null",e.getMessage());
        }
    }
    @Test

    void getCustomerByIdTestIfCustomerIdIsNull(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.getCustomerById(null));
    }

    @Test
    void getCustomerByIdTestIfCustomerIdIsNullException(){
        try{
            this.customerServices.getCustomerById(202);
        }
        catch (CustomerException e){
            Assertions.assertEquals("Customer doesn't exists",e.getMessage());
        }
    }


    @Test
     void getCustomerByIdTestIfCustomerNotExists(){
        try{
            this.customerServices.getCustomerById(202);
        }
        catch (CustomerException e){
            Assertions.assertEquals("Customer doesn't exists",e.getMessage());
        }
    }

    @Test
    void getAllCustomersTestIfNoCustomerExists(){
        try{
            this.customerServices.getAllCustomers();
        }
        catch (CustomerException e){
            Assertions.assertEquals("No customer exists",e.getMessage());
        }
    }

    @Test
     void forgotPassword() throws CustomerException {
        try {
            this.customerServices.forgotPassword("kavi@gmail.com", "Kavi12@@");
        }
        catch (CustomerException e){
            e.printStackTrace();
        }

    }

    @Test
     void nullTestForForgotPassword(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.forgotPassword(null,null));
    }
    @Test

    void NullTestForgotPasswordForException(){

        try {
            customerServices.forgotPassword(null,null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Email cannot be null", e.getMessage());
        }


    }


    @Test
     void customerAlreadyNotExistsForForgotPassword(){
        try {
            customerServices.forgotPassword("kavin@gmail.com","Kavin12@@");

        }
        catch (CustomerException e){
            System.out.println("Customer not exists with id "+e.getMessage());
        }
    }








}
