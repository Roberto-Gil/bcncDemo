package com.bcnc.demo.domain.port;

import com.bcnc.demo.domain.model.Product;
import java.time.OffsetDateTime;
import java.util.List;

public interface ProductPort {

  List<Product> findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId,
      OffsetDateTime productDate);
}
