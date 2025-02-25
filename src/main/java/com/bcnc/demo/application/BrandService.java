package com.bcnc.demo.application;

import com.bcnc.demo.application.exception.ProductNotFoundException;
import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.domain.port.ProductPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class BrandService {

    private final ProductPort productPort;

    public Product getBrandProductByDate(Integer bradId, Integer productId, OffsetDateTime productDate) {
        Optional<Product> product = productPort.findByBrandIdAndProductIdAndDateWithMaxPriority(bradId, productId, productDate);
        return product.orElseThrow(ProductNotFoundException::new);
    }
}
