package com.ivanov.first.service.impl;

import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayFileServiceImplTest {

  private static final String TEST_FILE_CONTENT = String.join("\n",
          "1 2 3 4",
          "5 6 seven 8",
          "9 10 11",
          "12 thirteen 14",
          "15 16 17 18",
          "12, 34, -56, 89"
  );

  private String TEST_FILE_PATH = "src/main/resources/data/test_input.txt";

  private int[][] EXPECTED_ARRAYS = {
          {1, 2, 3, 4},
          {9, 10, 11},
          {15, 16, 17, 18},
          {12, 34, -56, 89}
  };
  IntArrayFileServiceImpl service = new IntArrayFileServiceImpl();

  @Test
  void readArraysFromFile() throws Exception {
    File file = new File(TEST_FILE_PATH);
    try (FileWriter writer = new FileWriter(file)) {
      writer.write(TEST_FILE_CONTENT);
    }

    ArrayList<IntArray> actualArrays = service.readArraysFromFile(TEST_FILE_PATH);
    assertEquals(EXPECTED_ARRAYS.length, actualArrays.size());

    assertArrayEquals(EXPECTED_ARRAYS[0], actualArrays.get(0).getData());
    assertArrayEquals(EXPECTED_ARRAYS[1], actualArrays.get(1).getData());
    assertArrayEquals(EXPECTED_ARRAYS[2], actualArrays.get(2).getData());

    assertTrue(file.delete());
  }
}