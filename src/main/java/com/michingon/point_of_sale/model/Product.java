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
    @Column(unique = true, nullable = false, length = 13)
    private String barcode;
    @Column(nullable = false)
    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String description;
    private String color;
    private Integer stock;
    private LocalDateTime registrationDate;
    private String observations;

    private Integer categoryCode; // El "CC" (01, 02...)
    private Double size; // El "TT" (24, 25...)
    private Integer sequence; // El "PPPPP" (50, 51...)

}
