package com.michingon.point_of_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michingon.point_of_sale.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}