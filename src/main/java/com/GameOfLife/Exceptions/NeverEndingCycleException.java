package com.GameOfLife.Exceptions;

public class NeverEndingCycleException extends RuntimeException {
  public NeverEndingCycleException(String message) {
    super(message);
  }
}
