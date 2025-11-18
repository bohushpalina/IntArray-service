package com.bohush.ft.parser.impl;
import com.bohush.ft.parser.IntArrayParser;
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
    int[] result = Arrays.stream(normalized.split(REGEX_WHITESPACE))
            .filter(s -> !s.isEmpty())
            .mapToInt(Integer::parseInt)
            .toArray();
    return result;
  }
}
