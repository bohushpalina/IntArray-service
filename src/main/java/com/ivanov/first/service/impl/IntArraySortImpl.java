package com.ivanov.first.service.impl;

import com.ivanov.first.entity.IntArray;
import com.ivanov.first.exception.IntArrayException;
import com.ivanov.first.factory.impl.IntArrayFactoryImpl;
import com.ivanov.first.service.IntArraySort;

public class IntArraySortImpl implements IntArraySort {

  IntArrayFactoryImpl factory = new IntArrayFactoryImpl();

  @Override
  public IntArray bubbleSort(IntArray intArray) throws IntArrayException {
    int[] data = intArray.getData().clone();
    int size = intArray.getSize();

    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (data[j] > data[j + 1]) {
          int temp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = temp;
        }
      }
    }

    return factory.create(intArray.getIntArrayId(), size, data);
  }

  @Override
  public IntArray shakeSort(IntArray intArray) throws IntArrayException {
    int[] data = intArray.getData().clone();
    int size = intArray.getSize();
    boolean swapped;
    int left = 0;
    int right = size - 1;

    do {
      swapped = false;
      for (int i = left; i < right; i++) {
        if (data[i] > data[i + 1]) {
          int temp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = temp;
          swapped = true;
        }
      }
      right--;

      for (int i = right; i > left; i--) {
        if (data[i] < data[i - 1]) {
          int temp = data[i];
          data[i] = data[i - 1];
          data[i - 1] = temp;
          swapped = true;
        }
      }
      left++;
    } while (swapped);

    return factory.create(intArray.getIntArrayId(), size, data);
  }

  @Override
  public IntArray mergeSort(IntArray intArray) throws IntArrayException {
    int[] data = intArray.getData().clone();
    return factory.create(intArray.getIntArrayId(), data.length, data);
  }

  private void mergeSortRecursive(int[] data, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSortRecursive(data, left, mid);
      mergeSortRecursive(data, mid + 1, right);
      merge(data, left, mid, right);
    }
  }

  private void merge(int[] data, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    System.arraycopy(data, left, L, 0, n1);
    System.arraycopy(data, mid + 1, R, 0, n2);

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        data[k++] = L[i++];
      } else {
        data[k++] = R[j++];
      }
    }
    while (i < n1) {
      data[k++] = L[i++];
    }
    while (j < n2) {
      data[k++] = R[j++];
    }
  }
}
