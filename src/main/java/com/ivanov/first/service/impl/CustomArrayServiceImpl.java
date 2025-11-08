package com.ivanov.first.service.impl;
import com.ivanov.first.customarray.CustomArray;
import com.ivanov.first.service.CustomArrayService;
import java.util.function.IntPredicate;

public class CustomArrayServiceImpl implements CustomArrayService {

  @Override
  public int findMaxElement(CustomArray customArray) {
    int size = customArray.getSize();
    int[] data = customArray.getData();

    int max = data[0];
    for (int i = 0; i < size; ++i)
    {
      if (data[i] > max)
      {
        max = data[i];
      }
    }
    return max;
  }

  @Override
  public int findMinElement(CustomArray customArray) {
    int size = customArray.getSize();
    int[] data = customArray.getData();

    int min = data[0];
    for (int i = 0; i < size; ++i)
    {
      if (data[i] < min)
      {
        min = data[i];
      }
    }
    return min;
  }

  @Override
  public double findAverageValue(CustomArray customArray) {
    int size = customArray.getSize();
    int[] data = customArray.getData();

    double sum = 0;
    for (int i = 0; i < size; ++i)
    {
      sum += data[i];
    }
    return sum / size;
  }

  @Override
  public int findPositiveElementsCount(CustomArray customArray) {
    int size = customArray.getSize();
    int[] data = customArray.getData();

    int count = 0;
    for (int i = 0; i < size; ++i)
    {
      if (data[i] > 0)
      {
        count += 1;
      }
    }
    return count;
  }

  @Override
  public int findNegativeElementsCount(CustomArray customArray) {
    int size = customArray.getSize();
    int[] data = customArray.getData();

    int count = 0;
    for (int i = 0; i < size; ++i)
    {
      if (data[i] < 0)
      {
        count += 1;
      }
    }
    return count;
  }

  @Override
  public void replaceIf(CustomArray array, IntPredicate condition, int newValue) {
    int[] data = array.getData();
    int size = array.getSize();

    for (int i = 0; i < size; i++) {
      if (condition.test(data[i])) {
        data[i] = newValue;
      }
    }
  }

}
