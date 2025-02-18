package com.bcnc.demo.domain.model;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Product {

  private Integer brandId;

  private OffsetDateTime startDate;

  private OffsetDateTime endDate;

  private Integer priceList;

  private Integer productId;

  private Integer priority;

  private Double price;

  private Currency currency;
}
