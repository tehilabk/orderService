package com.orderservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@Data
public class LineItemModel {

    @NotBlank
    @NotNull
    private Long productId;
    @NotBlank
    @NotNull
    private String productName;
    @NotBlank
    @NotNull
    private String productDescription;
    @NotNull
    @Min(value = 0)
    private Long productPrice;
    @NotNull
    @Min(value = 1)
    private int quantity;


    public LineItemModel(Long externalProductId, String name, String description, Long price, int quantity) {
        this.productId = externalProductId;
        this.productName = name;
        this.productDescription = description;
        this.productPrice = price;
        this.quantity = quantity;
    }


}