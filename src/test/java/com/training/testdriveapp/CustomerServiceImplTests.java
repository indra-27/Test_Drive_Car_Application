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
    @DisplayName(value = "new Customer adding")
    public void addNewCustomer() throws CustomerException {
        Customer customer=new Customer(20,"Karthi","9988776655","karthi@gmail.com","String@1234556");
        customer=this.customerServices.addNewCustomer(customer);
        Assertions.assertNotNull(customer);
        //Assertions.assertNotNull(customer.getAddress());
        this.customerRepository.delete(customer);

    }



}
