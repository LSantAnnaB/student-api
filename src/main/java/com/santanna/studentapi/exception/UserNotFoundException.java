package com.santanna.studentapi.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String msg) {
    super(msg);
  }
}
