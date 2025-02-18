package com.bcnc.demo.infrastructure.output.persistence.repository;

import com.bcnc.demo.infrastructure.output.persistence.entity.ProductEntity;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  @Query("select p from ProductEntity p where "
      + "p.startDate <= :productDate AND p.endDate >= :productDate AND "
      + "p.brandId = :brandId AND p.productId = :productId")
  List<ProductEntity> findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId,
      OffsetDateTime productDate);

}
