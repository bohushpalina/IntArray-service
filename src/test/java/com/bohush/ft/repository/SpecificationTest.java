package com.bohush.ft.repository;

import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.impl.IntArrayFactoryImpl;
import com.bohush.ft.repository.impl.SpecificationId;
import com.bohush.ft.repository.impl.SpecificationMaxLess;
import com.bohush.ft.repository.impl.SpecificationSumGreater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

  private IntArray ARRAY_1;
  private IntArray ARRAY_2;
  private IntArray ARRAY_3;

  private IntArrayFactoryImpl factory = new IntArrayFactoryImpl();

  @BeforeEach
  void setUp() throws IntArrayException {
    ARRAY_1 = factory.create(1, new int[]{1, 2, 3});
    ARRAY_2 = factory.create(2, new int[]{5, 10, 20});
    ARRAY_3 = factory.create(3, new int[]{-2});
  }

  @Test
  void testSpecificationId() {
    Specification specification = new SpecificationId(1);

    boolean expected1 = true;
    boolean actual1 = specification.specify(ARRAY_1);
    assertEquals(expected1, actual1);

    boolean expected2 = false;
    boolean actual2 = specification.specify(ARRAY_2);
    assertEquals(expected2, actual2);
  }

  @Test
  void testSpecificationMaxLess() {
    Specification specification = new SpecificationMaxLess(10);

    boolean expected1 = true;
    boolean actual1 = specification.specify(ARRAY_1);
    assertEquals(expected1, actual1);

    boolean expected2 = false;
    boolean actual2 = specification.specify(ARRAY_2);
    assertEquals(expected2, actual2);

    boolean expected3 = true;
    boolean actual3 = specification.specify(ARRAY_3);
    assertEquals(expected3, actual3);
  }

  @Test
  void testSpecificationSumGreater() {
    Specification specification = new SpecificationSumGreater(10);

    boolean expected1 = false;
    boolean actual1 = specification.specify(ARRAY_1);
    assertEquals(expected1, actual1);

    boolean expected2 = true;
    boolean actual2 = specification.specify(ARRAY_2);
    assertEquals(expected2, actual2);

    boolean expected3 = false;
    boolean actual3 = specification.specify(ARRAY_3);
    assertEquals(expected3, actual3);
  }
}