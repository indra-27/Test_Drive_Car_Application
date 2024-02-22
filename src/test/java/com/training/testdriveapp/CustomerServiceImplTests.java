package com.training.testdriveapp;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerException;
import com.training.testdriveapp.customer.CustomerRepository;
import com.training.testdriveapp.customer.CustomerServicesImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceImplTests {

    @Autowired
    private CustomerServicesImpl customerServices;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeAll
    public static void initialiseTestData(){

    }
    @BeforeEach
    public void initialiseEachTestData(){

    }

    @Test
    @DisplayName(value = "adding a new Customer ")
    public void addNewCustomer() throws CustomerException {
        Customer customer=new Customer(20,"Karthi","9988776655","karthi@gmail.com","String@1234556");
        customer=this.customerServices.addNewCustomer(customer);
        Assertions.assertNotNull(customer);
        //Assertions.assertNotNull(customer.getAddress());
        this.customerRepository.save(customer);

    }

    @Test
    @DisplayName(value = "Updating the customer")
    public void updateCustomer() throws CustomerException {


        Customer updateCustomer = new Customer(202, "Keerthi", "9955332211", "subha@gmail.com", "Subhae46@@");
        updateCustomer = this.customerServices.updateCustomer(updateCustomer);

        this.customerRepository.delete(updateCustomer);


    }

    @Test
    @DisplayName(value = "Deleting a customer")
    public void deleteCustomer() throws CustomerException {

        Integer customerId=202;
       this.customerRepository.deleteById(customerId);
    // Boolean deleteCustomer= this.customerServices.deleteCustomer(customerId);







    }


}
