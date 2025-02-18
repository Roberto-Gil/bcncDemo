package com.bcnc.demo.application;

import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.domain.port.ProductPort;
import com.bcnc.demo.application.exception.ProductNotFoundException;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class BrandService {

  private final ProductPort productPort;

  public Product getBrandProductByDate(Integer bradId, Integer productId,
      OffsetDateTime productDate) {
    var products = productPort.findByBrandIdAndProductIdAndDate(bradId, productId, productDate);
    return Optional.ofNullable(products).stream().flatMap(Collection::stream)
        .max(Comparator.comparing(Product::getPriority))
        .orElseThrow(ProductNotFoundException::new);
  }
}
