package com.example.orderservice.controller;

import com.example.orderservice.model.OrderModel;
import com.example.orderservice.service.OrderEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class OrderServiceController {
    //Todo add validations

    @Autowired
    OrderEventProducer orderEventProducer;


    @PostMapping("/{storeId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Long storeId,@Valid @RequestBody OrderModel order) throws JsonProcessingException {
        order.setStoreId(storeId);
        orderEventProducer.sendOrderEvent(order);
        return ResponseEntity.ok(order);

    }



}
