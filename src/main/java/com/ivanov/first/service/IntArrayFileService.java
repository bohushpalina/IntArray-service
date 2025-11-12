package com.ivanov.first.service;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;

import java.io.IOException;
import java.util.ArrayList;

public interface IntArrayFileService{
  ArrayList<IntArray> readArraysFromFile(String filePath) throws IOException, IntArrayException;
}
