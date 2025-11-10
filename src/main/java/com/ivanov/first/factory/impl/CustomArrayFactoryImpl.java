package com.ivanov.first.factory.impl;
import com.ivanov.first.customarray.CustomArray;
import com.ivanov.first.exception.CustomArrayException;
import com.ivanov.first.factory.CustomArrayFactory;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
  @Override
  public CustomArray create(long customArrayId, int size, int[] data) throws CustomArrayException {
    return new CustomArray(customArrayId, size, data);
  }
}
