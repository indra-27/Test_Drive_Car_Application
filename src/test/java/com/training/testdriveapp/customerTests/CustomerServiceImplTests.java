package com.training.testdriveapp.customerTests;

import com.training.testdriveapp.customer.*;
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
            CustomerDto customer=new CustomerDto(20,"Karthi","Chennai","9988776655","karthi@gmail.com","String@1234556");

            Assertions.assertNotNull(customer);

        }
        catch (Exception e){
            e.getMessage();
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
    public void updateCustomer() throws CustomerException {
        try{
    Assertions.assertNotNull(customerServices.updateCustomer(new Customer(202, "Keerthi", "Madurai","9955332211", "karthi1@gmail.com", "Subhae46@@")));
        }
    catch (CustomerException e){
    e.printStackTrace();
    }


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
            customerServices.updateCustomer(new Customer(200,"Kavin","Salem","0088775443","Sv@gmail.com","ght12"));

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

    @Test
    public void forgotPassword() throws CustomerException {
        try {
            this.customerServices.forgotPassword("kavi@gmail.com", "Kavi12@@");
        }
        catch (CustomerException e){
            e.printStackTrace();
        }

    }

    @Test
    public void nullTestForForgotPassword(){
        Assertions.assertThrows(CustomerException.class,()->customerServices.forgotPassword(null,null));
    }
    @Test

    public void NullTestForgotPasswordForException(){

        try {
            customerServices.forgotPassword(null,null);
        } catch (CustomerException e) {
            Assertions.assertEquals("Email cannot be null", e.getMessage());
        }


    }


    @Test
    public void customerAlreadyNotExistsForForgotPassword(){
        try {
            customerServices.forgotPassword("kavin@gmail.com","Kavin12@@");

        }
        catch (CustomerException e){
            System.out.println("Customer not exists with id "+e.getMessage());
        }
    }








}
