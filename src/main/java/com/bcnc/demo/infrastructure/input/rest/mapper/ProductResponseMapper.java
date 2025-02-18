package com.bcnc.demo.infrastructure.input.rest.mapper;

import com.bcnc.demo.domain.model.Currency;
import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.infrastructure.input.model.ProductResponseDTO;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {


  @Mapping(target = "currency", source = "currency", qualifiedByName = "currencyToString")
  ProductResponseDTO toProductResponseDto(Product product);

  @Named("currencyToString")
  default String currencyToString(Currency currency) {
    return Optional.ofNullable(currency).map(Currency::name).orElse(null);
  }

}
