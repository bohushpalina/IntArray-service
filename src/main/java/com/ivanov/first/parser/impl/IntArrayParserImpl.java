package com.ivanov.first.parser.impl;
import com.ivanov.first.parser.IntArrayParser;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntArrayParserImpl implements IntArrayParser {
  private static final String REGEX_DELIMITERS = "[;,\\-]";
  private static final String REPLACEMENT_SPACE = " ";
  private static final String REGEX_WHITESPACE = "\\s+";

  @Override
  public int[] parseLine(String line) {
    String normalized = line.replaceAll(REGEX_DELIMITERS, REPLACEMENT_SPACE);
    String[] tokens = normalized.split(REGEX_WHITESPACE);
    Stream<String> stringStream = Arrays.stream(tokens);
    IntStream stream = stringStream.mapToInt(Integer::parseInt);
    int[] result = stream.toArray();
    return result;
  }
}
