package com.example.orderservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@Data
public class OrderModel {
    @NotNull
    private Long storeId;
    @NotNull
    private Date date;
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotEmpty @NotNull
    private List<LineItemModel> lineItems;

    public OrderModel( Date date, String email, String firstName, String lastName,List<LineItemModel> lineItems) {
        this.date = date;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lineItems = lineItems;

    }


}
