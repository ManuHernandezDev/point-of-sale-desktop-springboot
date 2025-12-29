package com.michingon.point_of_sale.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String availabilityStatus;
    private String formattedDate;
    private String details;
}
