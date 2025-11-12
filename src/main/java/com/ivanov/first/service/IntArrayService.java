package com.ivanov.first.service;
import com.ivanov.first.entity.IntArray;
import java.util.function.IntPredicate;

public interface IntArrayService {
  int findMaxElement(IntArray intArray);
  int findMinElement(IntArray intArray);
  double findAverageValue(IntArray intArray);
  int findPositiveElementsCount(IntArray intArray);
  int findNegativeElementsCount(IntArray intArray);
  void replaceIf(IntArray array, IntPredicate condition, int newValue);
}
