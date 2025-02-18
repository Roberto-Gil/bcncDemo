package com.bcnc.demo.infrastructure.adapter;

import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.domain.port.ProductPort;
import com.bcnc.demo.infrastructure.output.persistence.mapper.ProductEntityMapper;
import com.bcnc.demo.infrastructure.output.persistence.repository.ProductRepository;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class ProductAdapter implements ProductPort {

  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper;

  @Override
  public List<Product> findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId,
      OffsetDateTime productDate) {
    var products = productRepository.findByBrandIdAndProductIdAndDate(brandId, productId,
        productDate);
    return productEntityMapper.toProductList(products);
  }
}
