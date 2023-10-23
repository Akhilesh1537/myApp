package com.myApp.products.mapper;

import com.myApp.products.dto.ProductDTO;
import com.myApp.products.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productId", ignore = true)
    Product productDTOToProduct(ProductDTO productDto);
}
