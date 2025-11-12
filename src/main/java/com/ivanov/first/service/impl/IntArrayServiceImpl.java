package com.ivanov.first.service.impl;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.service.IntArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class IntArrayServiceImpl implements IntArrayService {

  private static final Logger logger = LogManager.getLogger();

  @Override
  public int findMaxElement(IntArray intArray) {
    logger.info("Finding max element in array with size {}", intArray.getSize());

    int[] data = intArray.getData();
    Arrays.stream(data);
    int max = Arrays.stream(data).max().orElseThrow();

    logger.debug("Max element found: {}", max);
    return max;
  }

  @Override
  public int findMinElement(IntArray intArray) {
    logger.info("Finding min element in array with size {}", intArray.getSize());

    int[] data = intArray.getData();
    Arrays.stream(data);
    int min = Arrays.stream(data).min().orElseThrow();

    logger.debug("Min element found: {}", min);
    return min;
  }

  @Override
  public double findAverageValue(IntArray intArray) {
    logger.info("Calculating average value for array");

    int[] data = intArray.getData();
    Arrays.stream(data);
    double avg = Arrays.stream(data).average().orElseThrow();

    logger.debug("Average value = {}", avg);
    return avg;
  }

  @Override
  public long findPositiveElementsCount(IntArray intArray) {
    logger.info("Counting positive elements");

    int[] data = intArray.getData();
    Arrays.stream(data);
    long count = Arrays.stream(data).filter(x -> x > 0).count();

    logger.debug("Positive elements count = {}", count);
    return count;
  }

  @Override
  public long findNegativeElementsCount(IntArray intArray) {
    logger.info("Counting negative elements");

    int[] data = intArray.getData();
    Arrays.stream(data);
    long count = Arrays.stream(data).filter(x -> x < 0).count();

    logger.debug("Negative elements count = {}", count);
    return count;
  }

  @Override
  public void replaceIf(IntArray array, IntPredicate condition, int newValue) {
    logger.info("Replacing elements by condition with new value = {}", newValue);

    int[] data = array.getData();
    Arrays.setAll(data, i -> {
      int val = data[i];
      if (condition.test(val)) {
        return newValue;
      }
      return val;
    });

    logger.debug("Replacement finished.");
  }
}
