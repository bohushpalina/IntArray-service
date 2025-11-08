package com.ivanov.first.service;
import com.ivanov.first.customarray.CustomArray;
import java.util.function.IntPredicate;

public interface CustomArrayService {
  int findMaxElement(CustomArray customArray);
  int findMinElement(CustomArray customArray);
  double findAverageValue(CustomArray customArray);
  int findPositiveElementsCount(CustomArray customArray);
  int findNegativeElementsCount(CustomArray customArray);
  void replaceIf(CustomArray array, IntPredicate condition, int newValue);
}
