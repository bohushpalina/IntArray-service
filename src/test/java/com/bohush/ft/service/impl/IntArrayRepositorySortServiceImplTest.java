package com.bohush.ft.service.impl;

import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.impl.IntArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayRepositorySortServiceImplTest {
  private IntArrayFactoryImpl factory = new IntArrayFactoryImpl();
  private IntArray array1;
  private IntArray array2;
  private IntArray array3;
  private IntArrayRepositorySortServiceImpl service;

  @BeforeEach
  void setUp() throws IntArrayException {
    array1 = factory.create(1, new int[]{1, 2, 3});
    array2 = factory.create(2, new int[]{5, 1, 9});
    array3 = factory.create(3, new int[]{0, 0, 10, 2});

    service = new IntArrayRepositorySortServiceImpl();
  }

  @Test
  void sort() {
    List<IntArray> input = List.of(array1, array2, array3);

    Comparator<IntArray> comparator = (a, b) -> Integer.compare(
            Arrays.stream(a.getData()).max().getAsInt(),
            Arrays.stream(b.getData()).max().getAsInt()
    );
    List<IntArray> actual = service.sort(input, comparator);
    List<IntArray> expected = List.of(array1, array2, array3);
    assertEquals(expected, actual);
  }
}