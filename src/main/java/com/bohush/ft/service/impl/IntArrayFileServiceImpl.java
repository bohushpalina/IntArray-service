package com.bohush.ft.service.impl;
import com.bohush.ft.entity.IntArray;
import com.bohush.ft.exception.IntArrayException;
import com.bohush.ft.factory.IntArrayFactory;
import com.bohush.ft.factory.impl.IntArrayFactoryImpl;
import com.bohush.ft.parser.IntArrayParser;
import com.bohush.ft.parser.impl.IntArrayParserImpl;
import com.bohush.ft.reader.IntArrayReader;
import com.bohush.ft.reader.impl.IntArrayReaderImpl;
import com.bohush.ft.service.IntArrayFileService;
import com.bohush.ft.validator.IntArrayValidator;
import com.bohush.ft.validator.impl.IntArrayValidatorImpl;
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
        IntArray intArray = factory.create(idCounter++, data);
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
