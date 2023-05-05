package com.example.orderservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@Data // adds getters and setters
public class OrderModel {
    private int id;
    @NotNull
    private Date date;
    @Email
    private String email;
    @NotBlank(message = "firstName is mandatory" )
    private String firstName;
    @NotBlank
    private String lastName;
    //    @NotNull
//    private List<LineItemModel> lineItems;

    public OrderModel() {}

    public OrderModel( Date date, String email, String firstName, String lastName) {
        this.date = date;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.lineItems = lineItems;
//        this.lineItems.forEach(li -> li.setOrder(this));
    }

    public OrderModel(OrderModel otherOrder){
        this.date = otherOrder.getDate();
    }
}
