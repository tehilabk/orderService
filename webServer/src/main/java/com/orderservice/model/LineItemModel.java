package com.orderservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

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

    protected boolean isValid() {
        if (this.getProductName().isEmpty() || this.getProductDescription().isEmpty() ||
                this.getProductPrice() < 0 || this.getQuantity() < 1) {
            return false;
        }
        return true;
    }
}