//Purpose: map with the database column

package com.entity;


import jakarta.persistence.*;
import lombok.Data;
//
@Entity
@Table(name = "customer")
@Data

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//generate the ID, user doesn't need to provide the id
    @Column(name = "id")
    private Long id;//primary key

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Constructors
    public CustomerEntity() {
        // JPA requires no argument constuctor
    }

    public CustomerEntity(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
    }
    //Lomk's @Data annotation will generate getter and setter automatically
}
