package com.kh.product.web.rest;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SaveRest {

  @NotNull
  @Size(min=1,max=10)
  private String pname;

  @NotNull
  @Positive
  @Max(9999)
  private Long quantity;


  @NotNull
  @Positive //양수
  @Min(100) //최소값
  private Long price;
}
