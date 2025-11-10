package com.ivanov.first.factory;
import com.ivanov.first.customarray.CustomArray;
import com.ivanov.first.exception.CustomArrayException;

public interface CustomArrayFactory {
  CustomArray create(long customArrayId, int size, int[] data) throws CustomArrayException;
}
