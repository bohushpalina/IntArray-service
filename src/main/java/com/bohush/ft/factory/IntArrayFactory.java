package com.bohush.ft.factory;
import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;

public interface IntArrayFactory {
  IntArray create(long customArrayId, int[] data) throws IntArrayException;
}
