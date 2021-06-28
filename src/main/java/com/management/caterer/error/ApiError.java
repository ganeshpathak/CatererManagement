package com.management.caterer.error;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiError {

  int status;

  String path;

  Map<String, String> validationErrors;

  String message;

  long timestamp;

  public ApiError(int status, String message, String path) {
    super();
    this.timestamp = new Date().getTime();
    this.status = status;
    this.message = message;
    this.path = path;
  }
}
