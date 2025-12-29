package com.michingon.point_of_sale.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.michingon.point_of_sale.dto.ProductResponse;
import com.michingon.point_of_sale.mapper.ProductMapper;
import com.michingon.point_of_sale.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts() {
        var products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return productMapper.toResponseList(products);
    }

}
