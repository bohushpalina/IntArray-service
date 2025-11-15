package com.ivanov.first.observer.impl;

import com.ivanov.first.entity.IntArray;
import com.ivanov.first.observer.IntArrayEvent;
import com.ivanov.first.observer.IntArrayObserver;
import warehouse.IntArrayParameters;

public class IntArrayObserverImpl implements IntArrayObserver {

  @Override
  public void arrayUpdated(IntArrayEvent event) {
    IntArray array = event.getIntArray();

    int min = array.min();
    int max = array.max();
    int sum = array.sum();
    double average = array.average();

    IntArrayParameters params = new IntArrayParameters(min, max, sum, average);

    Warehouse.getInstance().putParameters(array.getIntArrayId(), params);
  }
}
