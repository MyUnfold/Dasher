package com.app.dasher.exceptions;

public class ObjectNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String message;

  public ObjectNotFoundException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
