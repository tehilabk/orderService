package com.consumerservice.model.output;

import com.consumerservice.model.input.OrderInputModel;
import lombok.Data;

import java.util.Date;

@Data
public class OrderCreatedModel {
    private final String eventName;
    private Date orderEntityCreationDate;
    private OrderInputModel orderData;

    public OrderCreatedModel(Date orderEntityCreationDate, OrderInputModel orderData) {
        this.eventName = "orders/created";
        this.orderEntityCreationDate = orderEntityCreationDate;
        this.orderData = orderData;
    }
}
