package com.ivanov.first.service.impl;

import com.ivanov.first.customarray.CustomArray;
import com.ivanov.first.exception.CustomArrayException;
import com.ivanov.first.factory.impl.CustomArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayServiceImplTest {

  CustomArrayFactoryImpl factory = new CustomArrayFactoryImpl();
  CustomArray array;
  CustomArray arrayForReplace;

  int MAX_ELEMENT = 5;
  int MIN_ELEMENT = 1;
  double AVERAGE_VALUE = 3.0;
  int POSITIVE_COUNT = 5;
  int NEGATIVE_COUNT = 0;
  CustomArrayServiceImpl service = new CustomArrayServiceImpl();

  @BeforeEach
  void setUp() throws CustomArrayException {
    factory = new CustomArrayFactoryImpl();
    service = new CustomArrayServiceImpl();

    array = factory.create(1, 5, new int[]{1, 2, 3, 4, 5});
    arrayForReplace = factory.create(2, 5, new int[]{1, -2, 3, -4, 5});
  }

  @Test
  void findMaxElement() {
    int actual = service.findMaxElement(array);
    assertEquals(MAX_ELEMENT, actual);
  }

  @Test
  void findMinElement() {
    int actual = service.findMinElement(array);
    assertEquals(MIN_ELEMENT, actual);
  }

  @Test
  void findAverageValue() {
    double actual = service.findAverageValue(array);
    assertEquals(AVERAGE_VALUE, actual);
  }

  @Test
  void findPositiveElementsCount() {
    int actual = service.findPositiveElementsCount(array);
    assertEquals(POSITIVE_COUNT, actual);
  }

  @Test
  void findNegativeElementsCount() {
    int actual = service.findNegativeElementsCount(array);
    assertEquals(NEGATIVE_COUNT, actual);
  }

  @Test
  void replaceIf() {
    service.replaceIf(arrayForReplace, x -> x < 0, 0);
    int[] actual = arrayForReplace.getData();
    int[] expected = {1, 0, 3, 0, 5};
    assertArrayEquals(expected, actual);
  }
}