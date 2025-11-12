package com.ivanov.first.factory;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;

public interface IntArrayFactory {
  IntArray create(long customArrayId, int size, int[] data) throws IntArrayException;
}
