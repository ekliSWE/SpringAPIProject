//Provide the basic CRUD operation and handle the http requests

package com.Controller;

import com.Service.RewardPointsService;
import com.exception.CustomerNotFoundException;
import com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//to indicate that this controller will be created as bean
//and manage by the IOC container
//handles HTTP requests and returns RESTful responses. It is equal to@controller + @ResponseBody




public class RewardsPointsController {

    private final RewardPointsService rewardPointsService;
    //link the controller and the service

    //Constructor based dependency injection
    @Autowired
    public RewardsPointsController(RewardPointsService rewardPointsService){
        this.rewardPointsService = rewardPointsService;
    }

    //Get Customer BY ID:
    @RequestMapping(value = "/reward-points", method = RequestMethod.GET)
    //more flexible, specifies the base path for handling request, which means all methods in this controller will handle requests
    //starts with "/reward-points", you need to provide the url and the method
    public ResponseEntity<Customer> getCustomerByID (@PathVariable("id") long id){
        Customer customer = rewardPointsService.findById(id);
        if(customer == null) {
            throw new CustomerNotFoundException("Customer doesn't exist");
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }



    //Create Customer //@RequestBody: json -> java object @ResponseBody: java object -> json
    @PostMapping("/Customer") //Create
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer){
        Customer savedCustomer = rewardPointsService.saveCustomer(customer);
         new ResponseEntity<>(new Customer(savedCustomer.getId(), savedCustomer.getName()), HttpStatus.CREATED);

    }

    //Delete Customer
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deletCustomer(@PathVariable("id") long id){
        Customer customer = rewardPointsService.findById(id);
        if(customer == null) {
            throw new CustomerNotFoundException("Customer doesn't exist");
        }
        rewardPointsService.deleteCustomerById(id);
        return new ResponseEntity<>(new Customer(customer.getId(), customer.getName()), HttpStatus.OK);
    }



    //Get the cacualted point
    @GetMapping("/calculate") // Read You will provide the URL, which you can get
    //the points by the purchase amount money
    public int calculateRewardPoints(@RequestParam double purchaseAmount){
        return rewardPointsService.calculateRewardPoints(purchaseAmount);
    }

}
