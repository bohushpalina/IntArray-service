package com.ivanov.first.service.impl;

import com.ivanov.first.customarray.CustomArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayServiceImplTest {
  CustomArray ARRAY = new CustomArray(1, 5, new int[]{1, 2, 3, 4, 5});
  CustomArray ARRAY_FOR_REPLACE = new CustomArray(2, 5, new int[]{1, -2, 3, -4, 5});
  int MAX_ELEMENT = 5;
  int MIN_ELEMENT = 1;
  double AVERAGE_VALUE = 3.0;
  int POSITIVE_COUNT = 5;
  int NEGATIVE_COUNT = 0;
  CustomArrayServiceImpl service = new CustomArrayServiceImpl();

  @Test
  void findMaxElement() {
    CustomArray array = ARRAY;
    int actual = service.findMaxElement(array);
    assertEquals(MAX_ELEMENT, actual);
  }

  @Test
  void findMinElement() {
    CustomArray array = ARRAY;
    int actual = service.findMinElement(array);
    assertEquals(MIN_ELEMENT, actual);
  }

  @Test
  void findAverageValue() {
    CustomArray array = ARRAY;
    double actual = service.findAverageValue(array);
    assertEquals(AVERAGE_VALUE, actual);
  }

  @Test
  void findPositiveElementsCount() {
    CustomArray array = ARRAY;
    int actual = service.findPositiveElementsCount(array);
    assertEquals(POSITIVE_COUNT, actual);
  }

  @Test
  void findNegativeElementsCount() {
    CustomArray array = ARRAY;
    int actual = service.findNegativeElementsCount(array);
    assertEquals(NEGATIVE_COUNT, actual);
  }

  @Test
  void replaceIf() {
    CustomArray array = ARRAY_FOR_REPLACE;
    service.replaceIf(array, x -> x < 0, 0);
    int[] actual = array.getData();
    int[] expected = {1, 0, 3, 0, 5};
    assertArrayEquals(expected, actual);
  }
}