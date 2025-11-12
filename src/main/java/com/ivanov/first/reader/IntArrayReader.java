package com.ivanov.first.reader;
import java.io.IOException;
import java.util.List;

public interface IntArrayReader {
  List<String> readLines(String filePath) throws IOException;
}
