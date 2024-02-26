package com.training.testdriveapp.customer;


import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private  AddressRepository addressRepository;

    @Autowired
    private CustomerDtoRepository customerDtoRepository;

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
    public Customer addNewCustomer(Customer newCustomer) throws CustomerException {
        if(newCustomer==null)
            throw new CustomerException("New customer cannot be null");

       Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(newCustomer.getCustomerEmail());

        if(customerOpt.isPresent())
            throw new CustomerException("Customer already exists");

        return this.customerRepository.save(newCustomer);
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
    public List<Customer> getAllCustomers() {


        return this.customerRepository.findAll();
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
//        if(customer==null)
//            throw new CustomerException("Customer cannot be null");
        Optional<Customer> customerOpt=this.customerRepository.findById(customer.getCustomerId());

        if(!(customerOpt.isPresent()))
            throw new CustomerException("Customer not exists with id "+customer.getCustomerId());


        return this.customerRepository.save(customer);
    }

    /************************************************************************************
     * Method: 			-deleteCustomer
     *Description: 			-To delete a customer
     * @param id       -Customer to be deleted


     * @throws CustomerException - It is raised due to if customer not exists or null
    server side validation
     *Created By                                - Keerthana
     *Created Date                            - 19-FEB-2024

     ************************************************************************************/

    @Override
    public void deleteCustomer(Integer id) throws CustomerException {
        Optional<Customer> customerOpt=this.customerRepository.findById(id);
        if(customerOpt.isPresent()){
//            this.customerRepository.deleteById(id);
//            Optional<Address> addressOpt=this.addressRepository.findById(id);
//            this.addressRepository.deleteById(id);
            Customer customer=customerOpt.get();
            Address address=customer.getAddress();


            addressRepository.delete(address);
            customerRepository.delete(customer);
        }

        else {
            // Handle the case when the customer with the given ID is not found
            throw new CustomerException("Customer not found with id: " + id);
        }


        //return addressOpt.get();
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
            throw  new CustomerException("Account does not exists for "+loginDto.getPassword());
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
        Optional<Customer> customer=this.customerRepository.findById(customerId);
        if(customer.isPresent()){
            Optional<Address> address=this.addressRepository.findById(customer.get().getAddress().getId());
            if(address.isPresent()){
                Customer customer1=new Customer();
                customer1.setCustomerId(customer.get().getCustomerId());
                customer1.setCustomerName(customer.get().getCustomerName());
                customer1.setAddress(address.get());
                customer1.setCustomerEmail(customer.get().getCustomerEmail());
                customer1.setMobileNumber(customer.get().getMobileNumber());
                customer1.setPassword(customer.get().getPassword());
                return customer1;


            }


        }
        else{
            throw new CustomerException("Customer doesn't exists");
        }
        return null;
    }



    @Override
    public List<Rating> getCustomerRating(Integer id)throws CustomerException {
        List<Rating> ratings= this.customerRepository.findById(id).get().getRatings();
        return ratings;
    }

    @Override
    public Customer updateCustomerMobile(Integer id, String mobileNumber) {
        Optional<Customer> customer=this.customerRepository.findById(id);
        if(customer.isPresent()) {

            customer.get().setMobileNumber(mobileNumber);
            customer.get().setAddress(customer.get().getAddress());

            Customer foundCustomer=customer.get();

            return this.customerRepository.save(foundCustomer);
        }
       return null;

    }

    @Override
    public Customer updateCustomerAddress(Integer id, Address address) throws CustomerException {
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
        if(customer.isPresent()){
            throw new CustomerException("Customer email doesn't exists");
        }
        Customer foundCustomer=customer.get();
        foundCustomer.setPassword(password);
        return this.customerRepository.save(foundCustomer);
    }


}

