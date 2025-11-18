package com.bohush.ft.factory.impl;
import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.IntArrayFactory;

public class IntArrayFactoryImpl implements IntArrayFactory {
  @Override
  public IntArray create(long intArrayId, int[] data) throws IntArrayException {
    return new IntArray(intArrayId, data);
  }
}
