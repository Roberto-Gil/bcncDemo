package com.bcnc.demo.infrastructure.input.rest.controller;

import com.bcnc.demo.application.BrandService;
import com.bcnc.demo.domain.model.Product;
import com.bcnc.demo.infrastructure.input.model.ProductResponseDTO;
import com.bcnc.demo.infrastructure.input.rest.BrandProductsApi;
import com.bcnc.demo.infrastructure.input.rest.mapper.ProductResponseMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@AllArgsConstructor
public class BrandProductsController implements BrandProductsApi {

    private final BrandService brandService;
    private final ProductResponseMapper productResponseMapper;

    @Override
    public ProductResponseDTO getBrandProduct(Integer bradId, Integer productId, OffsetDateTime productDate) {
        Product product = brandService.getBrandProductByDate(bradId, productId, productDate);
        return productResponseMapper.toProductResponseDto(product);
    }

}
