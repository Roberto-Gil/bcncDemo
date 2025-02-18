package com.bcnc.demo.infrastructure.output.persistence.mapper;

import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.infrastructure.output.persistence.entity.ProductEntity;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

  Product toProduct(ProductEntity productEntity);

  List<Product> toProductList(List<ProductEntity> productEntity);

}
