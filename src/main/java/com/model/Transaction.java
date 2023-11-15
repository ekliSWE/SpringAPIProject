package com.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;
import java.util.LongSummaryStatistics;
@Data
public class Transaction {
    private Long transactionId;
    private Long customerId;
    private double purchaseAmount;
    private Timestamp transactionDate;

    public Transaction(Long transactionId, Long customerId, double purchaseAmount, Timestamp transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.transactionDate = transactionDate;
    }
}
