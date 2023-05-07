package com.consumerservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.io.Serializable;

@Data
//@Builder
@Entity
@IdClass(LineItemModel.class)
public class LineItemModel implements Serializable {
    @Id
    private Long productId;
    @Id
    private Long orderId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private Integer quantity;


    public LineItemModel() {
    }

    public LineItemModel(Long orderId, Long externalProductId, String name, String description, Long price, Integer quantity) {
        this.orderId = orderId;
        this.productId = externalProductId;
        this.productName = name;
        this.productDescription = description;
        this.productPrice = price;
        this.quantity = quantity;
    }

}
