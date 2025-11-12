package com.ivanov.first.service;
import com.ivanov.first.entity.IntArray;
import java.util.function.IntPredicate;

public interface IntArrayService {
  int findMaxElement(IntArray intArray);
  int findMinElement(IntArray intArray);
  double findAverageValue(IntArray intArray);
  long findPositiveElementsCount(IntArray intArray);
  long findNegativeElementsCount(IntArray intArray);
  void replaceIf(IntArray array, IntPredicate condition, int newValue);
}
