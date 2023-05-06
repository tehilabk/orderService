package com.example.consumerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
//@Builder
@Entity
public class LineItemModel {
    @Id
    private Long  productId;
    private Long orderId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private Integer quantity;


    public LineItemModel() {
    }

    public LineItemModel(Long externalProductId, String name, String description, Long price, Integer quantity) {
        this.productId = externalProductId;
        this.productName = name;
        this.productDescription = description;
        this.productPrice = price;
        this.quantity = quantity;
    }

}
