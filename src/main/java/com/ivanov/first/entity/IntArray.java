package com.ivanov.first.entity;

import com.ivanov.first.exception.IntArrayException;

import java.util.Arrays;

public class IntArray {
  private long intArrayId;
  private int size;
  private int[] data;

  public IntArray() {
    super();
  }

  public IntArray(long intArrayId, int size, int[] data) throws IntArrayException {
    if (data == null) {
      throw new IntArrayException("Input array cannot be null.");
    }
    if (size <= 0) {
      throw new IntArrayException("Size must be greater than zero.");
    }
    if (size > data.length) {
      throw new IntArrayException("Size cannot exceed input array length.");
    }
    this.size = size;
    this.data = Arrays.copyOf(data, this.size);
  }

  public long getIntArrayId() {
    return intArrayId;
  }

  public void setIntArrayId(long intArrayId) {
    this.intArrayId = intArrayId;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int[] getData() {
    return data;
  }

  public void setData(int[] data) {
    this.data = data;
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
            ", size=" + size +
            ", data=" + Arrays.toString(data) +
            '}';
  }
}
