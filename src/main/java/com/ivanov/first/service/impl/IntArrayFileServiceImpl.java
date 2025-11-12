package com.ivanov.first.service.impl;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;
import com.ivanov.first.factory.IntArrayFactory;
import com.ivanov.first.factory.impl.IntArrayFactoryImpl;
import com.ivanov.first.parser.IntArrayParser;
import com.ivanov.first.parser.impl.IntArrayParserImpl;
import com.ivanov.first.reader.IntArrayReader;
import com.ivanov.first.reader.impl.IntArrayReaderImpl;
import com.ivanov.first.service.IntArrayFileService;
import com.ivanov.first.validator.IntArrayValidator;
import com.ivanov.first.validator.impl.IntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntArrayFileServiceImpl implements IntArrayFileService {

  private static final Logger log = LogManager.getLogger(IntArrayFileServiceImpl.class);
  private final IntArrayReader reader = new IntArrayReaderImpl();
  private final IntArrayValidator validator = new IntArrayValidatorImpl();
  private final IntArrayParser parser = new IntArrayParserImpl();
  private final IntArrayFactory factory = new IntArrayFactoryImpl();

  @Override
  public ArrayList<IntArray> readArraysFromFile(String filePath) throws IOException, IntArrayException {
    log.info("Started reading from file");
    List<String> lines = reader.readLines(filePath);
    ArrayList<IntArray> arrays = new ArrayList<>();
    long idCounter = 1;

    for (String line : lines) {
      if (validator.isValid(line)) {
        int[] data = parser.parseLine(line);
        IntArray intArray = factory.create(idCounter++, data.length, data);
        arrays.add(intArray);
      } else {
        String msg = "Invalid line in file: '" + line + "'" + "Skipped";
        log.info(msg);
      }
    }
    log.info("File was read successful!");
    return arrays;
  }
}
