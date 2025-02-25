package com.bcnc.demo.infrastructure.output.persistence.mapper;

import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.infrastructure.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    default Optional<Product> toOptionalProduct(Optional<ProductEntity> productEntity) {
        return Optional.ofNullable(toProduct(productEntity.orElse(null)));
    }

    Product toProduct(ProductEntity productEntity);

}
