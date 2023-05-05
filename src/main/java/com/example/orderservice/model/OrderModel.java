package com.example.orderservice.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@Data // adds getters and setters
public class OrderModel {
    @NotNull
    private int id;
    //    @NotNull
    private Date date;
    //    @NotNull
    private String email;
    //    @NotNull
    private String firstName;
    //    @NotNull
    private String lastName;
    //    @NotNull
    private List<LineItemModel> lineItems;

    public OrderModel() {}

    public OrderModel( Date date, String email, String firstName, String lastName, List<LineItemModel> lineItems) {
        this.date = date;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lineItems = lineItems;
        this.lineItems.forEach(li -> li.setOrder(this));
    }
}
