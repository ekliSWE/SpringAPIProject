package com.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "transcation id")
    private Long transactionId;
    @Column(name = "customer id")
    private Long customerId;
    @Column(name = "amount")
    private double purchaseAmount;
    @Column(name = "transaction date")
    private Timestamp transactionDate;



    public TransactionEntity() {
        // Default constructor required by JPA
        //Because JPA needs to create instances of entities and
        //no argument constructor is needed
    }

    public TransactionEntity(Long transactionId, Long customerId, double purchaseAmount, Timestamp transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.transactionDate = transactionDate;
    }
}
