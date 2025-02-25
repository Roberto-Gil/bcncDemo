package com.bcnc.demo.infrastructure.adapter;

import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.domain.port.ProductPort;
import com.bcnc.demo.infrastructure.output.persistence.entity.ProductEntity;
import com.bcnc.demo.infrastructure.output.persistence.mapper.ProductEntityMapper;
import com.bcnc.demo.infrastructure.output.persistence.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Component
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Optional<Product> findByBrandIdAndProductIdAndDateWithMaxPriority(Integer brandId, Integer productId,
                                                                             OffsetDateTime productDate) {
        Optional<ProductEntity> product = productRepository.findByBrandIdAndProductIdAndDate(brandId, productId,
                productDate, Limit.of(1));
        return productEntityMapper.toOptionalProduct(product);
    }
}
