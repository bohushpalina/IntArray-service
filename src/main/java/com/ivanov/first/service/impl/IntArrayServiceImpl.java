package com.ivanov.first.service.impl;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.service.IntArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.IntPredicate;

public class IntArrayServiceImpl implements IntArrayService {

  private static final Logger logger = LogManager.getLogger();

  @Override
  public int findMaxElement(IntArray intArray) {
    logger.info("Finding max element in array with size {}", intArray.getSize());
    int size = intArray.getSize();
    int[] data = intArray.getData();

    int max = data[0];
    for (int i = 0; i < size; ++i) {
      if (data[i] > max) {
        max = data[i];
      }
    }
    logger.debug("Max element found: {}", max);
    return max;
  }

  @Override
  public int findMinElement(IntArray intArray) {
    logger.info("Finding min element in array with size {}", intArray.getSize());
    int size = intArray.getSize();
    int[] data = intArray.getData();

    int min = data[0];
    for (int i = 0; i < size; ++i) {
      if (data[i] < min) {
        min = data[i];
      }
    }
    logger.debug("Min element found: {}", min);
    return min;
  }

  @Override
  public double findAverageValue(IntArray intArray) {
    logger.info("Calculating average value for array");
    int size = intArray.getSize();
    int[] data = intArray.getData();

    double sum = 0;
    for (int i = 0; i < size; ++i) {
      sum += data[i];
    }
    double avg = sum / size;
    logger.debug("Average value = {}", avg);
    return avg;
  }

  @Override
  public int findPositiveElementsCount(IntArray intArray) {
    logger.info("Counting positive elements");
    int size = intArray.getSize();
    int[] data = intArray.getData();

    int count = 0;
    for (int i = 0; i < size; ++i) {
      if (data[i] > 0) {
        count++;
      }
    }
    logger.debug("Positive elements count = {}", count);
    return count;
  }

  @Override
  public int findNegativeElementsCount(IntArray intArray) {
    logger.info("Counting negative elements");
    int size = intArray.getSize();
    int[] data = intArray.getData();

    int count = 0;
    for (int i = 0; i < size; ++i) {
      if (data[i] < 0) {
        count++;
      }
    }
    logger.debug("Negative elements count = {}", count);
    return count;
  }

  @Override
  public void replaceIf(IntArray array, IntPredicate condition, int newValue) {
    logger.info("Replacing elements by condition with new value = {}", newValue);
    int[] data = array.getData();
    int size = array.getSize();

    for (int i = 0; i < size; i++) {
      if (condition.test(data[i])) {
        logger.trace("Element {} -> {}", data[i], newValue);
        data[i] = newValue;
      }
    }
    logger.debug("Replacement finished.");
  }
}
