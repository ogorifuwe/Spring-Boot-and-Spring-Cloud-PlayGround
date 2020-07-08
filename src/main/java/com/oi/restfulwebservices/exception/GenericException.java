package com.oi.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class GenericException {

  private Date timestamp;
  private String message;
  private String details;


}
