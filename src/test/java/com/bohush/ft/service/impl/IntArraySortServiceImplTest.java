package com.bohush.ft.service.impl;

import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.impl.IntArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArraySortServiceImplTest {
  IntArrayFactoryImpl factory = new IntArrayFactoryImpl();
  IntArraySortServiceImpl service;

  IntArray unsortedArray1;
  IntArray unsortedArray2;
  IntArray unsortedArray3;

  int[] EXPECTED_BUBBLE = {1, 2, 4, 5, 8};
  int[] EXPECTED_SHAKE = {-2, 0, 1, 3, 5};
  int[] EXPECTED_MERGE = {1, 5, 7, 8, 9, 10};

  @BeforeEach
  void setUp() throws IntArrayException {
    factory = new IntArrayFactoryImpl();
    service = new IntArraySortServiceImpl();

    unsortedArray1 = factory.create(1, new int[]{5, 1, 4, 2, 8});
    unsortedArray2 = factory.create(2, new int[]{3, 0, -2, 5, 1});
    unsortedArray3 = factory.create(3, new int[]{10, 7, 8, 9, 1, 5});
  }

  @Test
  void bubbleSort() throws IntArrayException {
    int[] expected = EXPECTED_BUBBLE;
    IntArray sorted = service.bubbleSort(unsortedArray1);
    int[] actual = sorted.getData();
    assertArrayEquals(expected, actual);
  }

  @Test
  void shakeSort() throws IntArrayException {
    int[] expected = EXPECTED_SHAKE;
    IntArray sorted = service.shakeSort(unsortedArray2);
    int[] actual = sorted.getData();
    assertArrayEquals(expected, actual);
  }

  @Test
  void mergeSort() throws IntArrayException {
    int[] expected = EXPECTED_MERGE;
    IntArray sorted = service.mergeSort(unsortedArray3);
    int[] actual = sorted.getData();
    assertArrayEquals(expected, actual);
  }
}