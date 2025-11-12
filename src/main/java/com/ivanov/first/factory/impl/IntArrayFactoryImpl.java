package com.ivanov.first.factory.impl;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;
import com.ivanov.first.factory.IntArrayFactory;

public class IntArrayFactoryImpl implements IntArrayFactory {
  @Override
  public IntArray create(long intArrayId, int size, int[] data) throws IntArrayException {
    return new IntArray(intArrayId, size, data);
  }
}
