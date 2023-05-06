package com.example.orderservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@Data // adds getters and setters
public class LineItemModel {

    @NotBlank
    private Long  productId;
    @NotBlank
    private String productName;
    @NotBlank
    private String productDescription;
    @NotNull @Min(0)
    private Long productPrice;
    @NotNull @Min(1)
    private Integer quantity;

    public LineItemModel() {
    }

    public LineItemModel(Long  externalProductId, String name, String description, Long price, Integer quantity) {
        this.productId = externalProductId;
        this.productName = name;
        this.productDescription = description;
        this.productPrice = price;
        this.quantity = quantity;
    }


}