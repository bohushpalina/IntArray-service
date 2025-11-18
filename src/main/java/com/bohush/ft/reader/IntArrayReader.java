package com.bohush.ft.reader;
import com.bohush.ft.exception.IntArrayException;

import java.io.IOException;
import java.util.List;

public interface IntArrayReader {
  List<String> readLines(String filePath) throws IntArrayException;
}
