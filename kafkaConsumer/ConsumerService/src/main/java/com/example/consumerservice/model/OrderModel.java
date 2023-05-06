package com.example.consumerservice.model;

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

//    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public OrderModel(){}
    public OrderModel(Long storeId, Date date, String email, String firstName, String lastName) {
        this.storeId = storeId;
        this.date = date;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
