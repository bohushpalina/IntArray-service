package com.ivanov.first.service;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;

public interface IntArraySort {
  IntArray bubbleSort(IntArray intArray) throws IntArrayException;
  IntArray shakeSort(IntArray intArray) throws IntArrayException;
  IntArray mergeSort(IntArray intArray) throws IntArrayException;
}
