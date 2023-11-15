//Used to transfer data between different layers of an application
package com.model;


import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;


    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}