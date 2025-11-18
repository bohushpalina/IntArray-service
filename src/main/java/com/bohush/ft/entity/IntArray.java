package com.bohush.ft.entity;

import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.observer.IntArrayObservable;
import com.bohush.ft.observer.IntArrayObserver;
import com.bohush.ft.observer.impl.IntArrayObservableImpl;

import java.util.Arrays;

public class IntArray implements IntArrayObservable {
  private long intArrayId;
  private int[] data;
  private IntArrayObservable observable = new IntArrayObservableImpl(this);

  public IntArray() {
    super();
  }

  public IntArray(long intArrayId, int[] data) throws IntArrayException {
    this.intArrayId = intArrayId;
    if (data == null) {
      throw new IntArrayException("Input array cannot be null.");
    }
    this.data = Arrays.copyOf(data, data.length);
  }

  public long getIntArrayId() {
    return intArrayId;
  }

  public void setIntArrayId(long intArrayId) {
    this.intArrayId = intArrayId;
  }

  public int getSize() {
    return data.length;
  }

  public int[] getData() {
    return data;
  }

  public void setData(int[] data) {
    this.data = Arrays.copyOf(data, data.length);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    IntArray that = (IntArray) o;
    return getIntArrayId() == that.getIntArrayId() && getSize() == that.getSize() && Arrays.equals(getData(), that.getData());
  }

  @Override
  public int hashCode() {
    int result = Long.hashCode(getIntArrayId());
    result = 31 * result + getSize();
    result = 31 * result + Arrays.hashCode(getData());
    return result;
  }

  @Override
  public String toString() {
    return "IntArray{" +
            "customArrayId=" + intArrayId +
            ", size=" + data.length +
            ", data=" + Arrays.toString(data) +
            '}';
  }

  @Override
  public void attach(IntArrayObserver observer) {
    observable.attach(observer);
  }

  @Override
  public void detach(IntArrayObserver observer) {
    observable.detach(observer);
  }

  @Override
  public void notifyObservers() {
    observable.notifyObservers();
  }
}
