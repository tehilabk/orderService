package com.consumerservice.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
//@Builder
@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long storeId;
    private Date date;
    private Long userId;

    public OrderModel() {
    }

    public OrderModel(Long storeId, Date date, Long userId) {
        this.storeId = storeId;
        this.date = date;
        this.userId = userId;
    }
}
