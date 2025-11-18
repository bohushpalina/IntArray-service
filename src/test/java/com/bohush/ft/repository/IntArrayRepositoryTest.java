package com.bohush.ft.repository;

import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.impl.IntArrayFactoryImpl;
import com.bohush.ft.repository.impl.SpecificationSumGreater;
import com.bohush.ft.service.IntArrayService;
import com.bohush.ft.service.impl.IntArrayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayRepositoryTest {

  private IntArray ARRAY_1;
  private IntArray ARRAY_2;
  private IntArray ARRAY_3;
  private IntArray ARRAY_4;

  private IntArrayFactoryImpl factory = new IntArrayFactoryImpl();
  private IntArrayService SERVICE = new IntArrayServiceImpl();
  private IntArrayRepository repository;

  private Comparator<IntArray> SORT_BY_MAX =
          ((a, b) -> Integer.compare(SERVICE.findMaxElement(a), SERVICE.findMaxElement(b)));


  @BeforeEach
  void setUp() throws IntArrayException {
    repository = IntArrayRepository.getInstance();
    repository.clear();

    ARRAY_1 = factory.create(1,  new int[]{1, 2, 3});
    ARRAY_2 = factory.create(2, new int[]{5, 1, 9});
    ARRAY_3 = factory.create(3, new int[]{0, 0, 10, 2});
    ARRAY_4 = factory.create(4, new int[]{-5, -3, -1});
  }

  @Test
  void getInstance() {
    IntArrayRepository expected = IntArrayRepository.getInstance();
    IntArrayRepository actual = IntArrayRepository.getInstance();
    assertSame(expected, actual);
  }

  @Test
  void add() {
    boolean expected = true;
    boolean actual = repository.add(ARRAY_1);
    assertEquals(expected, actual);
  }

  @Test
  void remove() {
    repository.add(ARRAY_1);
    boolean expected = true;
    boolean actual = repository.remove(ARRAY_1);
    assertEquals(expected, actual);
  }

  @Test
  void sort() {
    repository.add(ARRAY_1);
    repository.add(ARRAY_2);
    repository.add(ARRAY_3);
    repository.add(ARRAY_4);

    repository.sort(SORT_BY_MAX);

    List<IntArray> actual = repository.query(a -> true);

    List<IntArray> expected = List.of(
            ARRAY_4,
            ARRAY_1,
            ARRAY_2,
            ARRAY_3
    );

    assertEquals(expected, actual);
  }

  @Test
  void query() {
    repository.add(ARRAY_1);
    repository.add(ARRAY_2);
    repository.add(ARRAY_3);
    repository.add(ARRAY_4);

    Specification specification = new SpecificationSumGreater(10);

    List<IntArray> actual = repository.query(specification);
    List<IntArray> expected = List.of(ARRAY_2, ARRAY_3);

    assertEquals(expected, actual);
  }
}