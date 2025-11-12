package com.ivanov.first.exception;

public class IntArrayException extends Exception {
  public IntArrayException() {
    super();
  }
  public IntArrayException(String message) {
    super(message);
  }
  public IntArrayException(String message, Throwable cause) {
    super(message, cause);
  }
}