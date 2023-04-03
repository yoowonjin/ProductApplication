package com.kh.product.web;

import com.kh.product.web.exception.RestBizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(assignableTypes = RestProductController.class)
public class RestExHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(RestBizException.class)
  public RestResponse<Object> BizExHandle(RestBizException e) {
    return RestResponse.createRestResponse(e.getCode(), e.getMessage(), null);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public RestResponse<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    Map<String, String> errors = new HashMap<>();

    bindingResult.getFieldErrors().forEach(fieldError -> {
      String fieldName = fieldError.getField();
      String errorMessage = fieldError.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    return RestResponse.createRestResponse("99", "실패", errors);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Exception.class)
  public RestResponse<Object> BizExHandle(Exception e) {
    return RestResponse.createRestResponse("99", e.getMessage(), null);
  }

}
