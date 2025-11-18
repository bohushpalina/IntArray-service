package com.bohush.ft.observer;
import com.bohush.ft.entity.IntArray;

import java.util.EventObject;

public class IntArrayEvent extends EventObject {

  public IntArrayEvent(IntArray source) {
    super(source);
  }

  public IntArray getSourceArray() {
    return (IntArray) getSource();
  }
}
