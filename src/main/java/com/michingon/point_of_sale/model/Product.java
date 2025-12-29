package com.michingon.point_of_sale.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String description;
    @Column(length = 10)
    private String size;
    private String color;
    private Integer stock;
    private LocalDateTime registrationDate;
    private String observations;
}
