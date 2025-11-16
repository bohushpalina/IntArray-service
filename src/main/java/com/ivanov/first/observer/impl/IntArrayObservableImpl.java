package com.ivanov.first.observer.impl;

import com.ivanov.first.entity.IntArray;
import com.ivanov.first.observer.IntArrayEvent;
import com.ivanov.first.observer.IntArrayObservable;
import com.ivanov.first.observer.IntArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class IntArrayObservableImpl implements IntArrayObservable {
  private static final Logger log = LogManager.getLogger();
  private final List<IntArrayObserver> observers = new ArrayList<>();
  private IntArray array;

  public IntArrayObservableImpl(IntArray array) {
    this.array = array;
    log.info("Observable created for IntArray id={}", array.getIntArrayId());
  }

  @Override
  public void attach(IntArrayObserver observer) {
    observers.add(observer);
    log.info("Observer attached. Total observers: {}", observers.size());
  }

  @Override
  public void detach(IntArrayObserver observer) {
    observers.remove(observer);
    log.info("Observer detached. Total observers: {}", observers.size());
  }

  @Override
  public void notifyObservers() {
    log.info("Notifying {} observers about update of array id={}", observers.size(), array.getIntArrayId());
    IntArrayEvent event = new IntArrayEvent(array);
    for (IntArrayObserver observer : observers) {
      observer.arrayUpdated(event);
    }
  }
}
