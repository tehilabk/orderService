package com.example.consumerservice.model.input;

import com.example.consumerservice.model.entity.LineItemModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderInputModel {
    private Long storeId;
    private Date date;
    private String email;
    private String firstName;
    private String lastName;
    private List<LineItemModel> lineItems;

    public OrderInputModel() {
    }

    public OrderInputModel(Long storeId, Date date, String email, String firstName, String lastName, List<LineItemModel> lineItems) {
        this.storeId = storeId;
        this.date = date;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lineItems = lineItems;

    }
}
