package com.example.orderservice.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data // adds getters and setters

public class LineItemModel {

    @NotNull
    private Long id;
    @NotNull
    private OrderModel order;
    @NotNull
    private String externalProductId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Long price;
    @NotNull
    private Integer quantity;
    @NotNull
    public LineItemModel() {
    }

    public LineItemModel(String externalProductId, String name, String description, Long price, Integer quantity) {
        this.externalProductId = externalProductId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}