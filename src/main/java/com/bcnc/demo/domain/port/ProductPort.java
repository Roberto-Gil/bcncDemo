package com.bcnc.demo.domain.port;

import com.bcnc.demo.domain.model.Product;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface ProductPort {

    Optional<Product> findByBrandIdAndProductIdAndDateWithMaxPriority(Integer brandId, Integer productId, OffsetDateTime productDate);
}
