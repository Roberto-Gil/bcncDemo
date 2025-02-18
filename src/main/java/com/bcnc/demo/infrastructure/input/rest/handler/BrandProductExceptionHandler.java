package com.bcnc.demo.infrastructure.input.rest.handler;

import com.bcnc.demo.application.exception.ProductNotFoundException;
import com.bcnc.demo.infrastructure.input.model.ProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BrandProductExceptionHandler {

  @ExceptionHandler({ProductNotFoundException.class})
  public ResponseEntity<ProductResponseDTO> handleNotFoundException() throws Throwable {
    return ResponseEntity.notFound().build();
  }
}
