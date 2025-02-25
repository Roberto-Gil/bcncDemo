package com.bcnc.demo.infrastructure.output.persistence.repository;

import com.bcnc.demo.infrastructure.output.persistence.entity.ProductEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where "
            + "p.startDate <= :productDate AND p.endDate >= :productDate AND "
            + "p.brandId = :brandId AND p.productId = :productId order by p.priority desc")
    Optional<ProductEntity> findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId,
                                                             OffsetDateTime productDate, Limit limit);

}
