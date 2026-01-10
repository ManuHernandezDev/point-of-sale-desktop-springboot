package com.michingon.point_of_sale.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Name is necesary")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Price is necesary")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    private String description;

    @NotNull(message = "Size is necesary")
    private Double size;

    @NotBlank(message = "Color is necesary")
    private String color;

    @NotNull(message = "Stock is necesary")
    @PositiveOrZero(message = "Stock can't be negative")
    private Integer stock;

    private String observations;
}
