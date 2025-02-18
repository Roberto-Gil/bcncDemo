package com.bcnc.demo.infrastructure.output.persistence.converters;

import com.bcnc.demo.domain.model.Currency;
import jakarta.persistence.AttributeConverter;

public class CurrencyConverter implements AttributeConverter<Currency, String> {

  @Override
  public String convertToDatabaseColumn(Currency currency) {
    return currency.name();
  }

  @Override
  public Currency convertToEntityAttribute(String s) {
    return Currency.valueOf(s);
  }
}
