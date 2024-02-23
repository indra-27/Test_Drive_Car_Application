package com.training.testdriveapp.customer;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerRepository;
import com.training.testdriveapp.customer.CustomerServices;
import com.training.testdriveapp.entity.Address;
import com.training.testdriveapp.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private  AddressRepository addressRepository;
    @Override
    public Customer addNewCustomer(Customer newCustomer) throws CustomerException {
//        if(newCustomer==null)
//            throw new CustomerException("New customer cannot be null");
        // this.customerRepository.save(newCustomer);
        Optional<Customer> customerOpt=this.customerRepository.findByCustomerEmail(newCustomer.getCustomerEmail());

        if(customerOpt.isPresent())
            throw new CustomerException("Customer already exists");
        return this.customerRepository.save(newCustomer);
    }

    @Override
    public List<Customer> getAllCustomers() {
//        Customer customer=this.customerRepository.findById()

        return this.customerRepository.findAll();
    }



    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
//        if(customer==null)
//            throw new CustomerException("Customer cannot be null");
        Optional<Customer> customerOpt=this.customerRepository.findById(customer.getCustomerId());

        if(!(customerOpt.isPresent()))
            throw new CustomerException("Customer not exists with id "+customer.getCustomerId());


        return this.customerRepository.save(customer);
    }

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

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> customer=this.customerRepository.findById(customerId);
        if(customer!=null){
            Optional<Address> address=this.addressRepository.findById(customer.get().getAddress().getId());
            if(address!=null){
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
        return null;
    }

    @Override
    public List<Rating> getCustomerRating(Integer id) {
        List<Rating> ratings= this.customerRepository.findById(id).get().getRatings();
        return ratings;
    }
}

