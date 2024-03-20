package com.training.testdriveapp.customer;


import com.training.testdriveapp.booking.Booking;

import com.training.testdriveapp.booking.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/************************************************************************************
 *          @author          Keerthana
 *          Description      It is a service class that provides the services for adding a new customer,
updating customer ,deleting customer and viewing all the customers
 *         Version             1.0
 *         Created Date    19-FEB-2024
 ************************************************************************************/

@Service
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private BookingRepository bookingRepository;



    /************************************************************************************
     * Method: 			-addNewCustomer
     *Description: 			-To add a new customer
     * @param newCustomer       -Customer to be added

     * @returns Customer                  - customer, if created otherwise throws CustomerException
     * @throws CustomerException - It is raised due to if customer already exists or null
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Customer addNewCustomer(CustomerDto newCustomer) throws CustomerException {
        if(newCustomer==null)
            throw new CustomerException("New customer cannot be null");

       Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(newCustomer.getCustomerEmail());

        if(customerOpt.isPresent())
            throw new CustomerException("Customer already exists");

        Customer customer=new Customer();
        customer.setAddress(newCustomer.getAddress());
        customer.setCustomerEmail(newCustomer.getCustomerEmail());
        customer.setCustomerName(newCustomer.getCustomerName());
        customer.setPassword(newCustomer.getPassword());
        customer.setMobileNumber(newCustomer.getMobileNumber());


        return  this.customerRepository.save(customer);
    }






    /************************************************************************************
     * Method: 			-updateCustomer
     *Description: 			-To update a customer
     * @param customer       -Customer to be updated

     * @returns Customer                  - customer, if created otherwise throws CustomerException
     * @throws CustomerException - It is raised due to if customer not exists
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
        if(customer==null)
            throw new CustomerException("Customer cannot be null");
        Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(customer.getCustomerEmail());


        if(customerOpt.isEmpty()) {
            throw new CustomerException("Customer not exists with id "+customer.getCustomerId());
        }
            customerOpt.get().setPassword(customer.getPassword());
       customerOpt.get().setCustomerEmail(customerOpt.get().getCustomerEmail());
customerOpt.get().setCustomerName(customer.getCustomerName());
            customerOpt.get().setMobileNumber(customer.getMobileNumber());
            customerOpt.get().setAddress(customer.getAddress());
            customerOpt.get().setCustomerId(customerOpt.get().getCustomerId());
            Customer customer1=customerOpt.get();

            return this.customerRepository.save(customer1);







    }

    /************************************************************************************
     * Method: 			-deleteCustomer
     *Description: 			-To delete a customer
     * @param email      -Customer to be deleted


     * @throws CustomerException - It is raised due to if customer not exists or null
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/

    @Override
    public void deleteCustomer(String email) throws CustomerException {
        if(email==null)
            throw new CustomerException("Id cannot be null");
        Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(email);
        if(customerOpt.isEmpty()){
            throw new CustomerException("Customer does not exists with  id: "+email);


        }

        Customer customer=customerOpt.get();

        customerRepository.delete(customer);


    }

    /************************************************************************************
     * Method: 			-login
     *Description: 			-To login customer
     * @param loginDto       -LoginDto for getting customer emailId and password

     * @returns Customer                  - customer, if logged  in successfully, otherwise throws CustomerException
     * @throws CustomerException - It is raised due to if customer is not already exists and if the password does not match with emailId
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/

    @Override
    public Customer login(LoginDto loginDto) throws CustomerException{
        Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(loginDto.getUserName());
        if(customerOpt.isEmpty()){
            throw  new CustomerException("Customer does not exists for "+loginDto.getUserName());
        }
        Customer foundCustomer=customerOpt.get();
        if(! foundCustomer.getPassword().equals(loginDto.getPassword()))
            throw new CustomerException("Password does not match");

        return foundCustomer;
    }

    /************************************************************************************
     * Method: 			-getCustomerById
     *Description: 			-To get a  customer by id
     * @param  customerId       -Customer Id to get details

     * @returns Customer                  - customer, if present otherwise throws CustomerException
     * @throws CustomerException - It is raised due to if customer is  null
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/

    @Override
    public Customer getCustomerById(Integer customerId) throws CustomerException{
        if(customerId==null){
            throw new CustomerException("Customer doesn't exists with given id"+customerId);
        }
        Optional<Customer> customer=this.customerRepository.findById(customerId);
        if(!customer.isPresent()) {
            throw new CustomerException("Customer doesn't exists");
        }
        else{

                Customer customer1=new Customer();
                customer1.setCustomerId(customer.get().getCustomerId());
                customer1.setCustomerName(customer.get().getCustomerName());
        customer1.setAddress(customer.get().getAddress());
                customer1.setCustomerEmail(customer.get().getCustomerEmail());
                customer1.setMobileNumber(customer.get().getMobileNumber());
                customer1.setPassword(customer.get().getPassword());
            List<Booking> bookings=this.bookingRepository.findByCustomer(customer1);


                customer1.setCustomerBookings(bookings);
                return customer1;


            }





    }





    @Override
    public Customer updateCustomerMobile(String email, String mobileNumber) throws CustomerException {
        Optional<Customer> customer=this.customerRepository.findByCustomerEmail(email);
        if(customer.isEmpty()) {
            throw new CustomerException("Customer not exists with given email id: " + email);
        }
            customer.get().setMobileNumber(mobileNumber);
            customer.get().setAddress(customer.get().getAddress());

            Customer foundCustomer=customer.get();

            return this.customerRepository.save(foundCustomer);


    }

    @Override
    public Customer updateCustomerAddress(Integer id, String address) throws CustomerException {
        Optional<Customer> customer=this.customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new CustomerException("Customer not exists");
        }
        Customer foundCustomer=customer.get();
        foundCustomer.setAddress(address);
        foundCustomer.setCustomerName(foundCustomer.getCustomerName());
        foundCustomer.setCustomerId(id);
        foundCustomer.setCustomerEmail(foundCustomer.getCustomerEmail());
        foundCustomer.setPassword(foundCustomer.getPassword());
        foundCustomer.setMobileNumber(foundCustomer.getMobileNumber());
        return this.customerRepository.save(foundCustomer);


    }

    @Override
    public Customer updateCustomerPassword(String email, String password) throws CustomerException {
        Optional<Customer> customer=this.customerRepository.findByCustomerEmail(email);
        if(!customer.isPresent()){
            throw new CustomerException("Customer email doesn't exists");
        }
        Customer foundCustomer=customer.get();
        foundCustomer.setPassword(password);
        return this.customerRepository.save(foundCustomer);
    }
    /************************************************************************************
     * Method: 			-getAllCustomers
     *Description: 			-To get all  customers


     * @returns List               - list of customers, if present otherwise throws CustomerException
     * @throws CustomerException - It is raised due to if customer list is null
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/

    @Override

    public List<Customer> getAllCustomers() throws CustomerException{
        if(this.customerRepository.findAll().isEmpty()){
            throw new CustomerException("No customer exists");
        }



        return this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerException {
        if(email==null){
            throw new CustomerException("Customer doesn't exists with given id"+email);
        }
        Optional<Customer> customer=this.customerRepository.findByCustomerEmail(email);
        if(!customer.isPresent()) {
            throw new CustomerException("Customer doesn't exists");
        }

        return  customer.get();
    }

    @Override
    public List<Booking> getCustomerBookingsByEmail(String email) {
       Optional<Customer> customer1=this.customerRepository.findByCustomerEmail(email);
       Customer customer=customer1.get();
        return this.bookingRepository.findByCustomer(customer);





    }

    @Override
    public Customer forgotPassword(String email, String password) throws CustomerException {
        if(email==null)
            throw new CustomerException("Email cannot be null");

        Optional<Customer> customer1=this.customerRepository.findByCustomerEmail(email);
        if(customer1.isEmpty())
            throw  new CustomerException("Customer not exists with email"+email);
        Customer customer=customer1.get();
        customer1.get().setCustomerEmail(email);
        customer1.get().setPassword(password);
        customer1.get().setCustomerName(customer.getCustomerName());
        customer1.get().setAddress(customer.getAddress());
        customer1.get().setMobileNumber(customer.getMobileNumber());
        customer1.get().setCustomerId(customer.getCustomerId());
        Customer customer11=customer1.get();
        return  this.customerRepository.save(customer11);



    }


}

