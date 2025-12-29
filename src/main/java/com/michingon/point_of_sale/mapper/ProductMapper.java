package com.michingon.point_of_sale.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.michingon.point_of_sale.dto.ProductRequest;
import com.michingon.point_of_sale.dto.ProductResponse;
import com.michingon.point_of_sale.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)

    Product toEntity(ProductRequest request);

    @Mapping(target = "availabilityStatus", expression = "java(mapStatus(product.getStock()))")
    @Mapping(target = "formattedDate", source = "registrationDate", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "details", expression = "java(product.getSize() + \" - \" + product.getColor())")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);

    default String mapStatus(int stock) {
        return stock > 0 ? "Available" : "Not Available";
    }
}
