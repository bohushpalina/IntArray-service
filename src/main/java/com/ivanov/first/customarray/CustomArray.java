package com.ivanov.first.customarray;

import java.util.Arrays;

public class CustomArray {
  private long customArrayId;
  private int size;
  private int[] data;

  public CustomArray() {
    super();
  }

  public CustomArray(long customArrayId, int size, int[] data) {
    if (size > data.length) {
      this.size = data.length;
    } else {
      this.size = size;
    }
    this.data = Arrays.copyOf(data, this.size);
  }

  public long getCustomArrayId() {
    return customArrayId;
  }

  public void setCustomArrayId(long customArrayId) {
    this.customArrayId = customArrayId;
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

    CustomArray that = (CustomArray) o;
    return getCustomArrayId() == that.getCustomArrayId() && getSize() == that.getSize() && Arrays.equals(getData(), that.getData());
  }

  @Override
  public int hashCode() {
    int result = Long.hashCode(getCustomArrayId());
    result = 31 * result + getSize();
    result = 31 * result + Arrays.hashCode(getData());
    return result;
  }

  @Override
  public String toString() {
    return "CustomArray{" +
            "customArrayId=" + customArrayId +
            ", size=" + size +
            ", data=" + Arrays.toString(data) +
            '}';
  }
}
