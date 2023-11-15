package com.Service;

import com.dao.CustomerRepository;
import com.dao.TransactionRepository;
import com.entity.CustomerEntity;
import com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardPointsService {

    @Autowired
    private TransactionRepository transactionRepository;
    //Link the service with the repository
    private CustomerRepository customerRepository;


    public RewardPointsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public RewardPointsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // Get customer by ID
    /*
    public Customer findById(long id){
        //findById() is one of the named query methods provided by Spring Data.
        if (customerEntity != null) {
            // Convert CustomerEntity to Customer
            Customer customer = new Customer();
            customer.setId(customerEntity.getId());
            customer.setName(customerEntity.getName());
            return customer;
        } else {
            return null; // or throw an exception or handle the case when the customer is not found
        }
        return customerRepository.findById(id).orElse(null);
    }*/


    // Get customer by ID
    public Customer findById(long id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);

        if (optionalCustomerEntity.isPresent()) {
            CustomerEntity customerEntity = optionalCustomerEntity.get();

            // Map CustomerEntity to Customer
            Customer customer = new Customer();
            customer.setId(customerEntity.getId());
            customer.setName(customerEntity.getName());

            return customer;
        } else {
            return null; // or throw an exception or handle the case when the customer is not found
        }
    }

    //Save Customer
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setName(customer.getName());

        CustomerEntity savedEntity = customerRepository.save(customerEntity);

        // Map the saved entity back to a Customer and return it
        return new Customer(savedEntity.getId(), savedEntity.getName());
    }

    //Delete Customer
    public void deleteCustomerById(long id){
        customerRepository.deleteById(id);
    }

    //calculate reward points
    public int calculateRewardPoints(double purchaseAmount) {
        int points = 0;

        if (purchaseAmount > 100) {
            points += Math.round((purchaseAmount - 100) * 2);
        }

        if (purchaseAmount > 50) {
            points += Math.round((purchaseAmount - 50) * 1);
        }
        return points;
    }
}
