package com.ivanov.first.observer;
import com.ivanov.first.entity.IntArray;

public class IntArrayEvent {
  private IntArray array;

  public IntArrayEvent(IntArray array) {
    this.array = array;
  }

  public IntArray getIntArray() {
    return array;
  }
}
