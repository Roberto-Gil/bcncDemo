package com.bcnc.demo.infrastructure.output.persistence.entity;

import com.bcnc.demo.domain.model.Currency;
import com.bcnc.demo.infrastructure.output.persistence.converters.CurrencyConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTS")
@Data
@NoArgsConstructor
public class ProductEntity {

  @Id
  private Integer id;

  @Column(name = "BRAND_ID")
  private Integer brandId;

  @Column(name = "START_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime startDate;

  @Column(name = "END_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime endDate;

  @Column(name = "PRICE_LIST")
  private Integer priceList;

  @Column(name = "PRODUCT_ID")
  private Integer productId;

  @Column(name = "PRIORITY")
  private Integer priority;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "CURR")
  @Convert(converter = CurrencyConverter.class)
  private Currency currency;
}
